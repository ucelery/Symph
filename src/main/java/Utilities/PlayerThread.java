/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author atond
 */
public class PlayerThread extends Thread {
    private Song song;
    
    MediaPlayer player;
    
    public PlayerThread(Song song) {
        this.song = song;
        
        // Prepare JavaFX toolkit and environment 
        new JFXPanel();
        
        Media media = new Media(song.getAudioURL());
        player = new MediaPlayer(media);
    }
    
    // [ Controls ] ============================================================
    public void run() {
        player.play();
    }
    
    public void pause() {
        player.pause();
    }
    
    public void resumePlaying() {
        if (player.getStatus() == MediaPlayer.Status.PAUSED) {
            player.play();
        }
    }
    
    public void setVolume(double value) {
        player.setVolume(value);
    }
    
    // [ DURATION ] ============================================================
    public Duration getTotalDuration() {
        return player.getTotalDuration();
    }
    
    public Duration getBufferDuration() {
        return player.getBufferProgressTime();
    }
    
    public Duration getCurrentTime() {
        return player.getCurrentTime();
    }
    
    public void setCurrentTime(double ms) {
        player.setStartTime(new Duration(ms));
    }
}
