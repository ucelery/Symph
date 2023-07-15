/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author atond
 */
public class PlayerManager {
    private ArrayList<Song> songBank = new ArrayList<Song>();
    private Queue<Song> musicQueue;
    private Song currentSong = null;
    
    public PlayerManager(ArrayList<Song> songs) {
        musicQueue = new LinkedList<Song>();
        
        this.songBank = songs;
    }
    
    public void enqueueSong(Song song) {
        musicQueue.offer(song);
    }
    
    public void playNextSong() {
        // Dequeue top song from the queue
       if (!musicQueue.isEmpty()) {
           currentSong = musicQueue.poll();
       }
    }
    
    public Queue<Song> getQueue() {
        return musicQueue;
    }
    
    public ArrayList<Song> getAllSongs() {
        return songBank;
    }
}
