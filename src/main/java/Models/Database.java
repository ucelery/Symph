package Models;

// General Database
import Utilities.Song;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

// Song Database
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.mongodb.client.MongoCollection;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.bson.Document;

public class Database {    
    MongoClient mongoClient;
    MongoDatabase database;
    GridFSBucket gridFSBucket;
    Cloudinary cloudinary;
    
    ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
    int _threadCount = 0;
    
    public Database() {  
        Dotenv dotenv = Dotenv.load();
        
        // execute MongoDB thread
        executor.submit(() -> {
            _threadCount++;
            System.out.println("[ LOADING ] MongoDB");
            mongoClient = MongoClients.create("mongodb+srv://" + dotenv.get("MONGO_USERNAME") + ":" + dotenv.get("MONGO_PASSWORD") + "@cluster0.xvzkkrp.mongodb.net/?retryWrites=true&w=majority");
            database = mongoClient.getDatabase("Symph");
            gridFSBucket = GridFSBuckets.create(database, "songs");
            
            System.out.println("[ READY ] MongoDB");
            _threadCount--;

            invokeExecutorFinish("[ APP ] Application is Ready!");
            return null;
        });
        
        // execute Cloudinary thread
        executor.submit(() -> {
            _threadCount++;
            System.out.println("[ LOADING ] Cloudinary");

            cloudinary = new Cloudinary("cloudinary://" + dotenv.get("CLOUDINARY_API_KEY") + ":" + dotenv.get("CLOUDINARY_API_SECRET") + "@" + dotenv.get("CLOUDINARY_NAME"));
            cloudinary.config.secure = true;
            
            System.out.println("[ READY ] Cloudinary");
            _threadCount--;
            
            invokeExecutorFinish("[ APP ] Application is Ready!");
            return null;
        });
    }
    
    private boolean invokeExecutorFinish(String msg) {
        if (msg != null && _threadCount <= 0)
            System.out.println(msg);
        
        return _threadCount <= 0;
    }
    
    public void insertSong(Song song) {
        File audioFile = song.audioFile;
        File coverFile = song.coverFile;
        
        // Upload the song and image cover
        executor.submit(() -> {
            Map<?, ?> audioRes = cloudinary.uploader().upload(audioFile, ObjectUtils.asMap(
                    "resource_type", "video",
                    "use_filename", true,
                    "unique_filename", false,
                    "overwrite", true
            ));
            
            Map<?, ?> imageRes = cloudinary.uploader().upload(coverFile, ObjectUtils.asMap(
                "use_filename", true,
                "unique_filename", false,
                "overwrite", true
            ));
            
            // Upload details to mongo
            MongoCollection<Document> collection = database.getCollection("songs");
            Document doc = new Document("artist", song.artist)
                    .append("title", song.title)
                    .append("imageURL", imageRes.get("secure_url"))
                    .append("audioURL", audioRes.get("secure_url"));

            collection.insertOne(doc);
            return null;
        });
        

    }
}
