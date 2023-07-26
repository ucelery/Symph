/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Utilities.MusicPlayer.MusicPlayerListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author atond
 */
public class PlayerManager {
    public static PlayerManager Instance;
    
    private List<MusicPlayerListener> playerListeners = new ArrayList();
    public static PlayerState PlayerState;
    private ArrayList<Song> songBank = new ArrayList<Song>();
    private Queue<Song> musicQueue;
    private Song currentSong = null;
    
    public enum PlayerState { IDLE, PLAYING, PAUSED }
    private PlayerState state = PlayerState.IDLE;
    
    private MediaPlayer player;
    
    public PlayerManager(ArrayList<Song> songs) {
        if (Instance == null) {
            Instance = this;
        } else {
            return;
        }
        
        new JFXPanel(); // Initialize Toolkit for music playing DO NOT REMOVE
        musicQueue = new LinkedList<Song>(songs);
        
        this.songBank = songs;
        System.out.println("[ MUSIC.PLAYER ] Player initialized with " + songs.size() + " songs");
    }
    
    public void addListener(MusicPlayerListener e) {
        playerListeners.add(e);
    }
    
    public void invokeSongPlayEvent(Song song) {
        for (MusicPlayerListener mpl : playerListeners) {
            mpl.onSongPlay(song);
        }
    }
    
    public void invokeSongEndEvent(Song song) {
        for (MusicPlayerListener mpl : playerListeners) {
            mpl.onSongEnd(song);
        }
    }
    
    public void invokeSongPlayingEvent(int duration) {
        for (MusicPlayerListener mpl : playerListeners) {
            mpl.onSongPlaying(duration);
        }
    }
    
    public void invokeQueueUpdateEvent() {
        for (MusicPlayerListener mpl : playerListeners) {
            mpl.onQueueUpdate(musicQueue);
        }
    }
    
    public void invokeQueueEndEvent() {
        for (MusicPlayerListener mpl : playerListeners) {
            mpl.onQueueEnd();
        }
    }
    
    public void enqueueSong(Song song) {
        // If song is already in queue do not add it
        if (musicQueue.contains(song)) return;
        
        musicQueue.offer(song);
        invokeQueueUpdateEvent();
    }
    
    public void enqueuePlaylist(Playlist playlist) {
        musicQueue.clear();
        musicQueue.addAll(new ArrayList<Song>(playlist.getSongs()));
    }
    
    public void removeSongInQueue(Song song) {
        if (musicQueue.contains(song))
            musicQueue.remove(song);
    }
    
    public void start() {
        // If no songs are passed, play all songs shuffled
        if (musicQueue.isEmpty()) {
            queueAllSongs();
            shuffle();
            queueNextSong();
        }
        
        play();
    }
    
    // [ Controls ] ============================================================
    public void play() {
        state = PlayerState.PLAYING;
        
        // Make a separate thread for playing music
        new Thread(() -> {
            queueNextSong();
            
            if (currentSong == null) return; // Queue is empty
            
            Media media = new Media(currentSong.getAudioURL());
            player = new MediaPlayer(media);
            
            invokeSongPlayEvent(currentSong);
            invokeQueueUpdateEvent();
            
            System.out.println("[ MUSIC.PLAYER ] Now playing " + currentSong.getTitle() + " by " + currentSong.getArtist());
            player.play();
            
            player.setOnEndOfMedia(() -> {
                invokeSongEndEvent(currentSong);
                play();
            });
            
            player.currentTimeProperty().addListener((observableValue, oldDuration, newDuration) -> {
                invokeSongPlayingEvent((int) newDuration.toSeconds());
            });
        }).start();
    }
    
    public void playNextSong() {
        queueNextSong();
        play();
    }
    
    public void pause() {
        state = PlayerState.PAUSED;
        player.pause();
        
        System.out.println("[ MUSIC.PLAYER ] Paused");
    }
    
    public void resume() {
        state = PlayerState.PLAYING;
        player.play();
        
        System.out.println("[ MUSIC.PLAYER ] Resumed");
    }
    
    public void shuffle() {
        List<Song> list = new ArrayList<>(musicQueue);
        Collections.shuffle(list);
        
        musicQueue.clear();
        musicQueue.addAll(list);
        
        System.out.println("[ MUSIC.PLAYER ] Queue is shuffled");
    }
    
    public void stop() {
        player.stop();
        state = PlayerState.IDLE;
    }
    
    // [ Music Queue-ing ] =====================================================
    public void queueNextSong() {
        // Dequeue top song from the queue
       if (!musicQueue.isEmpty()) {
           currentSong = musicQueue.poll();
           invokeQueueUpdateEvent();
       } else {
           currentSong = null;
           System.out.println("[ MUSIC.PLAYER ] Queue is empty");
           state = PlayerState.IDLE;
           invokeQueueEndEvent();
       }
    }
    
    public Queue<Song> getQueue() {
        return musicQueue;
    }
    
    public ArrayList<Song> getAllSongs() {
        return songBank;
    }
    
    public PlayerState getState() {
        return state;
    }
    
    public MediaPlayer getMediaPlayer() {
        return player;
    }
    
    public Song getCurrentSong() {
        return currentSong;
    }
    
    private void queueAllSongs() {
        List<Song> list = new ArrayList(songBank);
        musicQueue.addAll(list);
    }
}