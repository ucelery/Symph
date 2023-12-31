/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author CailynRae
 */
public class PlaylistTab extends javax.swing.JPanel {

    /**
     * Creates new form PlaylistTab
     */
    
    MainView main;
    public PlaylistTab(String name, URL imageURL) throws IOException {
        initComponents();
        playlistName.setText("<html><div style='text-align: left;'>" + name + "</div></html>");
        play.setVisible(false);
        try {
            Image image = ImageIO.read(imageURL);
            ImageIcon playlistImage = new ImageIcon(image);
            int labelWidth = jLabel7.getWidth();
            Image scaledImage = playlistImage.getImage().getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
            
            ImageIcon playlistPic = new ImageIcon(scaledImage);
            jLabel7.setIcon(playlistPic);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PlaylistTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getPlaylistName() throws IOException {
        main = new MainView();
        return playlistName;
    }

    public void setPlaylistName(JLabel playlistName) {
        this.playlistName = playlistName;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        play = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        playlistName = new javax.swing.JLabel();

        setBackground(null);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(205, 220));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(40, 40, 57));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(null);

        play.setForeground(new java.awt.Color(255, 255, 255));
        play.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        play.setText("helpp");
        jPanel1.add(play);
        play.setBounds(110, 140, 30, 16);

        jLabel7.setForeground(new java.awt.Color(153, 153, 0));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(15, 15, 140, 140);

        playlistName.setBackground(new java.awt.Color(153, 153, 0));
        playlistName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        playlistName.setForeground(new java.awt.Color(240, 240, 240));
        playlistName.setText("Playlist 1");
        playlistName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(playlistName);
        playlistName.setBounds(15, 165, 140, 40);

        add(jPanel1);
        jPanel1.setBounds(15, 0, 170, 220);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        play.setVisible(true);
        jPanel1.setBackground(Color.decode("#323248"));
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        // TODO add your handling code here:
        play.setVisible(false);
        jPanel1.setBackground(Color.decode("#282839"));
    }//GEN-LAST:event_jPanel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel play;
    private javax.swing.JLabel playlistName;
    // End of variables declaration//GEN-END:variables
}
