package Controllers;

import Models.Database;
import Models.Song;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller {
    Database db = new Database();
    
    public Controller() {
        
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
        Media media = new Media(cloudinaryURL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
