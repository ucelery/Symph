/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author atond
 */
public class PlayerManager {

    public static PlayerState PlayerState;
    private ArrayList<Song> songBank = new ArrayList<Song>();
    private Queue<Song> musicQueue;
    private Song currentSong = null;
    
    private PlayerThread playerThread;
    
    public enum PlayerState { IDLE, PLAYING, PAUSED }
    private PlayerState state = PlayerState.IDLE;
    
    public PlayerManager(ArrayList<Song> songs) {
        musicQueue = new LinkedList<Song>();
        
        this.songBank = songs;
    }
    
    public void enqueueSong(Song song) {
        // If song is already in queue do not add it
        if (musicQueue.contains(song)) return;
        
        musicQueue.offer(song);
    }
    
    public void enqueuePlaylist(Playlist playlist) {
        musicQueue.clear();
        musicQueue.addAll(new ArrayList<Song>(playlist.getSongs()));
    }
    
    public void removeSongInQueue(Song song) {
        if (musicQueue.contains(song))
            musicQueue.remove(song);
    }
    
    // [ Controls ] ============================================================
    public void play() {
        state = PlayerState.PLAYING;
        
        // If not playing anything, add all songs in songbank
        if (currentSong == null) {
            if (songBank.isEmpty()) {
                System.out.println("[ APP ] There are no songs to play, please add one");
                return;
            }
                
            List<Song> list = new ArrayList(songBank);
            musicQueue.addAll(list);
            
            queueNextSong();
        }
        
        // Start the audio playback on a separate thread            
        playerThread = new PlayerThread(currentSong);
        playerThread.start();
    }
    
    public void playNextSong() {
        queueNextSong();
        play();
    }
    
    public void pause() {
        state = PlayerState.PAUSED;
        playerThread.pause();
    }
    
    public void resume() {
        state = PlayerState.PLAYING;
        playerThread.resumePlaying();
    }
    
    public void shuffle() {
        List<Song> list = new ArrayList<>(musicQueue);
        Collections.shuffle(list);
        
        musicQueue.clear();
        musicQueue.addAll(list);
        
        System.out.println("[ MUSIC.PLAYER ] Queue is shuffled");
    }
    
    public void queueNextSong() {
        // Dequeue top song from the queue
       if (!musicQueue.isEmpty()) {
           currentSong = musicQueue.poll();
       } else System.out.println("[ MUSIC.PLAYER ] Queue is empty");
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
}