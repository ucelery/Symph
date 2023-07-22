/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.File;
import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 *
 * @author atond
 */
public class Playlist {
    private ObjectId _id;
    private String name;
    private File imageFile;
    private String imageURL;
    private ArrayList<Song> songs;
    private boolean favorite = false;
    
    public Playlist(String name) {
        this.name = name;
    }
    
    public Playlist(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
    
    public ObjectId getId() {
        return this._id;
    }
    
    public void setId(ObjectId id) {
        this._id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Song> getSongs() {
        return this.songs;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
    public boolean getFavorite() {
        return this.favorite;
    }
    
    public void setFavorite(boolean flag) {
        this.favorite = flag;
    }
    
    public File getImageFile() {
        return this.imageFile;
    }
    
    public void setImageFile(File file) {
        this.imageFile = file;
    }
    
    public String getImageURL() {
        return this.imageURL;
    }
    
    public void setImageURL(String url) {
        this.imageURL = url;
    }
    
    public void addSong(Song song) {
        song.getPlaylistIDs().add(this._id);
    }
}
