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
import com.mongodb.client.MongoCursor;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.bson.Document;

public class Database {    
    MongoClient mongoClient;
    MongoDatabase database;
    GridFSBucket gridFSBucket;
    Cloudinary cloudinary;
    
    Dotenv dotenv = Dotenv.load();
    
    ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
    int _threadCount = 0;
    
    public Database() {  
        System.out.println("[ WARNING ] Initialize MongoDB and Cloudinary manually.");
    }
    
    public void initializeMongoDB() {
        mongoClient = MongoClients.create("mongodb+srv://" + dotenv.get("MONGO_USERNAME") + ":" + dotenv.get("MONGO_PASSWORD") + "@cluster0.xvzkkrp.mongodb.net/?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("Symph");
        gridFSBucket = GridFSBuckets.create(database, "songs");
    }
    
    public void initializeCloudinary() {
        cloudinary = new Cloudinary("cloudinary://" + dotenv.get("CLOUDINARY_API_KEY") + ":" + dotenv.get("CLOUDINARY_API_SECRET") + "@" + dotenv.get("CLOUDINARY_NAME"));
        cloudinary.config.secure = true;    
    }
    
    private boolean invokeExecutorFinish(String msg) {
        if (msg != null && _threadCount <= 0)
            System.out.println(msg);
        
        return _threadCount <= 0;
    }
    
    public void insertSong(Song song) {
        File audioFile = song.getAudioFile();
        File coverFile = song.getCoverFile();
        
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
            Document doc = new Document("artist", song.getArtist())
                    .append("title", song.getTitle())
                    .append("imageURL", imageRes.get("secure_url"))
                    .append("audioURL", audioRes.get("secure_url"));

            collection.insertOne(doc);
            return null;
        });
    }
    
    public Future<ArrayList<Song>> getSongsData() {
        ArrayList<Song> resSongs = new ArrayList();
        
        return executor.submit(() -> {
            // Retrieve Data
            MongoCollection<Document> col = database.getCollection("songs");
            MongoCursor<Document> cursor = col.find().iterator();

            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Song song = new Song();
                song.setArtist(doc.getString("artist"));
                song.setTitle(doc.getString("title"));
                song.setImageURL(doc.getString("imageURL"));
                song.setAudioURL(doc.getString("audioURL"));
                
                resSongs.add(song);
            }
            
            return resSongs;
        });
    }
}
