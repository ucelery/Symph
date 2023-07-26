/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.Controller;
import Utilities.MusicPlayer.MusicPlayerListener;
import Utilities.PlayerManager;
import Utilities.Song;
import Views.Components.SongRow;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author atond
 */
public class PlayingView extends javax.swing.JPanel implements MusicPlayerListener {    
    private Controller controller;
    private Song currentSong;
    /**
     * Creates new form PlayingView
     */
    public PlayingView() {
        initComponents();
        
        // Create the CardLayout for the mainPanel
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        
        // Add the playingPanel and queuePanel to the mainPanel
        mainPanel.add(playingPanel, "playingPanel");
        mainPanel.add(queuePanel, "queuePanel");
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    private void setLyricsArea(String lyrics){ //hoping dat dis works as well ehe
        lyricsArea.setText(lyrics);
    }
    
    private void setSliderProgress(int currentDur){
        int min = currentDur / 60;
        int sec = currentDur - (min * 60);
        
        progressSlider.setValue(currentDur);
        startLabel.setText(String.format("%02d", min) + ":" + String.format("%02d", sec));
    }
    
    private void setMaxDuration(int seconds) {
        int min = seconds / 60;
        int sec = seconds - (min * 60);
        endLabel.setText(String.format("%02d", min) + ":" + String.format("%02d", sec));
        
        progressSlider.setMaximum(seconds);
    }
    
    public void setArtistLabel(String artist) {
        artistLabel.setText(artist);
    }
    
    public void setTitleLabel(String title) {
        titleLabel.setText(title);
    }
    
    public void setCoverUrl(String urlString) throws IOException {
        try {
            URL coverUrl = new URL(urlString);
            Image coverImage = ImageIO.read(coverUrl);
            
            int labelWidth = coverLabel.getWidth();
            Image scaledCover = coverImage.getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
            ImageIcon coverIcon = new ImageIcon(scaledCover);
            coverLabel.setIcon(coverIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        playingPanel = new javax.swing.JPanel();
        progressSlider = new javax.swing.JSlider();
        backButton = new javax.swing.JLabel();
        forwardButton = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        coverPanel = new javax.swing.JPanel();
        coverLabel = new javax.swing.JLabel();
        plusLabel = new javax.swing.JLabel();
        favButton = new javax.swing.JLabel();
        artistLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JLabel();
        leaveButton = new javax.swing.JLabel();
        queueButton = new javax.swing.JLabel();
        queuePanel = new javax.swing.JPanel();
        returnButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        queueScroll = new javax.swing.JScrollPane();
        queueContainer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        songRow1 = new Views.Components.SongRow();
        addLyricsView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lyricsInput = new javax.swing.JTextArea();
        lyricsLabel = new javax.swing.JLabel();
        submitLyricsButton = new javax.swing.JLabel();
        lyricsPanel = new javax.swing.JPanel();
        lyricsScroll = new javax.swing.JScrollPane();
        lyricsArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lyricsLabel1 = new javax.swing.JLabel();

        mainPanel.setBackground(new java.awt.Color(26, 23, 32));
        mainPanel.setLayout(new java.awt.CardLayout());

        playingPanel.setBackground(new java.awt.Color(26, 23, 32));
        playingPanel.setPreferredSize(new java.awt.Dimension(500, 600));

        progressSlider.setBackground(new java.awt.Color(40, 40, 57));
        progressSlider.setForeground(new java.awt.Color(226, 115, 150));

        backButton.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        backButton.setForeground(new java.awt.Color(226, 115, 150));
        backButton.setText("«");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        forwardButton.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        forwardButton.setForeground(new java.awt.Color(226, 115, 150));
        forwardButton.setText("»");
        forwardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        titleLabel.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(240, 240, 240));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Song Title");

        coverPanel.setPreferredSize(new java.awt.Dimension(260, 260));

        coverLabel.setPreferredSize(new java.awt.Dimension(260, 260));

        javax.swing.GroupLayout coverPanelLayout = new javax.swing.GroupLayout(coverPanel);
        coverPanel.setLayout(coverPanelLayout);
        coverPanelLayout.setHorizontalGroup(
            coverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coverLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        coverPanelLayout.setVerticalGroup(
            coverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coverPanelLayout.createSequentialGroup()
                .addComponent(coverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        plusLabel.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        plusLabel.setForeground(new java.awt.Color(115, 129, 137));
        plusLabel.setText("+");
        plusLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        favButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        favButton.setForeground(new java.awt.Color(115, 129, 137));
        favButton.setText("♥");
        favButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        artistLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        artistLabel.setForeground(new java.awt.Color(240, 240, 240));
        artistLabel.setText("Song Artist");

        startLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        startLabel.setForeground(new java.awt.Color(240, 240, 240));
        startLabel.setText("00:00");

        endLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        endLabel.setForeground(new java.awt.Color(240, 240, 240));
        endLabel.setText("XX:XX");

        playButton.setFont(new java.awt.Font("Century Gothic", 1, 32)); // NOI18N
        playButton.setForeground(new java.awt.Color(226, 115, 150));
        playButton.setText("►");
        playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButton.setMaximumSize(new java.awt.Dimension(566, 512));
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playButtonMousePressed(evt);
            }
        });

        leaveButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        leaveButton.setForeground(new java.awt.Color(115, 126, 137));
        leaveButton.setText("<");
        leaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        queueButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        queueButton.setForeground(new java.awt.Color(115, 129, 137));
        queueButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        queueButton.setText("≡");
        queueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        queueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queueButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                queueButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout playingPanelLayout = new javax.swing.GroupLayout(playingPanel);
        playingPanel.setLayout(playingPanelLayout);
        playingPanelLayout.setHorizontalGroup(
            playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playingPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(leaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playingPanelLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(playingPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playingPanelLayout.createSequentialGroup()
                                .addComponent(startLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endLabel))
                            .addGroup(playingPanelLayout.createSequentialGroup()
                                .addComponent(plusLabel)
                                .addGap(140, 140, 140)
                                .addComponent(artistLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(favButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playingPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forwardButton)
                        .addGap(2, 2, 2)))
                .addGap(58, 58, 58))
            .addGroup(playingPanelLayout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(queueButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playingPanelLayout.setVerticalGroup(
            playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playingPanelLayout.createSequentialGroup()
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(playingPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(coverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playingPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(leaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plusLabel)
                    .addComponent(favButton)
                    .addComponent(artistLabel))
                .addGap(33, 33, 33)
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startLabel)
                    .addComponent(endLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forwardButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueButton)
                .addGap(44, 44, 44))
        );

        mainPanel.add(playingPanel, "card2");

        queuePanel.setBackground(new java.awt.Color(26, 23, 32));
        queuePanel.setMaximumSize(new java.awt.Dimension(500, 600));

        returnButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        returnButton.setForeground(new java.awt.Color(115, 126, 137));
        returnButton.setText("<");
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Now Playing");

        queueScroll.setBackground(new java.awt.Color(26, 23, 32));
        queueScroll.setBorder(null);
        queueScroll.setForeground(new java.awt.Color(26, 23, 32));
        queueScroll.setMaximumSize(new java.awt.Dimension(252, 370));
        queueScroll.setPreferredSize(new java.awt.Dimension(437, 59));
        queueScroll.setViewportView(null);
        queueScroll.getViewport().setOpaque(false);

        queueContainer.setLayout(new javax.swing.BoxLayout(queueContainer, javax.swing.BoxLayout.LINE_AXIS));
        queueScroll.setViewportView(queueContainer);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Next Up");

        javax.swing.GroupLayout queuePanelLayout = new javax.swing.GroupLayout(queuePanel);
        queuePanel.setLayout(queuePanelLayout);
        queuePanelLayout.setHorizontalGroup(
            queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(queuePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(songRow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(queueScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(returnButton))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        queuePanelLayout.setVerticalGroup(
            queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(songRow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        mainPanel.add(queuePanel, "card3");

        addLyricsView.setBackground(new java.awt.Color(26, 23, 32));

        lyricsInput.setColumns(20);
        lyricsInput.setRows(5);
        jScrollPane1.setViewportView(lyricsInput);

        lyricsLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lyricsLabel.setForeground(new java.awt.Color(240, 240, 240));
        lyricsLabel.setText("Paste the lyrics and hit submit!");

        submitLyricsButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        submitLyricsButton.setForeground(new java.awt.Color(240, 240, 240));
        submitLyricsButton.setText("submit");
        submitLyricsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitLyricsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                submitLyricsButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout addLyricsViewLayout = new javax.swing.GroupLayout(addLyricsView);
        addLyricsView.setLayout(addLyricsViewLayout);
        addLyricsViewLayout.setHorizontalGroup(
            addLyricsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLyricsViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addLyricsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(addLyricsViewLayout.createSequentialGroup()
                        .addComponent(lyricsLabel)
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLyricsViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitLyricsButton)))
                .addContainerGap())
        );
        addLyricsViewLayout.setVerticalGroup(
            addLyricsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLyricsViewLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lyricsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitLyricsButton)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        mainPanel.add(addLyricsView, "addLyrics");

        lyricsPanel.setBackground(new java.awt.Color(26, 23, 32));
        lyricsPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        lyricsScroll.setBackground(new java.awt.Color(26, 32, 32));
        lyricsScroll.setBorder(null);
        lyricsScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lyricsScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        lyricsScroll.setAutoscrolls(true);

        lyricsArea.setEditable(false);
        lyricsArea.setBackground(new java.awt.Color(26, 23, 32));
        lyricsArea.setColumns(20);
        lyricsArea.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lyricsArea.setForeground(new java.awt.Color(240, 240, 240));
        lyricsArea.setLineWrap(true);
        lyricsArea.setRows(5);
        lyricsArea.setWrapStyleWord(true);
        lyricsArea.setBorder(null);
        lyricsArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lyricsScroll.setViewportView(lyricsArea);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Add Lyrics");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        lyricsLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lyricsLabel1.setForeground(new java.awt.Color(240, 240, 240));
        lyricsLabel1.setText("Lyrics");

        javax.swing.GroupLayout lyricsPanelLayout = new javax.swing.GroupLayout(lyricsPanel);
        lyricsPanel.setLayout(lyricsPanelLayout);
        lyricsPanelLayout.setHorizontalGroup(
            lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyricsScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addComponent(lyricsLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        lyricsPanelLayout.setVerticalGroup(
            lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricsPanelLayout.createSequentialGroup()
                .addGroup(lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(lyricsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addComponent(lyricsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lyricsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lyricsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void queueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queueButtonMouseClicked
        // TODO add your handling code here:
        // Switch to the queuePanel
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, null);
        cardLayout.show(mainPanel, "queuePanel");
    }//GEN-LAST:event_queueButtonMouseClicked

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        // TODO add your handling code here:
        // Switch to the playingPanel
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, null);
        cardLayout.show(mainPanel, "playingPanel");
    }//GEN-LAST:event_returnButtonMouseClicked

    private void playButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMousePressed
        // Play Button
        String playSym = "►";
        String pauseSym = "II";
        
        if (controller.getMusicPlayerStatus() == PlayerManager.PlayerState.IDLE) {
            controller.playAudio();
            playButton.setText(playButton.getText().equals(playSym) ? pauseSym : playSym);
        } else {
            controller.toggleAudio();
           playButton.setText(playButton.getText().equals(playSym) ? pauseSym : playSym);
        }
    }//GEN-LAST:event_playButtonMousePressed

    private void queueButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queueButtonMousePressed
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, null);
        cardLayout.show(mainPanel, "queuePanel");
    }//GEN-LAST:event_queueButtonMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "addLyrics");
    }//GEN-LAST:event_jLabel1MousePressed

    private void submitLyricsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitLyricsButtonMousePressed
        String lyricsInputStr = lyricsInput.getText();
        if (lyricsInputStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please Populate Lyrics Text Field");
            return;
        }

        // Submit Lyrics
        Song newSong = new Song();
        newSong = currentSong;
        newSong.setLyrics(lyricsInputStr);
        controller.updateSong(newSong);
    }//GEN-LAST:event_submitLyricsButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addLyricsView;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel coverLabel;
    private javax.swing.JPanel coverPanel;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel favButton;
    private javax.swing.JLabel forwardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leaveButton;
    private javax.swing.JTextArea lyricsArea;
    private javax.swing.JTextArea lyricsInput;
    private javax.swing.JLabel lyricsLabel;
    private javax.swing.JLabel lyricsLabel1;
    private javax.swing.JPanel lyricsPanel;
    private javax.swing.JScrollPane lyricsScroll;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel playButton;
    private javax.swing.JPanel playingPanel;
    private javax.swing.JLabel plusLabel;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JLabel queueButton;
    private javax.swing.JPanel queueContainer;
    private javax.swing.JPanel queuePanel;
    private javax.swing.JScrollPane queueScroll;
    private javax.swing.JLabel returnButton;
    private Views.Components.SongRow songRow1;
    private javax.swing.JLabel startLabel;
    private javax.swing.JLabel submitLyricsButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSongEnd(Song song) {
        return;
    }

    @Override
    public void onSongPlay(Song song) {
        try {
            // Update Song Cover Image, Song Title, Song Artist, Lyrics (if any)
            setCoverUrl(song.getImageURL());
            setTitleLabel(song.getTitle());
            setArtistLabel(song.getArtist());
            setMaxDuration(song.getDuration());
            setLyricsArea(song.getLyrics());
            
            songRow1.updateSongPanel(song);
            currentSong = song;
        } catch (IOException ex) {
            Logger.getLogger(PlayingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onSongPlaying(int secs) {
        setSliderProgress(secs);
    }

    @Override
    public void onQueueUpdate(Queue<Song> songs) {
        queueContainer.removeAll();
        for (Song song : songs) {
            try {
                SongRow row = new SongRow();
                row.updateSongPanel(song);
                queueContainer.add(row);
            } catch (IOException ex) {
                Logger.getLogger(PlayingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}