/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.Controller;
import Utilities.MusicPlayer.SongComponentListener;
import Utilities.Song;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author CailynRae
 */
public class Songs extends javax.swing.JPanel {
    private Song song;
    private int index;
    private ImageIcon playIcon;
    private ArrayList<SongComponentListener> songComponentListeners = new ArrayList();
    
    /**
     * Creates new form Songs
     */
    public Songs(String i, Song song) throws IOException {
        initComponents();
        this.song = song;
        this.index = Integer.parseInt(i);
        
        // Cache icon
        this.playIcon = putIcon(new URL("https://media.discordapp.net/attachments/976691420087853066/1133019625802694666/play-button-arrowhead_1.png"), 25);
        
        indexLabel.setText(i);
        songTitle.setText(song.getTitle());
        artist.setText(song.getArtist());
        date.setText(song.getFormattedDuration());
        
        Image image = ImageIO.read(new URL(song.getImageURL()));
        ImageIcon playlistImage = new ImageIcon(image);
        int labelWidth = songPic.getWidth();
        Image scaledImage = playlistImage.getImage().getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
            
        ImageIcon playlistPic = new ImageIcon(scaledImage);
        songPic.setIcon(playlistPic);
        
        addToQueueBtn.setIcon(putIcon(new URL("https://i.imgur.com/OE3vVd4.png"), 22));
        addToQueueBtn.setVisible(false);
        
        // Add The App Controller As a Listener\
        songComponentListeners.add(Controller.Instance);
    }
    
    private ImageIcon putIcon(URL imageURL, int width) throws IOException{
        // putting em fooking icons sa buttons
        ImageIcon imageIcon;
        if(width != 0){
            Image image = ImageIO.read(imageURL);
            ImageIcon newImage = new ImageIcon(image); 
            //scaling the image
            Image scaledImage = newImage.getImage().getScaledInstance(width, -1, Image.SCALE_SMOOTH);
            // ayan na sha    
            imageIcon = new ImageIcon(scaledImage);
            return imageIcon;
        }
        
        else {
            Image image = ImageIO.read(imageURL); 
            ImageIcon newImage = new ImageIcon(image);
            return newImage;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexLabel = new javax.swing.JLabel();
        songPic = new javax.swing.JLabel();
        songTitle = new javax.swing.JLabel();
        artist = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        addToQueueBtn = new javax.swing.JLabel();

        setBackground(null);
        setPreferredSize(new java.awt.Dimension(1060, 60));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(null);

        indexLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        indexLabel.setForeground(new java.awt.Color(240, 240, 240));
        indexLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        indexLabel.setText("#");
        indexLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        indexLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                indexLabelMousePressed(evt);
            }
        });
        add(indexLabel);
        indexLabel.setBounds(10, 20, 38, 19);

        songPic.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        songPic.setForeground(new java.awt.Color(184, 184, 184));
        songPic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(songPic);
        songPic.setBounds(80, 10, 40, 40);

        songTitle.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        songTitle.setForeground(new java.awt.Color(240, 240, 240));
        songTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        songTitle.setText("Title");
        add(songTitle);
        songTitle.setBounds(140, 20, 310, 19);

        artist.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        artist.setForeground(new java.awt.Color(240, 240, 240));
        artist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        artist.setText("Artist");
        add(artist);
        artist.setBounds(510, 20, 300, 19);

        date.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(240, 240, 240));
        date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date.setText("Date Added");
        add(date);
        date.setBounds(790, 20, 190, 19);

        addToQueueBtn.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        addToQueueBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addToQueueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToQueueBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addToQueueBtnMousePressed(evt);
            }
        });
        add(addToQueueBtn);
        addToQueueBtn.setBounds(1020, 20, 20, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        indexLabel.setText("");
        indexLabel.setIcon(playIcon);
        addToQueueBtn.setVisible(true);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        indexLabel.setText("" + index);
        addToQueueBtn.setVisible(false);
        indexLabel.setIcon(null);
    }//GEN-LAST:event_formMouseExited

    private void addToQueueBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToQueueBtnMousePressed
        for (SongComponentListener ls : songComponentListeners) {
            ls.onSongAddQueue(song);
        }
    }//GEN-LAST:event_addToQueueBtnMousePressed

    private void indexLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_indexLabelMousePressed
        for (SongComponentListener ls : songComponentListeners) {
            ls.onSongPlay(song);
        }
    }//GEN-LAST:event_indexLabelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addToQueueBtn;
    private javax.swing.JLabel artist;
    private javax.swing.JLabel date;
    private javax.swing.JLabel indexLabel;
    private javax.swing.JLabel songPic;
    private javax.swing.JLabel songTitle;
    // End of variables declaration//GEN-END:variables
}
