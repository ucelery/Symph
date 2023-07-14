package Controllers;

import Models.Database;
import Models.Song;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Controller {
    Database db = new Database();
    
    public Controller() {
        // Initialize Player
        
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
        db.insertSong(song);
    }
    
    public void playAudio(String cloudinaryURL) {
        try {
            BufferedInputStream in = new BufferedInputStream(new URL(cloudinaryURL).openStream());
            Player player = new Player(in);
            
            // Start the audio playback on a separate thread
            Thread playerThread = new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            playerThread.start();
            
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
