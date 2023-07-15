/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author atond
 */
public class Song {
    String id;
    int localId;
    String title;
    String artist;
    
    File audioFile;
    File coverFile;
    
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
}
