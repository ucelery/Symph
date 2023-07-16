package Controllers;

import Models.Database;
import Utilities.PlayerManager;
import Utilities.Song;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    Database db = new Database();
    PlayerManager playerManager;

    public Controller() {
        initializeApp();
    }
    
    public void initializeApp() {
        // Initialize App
        
        Thread initThread = new Thread(() -> {
            try {
                // MongoDB
                System.out.println("[ APP ] Initializing MongoDB");
                db.initializeMongoDB();

                // Cloudinary
                System.out.println("[ APP ] Initializing Cloudinary");
                db.initializeCloudinary();

                // Initialize Player
                System.out.println("[ APP ] Fetching Songs");
                playerManager = new PlayerManager(db.getSongsData().get());
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            System.out.println("[ APP ] Application is Ready");
            
            // Exit Loading Screen
        });
        
        initThread.start();
    }
    
    public void uploadSong(Song song) {
        ArrayList<String> errorStr = new ArrayList<String>();
        
        // Verify Input Fields
        if (song.getArtist() == null || song.getArtist() == "")
            errorStr.add("Artist");
        
        if (song.getTitle() == null || song.getTitle() == "")
            errorStr.add("Title");
        
        if (song.getAudioFile() == null)
            errorStr.add("Audio File");
        
        if (song.getCoverFile() == null)
            errorStr.add("Cover File");
        
        if (!errorStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in the ff. fields: " + errorStr.toString(), "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }   
        
        JOptionPane.showMessageDialog(null, "Upload Complete!" + errorStr.toString(), "Success!", JOptionPane.INFORMATION_MESSAGE);
        
        new Thread(() -> {
            // Insert song in the database
            CompletableFuture<Song> resSong = db.insertSong(song);
            resSong.thenAccept(res -> {
                // Update PlayerManager
                playerManager.getAllSongs().add(song);
                
                // Update the View
                System.out.println("[ APP ] Song has been added");
            }).exceptionally(ex -> {
                System.out.println("Future Exception: " + ex);
                return null;
            });
        }).start();
    }
        
    public void playAudio() {
        playerManager.play();
    }
    
    public void stopAudio() {
        
    }
    
    public void toggleAudio() {
        if (playerManager.getState() == PlayerManager.PlayerState.PAUSED) {
            playerManager.resume();
        } else if (playerManager.getState() == PlayerManager.PlayerState.PLAYING) {
            playerManager.pause();
        }
    }
    
    public void pauseAudio() {
        
    }
    
    public void resumeAudio() {
        
    }
    
    public ArrayList<Song> getSongs() {
        return playerManager.getAllSongs();
    }
}
