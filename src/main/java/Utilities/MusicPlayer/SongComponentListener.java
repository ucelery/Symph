/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Utilities.MusicPlayer;

import Utilities.Song;

/**
 *
 * @author atond
 */
public interface SongComponentListener {
    void onSongPlay(Song song);
    void onSongRemove(Song song);
    void onSongAddQueue(Song song);
}
