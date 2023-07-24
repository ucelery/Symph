/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author atond
 */
public class Song {
    private ObjectId _id;
    private String title;
    private String artist;
    private String audioURL;
    private String imageURL;
    private List<ObjectId> playlistID;
    private int duration;
    private String lyrics;
    
    private File audioFile;
    private File coverFile;
    
    public void setID(ObjectId id) {
        this._id = id;
    }
    
    public ObjectId getID() {
        return this._id;
    }
    
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
    
    public void setPlaylistIDs(List<ObjectId> playlistIDs) {
        this.playlistID = playlistIDs;
    }
    
    public List<ObjectId> getPlaylistIDs() {
        return this.playlistID;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
    
    public String getLyrics() {
        return this.lyrics;
    }
    
    public String getFormattedDuration() {
        int min = duration / 60;
        int sec = duration - (min * 60);
        
        return min + ":" + sec;
    }
}
