package Models;

// General Database
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

// Song Database
import com.cloudinary.*;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Database {    
    MongoClient mongoClient;
    GridFSBucket gridFSBucket;
    int _threadCount = 0;

    public Database() {  
        Dotenv dotenv = Dotenv.load();
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        
        // execute MongoDB thread
        executor.submit(() -> {
            _threadCount++;
            System.out.println("[ LOADING ] MongoDB");
            mongoClient = MongoClients.create("mongodb+srv://" + dotenv.get("MONGO_USERNAME") + ":" + dotenv.get("MONGO_PASSWORD") + "@cluster0.xvzkkrp.mongodb.net/?retryWrites=true&w=majority");
            MongoDatabase database = mongoClient.getDatabase("Symph");
            gridFSBucket = GridFSBuckets.create(database, "songs");
            
            System.out.println("[ READY ] MongoDB");
            _threadCount--;
            
            checkThreads();
            return null;
        });
        
        // execute Cloudinary thread
        executor.submit(() -> {
            _threadCount++;
            System.out.println("[ LOADING ] Cloudinary");
            Cloudinary cloudinary = new Cloudinary("cloudinary://" + dotenv.get("CLOUDINARY_API_KEY") + ":" + dotenv.get("CLOUDINARY_API_SECRET") + "@" + dotenv.get("CLOUDINARY_NAME"));
            cloudinary.config.secure = true;
            
            System.out.println("[ READY ] Cloudinary");
            _threadCount--;
            
            checkThreads();
            return null;
        });
        
        
    }
    
    private void checkThreads() {
        if (_threadCount <= 0) {
            // Ready
            System.out.println("[ APP ] App is Ready!");
        }
    }
}
