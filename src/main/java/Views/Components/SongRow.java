/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.Components;
import Utilities.Song;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author atond
 */
public class SongRow extends javax.swing.JPanel {
    URL CoverUrl;
    /**
     * Creates new form SongRow
     */
    public SongRow() {
        initComponents();
    }
    
    public void updateSongPanel(Song song) throws MalformedURLException, IOException{
    currentTitleLabel1.setText(song.getTitle());
    currentArtistLabel1.setText(song.getArtist());
    currentDurationLabel1.setText(String.valueOf(song.getFormattedDuration()));
    
    
    CoverUrl=(new URL(song.getImageURL()));
    Image coverImage = ImageIO.read(CoverUrl);
    int labelWidth = currentCoverLabel1.getPreferredSize().width;
    Image scaledCover = coverImage.getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
    ImageIcon coverIcon = new ImageIcon(scaledCover);
        
    currentCoverLabel1.setIcon(coverIcon);
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        currentArtistLabel1 = new javax.swing.JLabel();
        currentTitleLabel1 = new javax.swing.JLabel();
        currentCoverLabel1 = new javax.swing.JLabel();
        currentDurationLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(26, 23, 32));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("ıIı");

        currentArtistLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        currentArtistLabel1.setForeground(new java.awt.Color(240, 240, 240));
        currentArtistLabel1.setText("Song Artist");

        currentTitleLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        currentTitleLabel1.setForeground(new java.awt.Color(240, 240, 240));
        currentTitleLabel1.setText("Song Title");

        currentCoverLabel1.setForeground(new java.awt.Color(240, 240, 240));
        currentCoverLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        currentCoverLabel1.setMaximumSize(new java.awt.Dimension(44, 44));
        currentCoverLabel1.setMinimumSize(new java.awt.Dimension(44, 44));
        currentCoverLabel1.setPreferredSize(new java.awt.Dimension(44, 44));

        currentDurationLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        currentDurationLabel1.setForeground(new java.awt.Color(240, 240, 240));
        currentDurationLabel1.setText("XX:XX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentCoverLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentTitleLabel1)
                    .addComponent(currentArtistLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(currentDurationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentTitleLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentArtistLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentCoverLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(currentDurationLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentArtistLabel1;
    private javax.swing.JLabel currentCoverLabel1;
    private javax.swing.JLabel currentDurationLabel1;
    private javax.swing.JLabel currentTitleLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
