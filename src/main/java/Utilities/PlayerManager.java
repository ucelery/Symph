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
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

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
    
    public void play() {
        // If not playing anything, add all songs in songbank
        if (currentSong == null && !songBank.isEmpty()) {
            List<Song> list = new ArrayList(songBank);
            musicQueue.addAll(list);
            
            playNextSong();
        } else {
            System.out.println("[ APP ] There are no songs to play, please add one");
            return;
        }
        
        try {
            BufferedInputStream in = new BufferedInputStream(new URL(currentSong.getAudioURL()).openStream());
            Player player = new Player(in);
            
            // Start the audio playback on a separate thread
            Thread playerThread = new Thread(() -> {
                try {
                    player.play();
                    
                    while(!player.isComplete()) {
                        System.out.println(player.getPosition() / 1000 + ":" + currentSong.getDuration());
                    }
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            playerThread.start();
            
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
    
    public void playNextSong() {
        // Dequeue top song from the queue
       if (!musicQueue.isEmpty()) {
           currentSong = musicQueue.poll();
       }
    }
    
    public void shuffle() {
        List<Song> list = new ArrayList<>(musicQueue);
        Collections.shuffle(list);
        
        musicQueue.clear();
        musicQueue.addAll(list);
        
        System.out.println("[ MUSIC.PLAYER ] Queue is shuffled");
    }
    
    public Queue<Song> getQueue() {
        return musicQueue;
    }
    
    public ArrayList<Song> getAllSongs() {
        return songBank;
    }
}
