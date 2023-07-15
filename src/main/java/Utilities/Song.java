/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author atond
 */
public class Song {
    private ObjectId id;
    private String title;
    private String artist;
    private String audioURL;
    private String imageURL;
    private ObjectId playlistID;
    
    private File audioFile;
    private File coverFile;
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setCoverFile(File coverFile) {
        this.coverFile = coverFile;
    }
    
    public void setCoverFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Image File");

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter imgFilter0 = new FileNameExtensionFilter("Image Files", "png", "jpg");

        fileChooser.addChoosableFileFilter(imgFilter0);
            

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            coverFile = fileChooser.getSelectedFile();
        }
    }
    
    public File getCoverFile() {
        return this.coverFile;
    }
    
    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }
    
    public void setAudioFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select MP3 File");

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio Files", "mp3");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile() != null) {
            this.audioFile = fileChooser.getSelectedFile();
        }
    }
    
    public File getAudioFile() {
        return this.audioFile;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getArtist() {
        return this.artist;
    }
    
    public void setAudioURL(String url) {
        this.audioURL = url;
    }
    
    public String getAudioURL() {
        return this.audioURL;
    }
    
    public void setImageURL(String url) {
        this.imageURL = url;
    }
    
    public String getImageURL() {
        return this.imageURL;
    }
    
    public void setPlaylistID(ObjectId playlistID) {
        this.playlistID = playlistID;
    }
    
    public ObjectId getPlaylistID() {
        return this.playlistID;
    }
}
