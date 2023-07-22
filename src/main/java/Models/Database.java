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
import com.mongodb.client.result.InsertOneResult;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;

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
    
    public CompletableFuture<Song> insertSong(Song song) {
        CompletableFuture<Song> future = new CompletableFuture<Song>();
        
        File audioFile = song.getAudioFile();
        File coverFile = song.getCoverFile();
        
        // Upload the song and image cover
        new Thread(() -> {
            try {
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

                AudioFile audioFileObj = AudioFileIO.read(song.getAudioFile());
                int duration = audioFileObj.getAudioHeader().getTrackLength();
                
                // Upload details to mongo
                System.out.println("Is this thing working");
                MongoCollection<Document> collection = database.getCollection("songs");
                Document doc = new Document("artist", song.getArtist())
                        .append("title", song.getTitle())
                        .append("imageURL", imageRes.get("secure_url"))
                        .append("audioURL", audioRes.get("secure_url"))
                        .append("duration", duration);

                collection.insertOne(doc);
                
                song.setAudioURL(audioRes.get("secure_url").toString());
                song.setImageURL(audioRes.get("secure_url").toString());
                
                future.complete(song);
            } catch (Exception e) {
                e.printStackTrace();
                future.completeExceptionally(e);
            }
        }).start();
        
        return future;
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
                song.setPlaylistIDs(doc.getList("playlists", ObjectId.class));
                song.setArtist(doc.getString("artist"));
                song.setTitle(doc.getString("title"));
                song.setImageURL(doc.getString("imageURL"));
                song.setAudioURL(doc.getString("audioURL"));
                song.setDuration(doc.getInteger("duration"));
                
                resSongs.add(song);
            }
            
            return resSongs;
        });
    }
    
    public void updateSong(Song song) {
        new Thread(() -> {
            MongoCollection<Document> col = database.getCollection("songs");
            
            Document filter = new Document("_id", song.getID());
            Document update = new Document("$set", new Document("playlists", song.getPlaylistIDs()));
        }).start();
    }
}
