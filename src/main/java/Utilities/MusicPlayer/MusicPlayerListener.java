/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Utilities.MusicPlayer;

import Utilities.Song;
import java.util.Queue;

/**
 *
 * @author atond
 */
public interface MusicPlayerListener {
    void onSongEnd(Song song);
    void onSongPlay(Song song);
    void onSongPlaying(int secs);
    void onQueueUpdate(Queue<Song> songs);
}
