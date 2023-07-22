package Views;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;




public class PlayView extends javax.swing.JFrame {
        URL coverUrl;

    public PlayView() throws MalformedURLException, IOException {

        initComponents();
        int labelWidth = coverLabel.getWidth();
        
        // Create the CardLayout for the mainPanel
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        
        
        
        //slider 
        progressSlider.setMinimum(0);
        progressSlider.setMaximum(100);
        progressSlider.setValue(0);
        
        
        
        // Add the playingPanel and queuePanel to the mainPanel
        mainPanel.add(playingPanel, "playingPanel");
        mainPanel.add(queuePanel, "queuePanel");

        
        setCoverUrl("https://searchengineland.com/figz/wp-content/seloads/2015/09/google-g-logo-2015-1920.png");
        Image coverImage = ImageIO.read(coverUrl);
        Image scaledCover = coverImage.getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
        
        
        ImageIcon coverIcon = new ImageIcon(scaledCover);
        
        coverLabel.setIcon(coverIcon);
        
        
        
        
        /////////////////////////////testing
            // Assuming you have a List<Song> queueList to store the songs
        JPanel newSongPanel = createSongPanel("Title 1", "Artist 1", "42:69");
        queueScroll.setViewportView(newSongPanel);

        setLyricsArea("test lyrics");
 
        /////////////////////////////
       
        
        
    }
   

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
        pauseButton = new javax.swing.JLabel();
        queuePanel = new javax.swing.JPanel();
        returnButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        songPanel = new javax.swing.JPanel();
        currentCoverLabel = new javax.swing.JLabel();
        currentTitleLabel = new javax.swing.JLabel();
        currentArtistLabel = new javax.swing.JLabel();
        currentDurationLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        queueScroll = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        lyricsPanel = new javax.swing.JPanel();
        lyricsLabel = new javax.swing.JLabel();
        lyricsScroll = new javax.swing.JScrollPane();
        lyricsArea = new javax.swing.JTextArea();
        lyricsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symph [Playing]");
        setBackground(new java.awt.Color(26, 23, 32));
        setMaximumSize(new java.awt.Dimension(1100, 600));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(26, 23, 32));
        mainPanel.setPreferredSize(new java.awt.Dimension(500, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        playingPanel.setBackground(new java.awt.Color(26, 23, 32));
        playingPanel.setPreferredSize(new java.awt.Dimension(500, 600));

        progressSlider.setBackground(new java.awt.Color(40, 40, 57));
        progressSlider.setForeground(new java.awt.Color(226, 115, 150));

        backButton.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        backButton.setForeground(new java.awt.Color(226, 115, 150));
        backButton.setText("«");

        forwardButton.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        forwardButton.setForeground(new java.awt.Color(226, 115, 150));
        forwardButton.setText("»");

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

        favButton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        favButton.setForeground(new java.awt.Color(115, 129, 137));
        favButton.setText("♥");

        artistLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        artistLabel.setForeground(new java.awt.Color(240, 240, 240));
        artistLabel.setText("Song Artist");

        startLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        startLabel.setForeground(new java.awt.Color(240, 240, 240));
        startLabel.setText("00:00");

        endLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        endLabel.setForeground(new java.awt.Color(240, 240, 240));
        endLabel.setText("XX:XX");

        playButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        playButton.setForeground(new java.awt.Color(226, 115, 150));
        playButton.setText("►");
        playButton.setMaximumSize(new java.awt.Dimension(566, 512));

        leaveButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        leaveButton.setForeground(new java.awt.Color(115, 126, 137));
        leaveButton.setText("<");

        queueButton.setFont(new java.awt.Font("Century Gothic", 0, 32)); // NOI18N
        queueButton.setForeground(new java.awt.Color(115, 129, 137));
        queueButton.setText("≡");
        queueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queueButtonMouseClicked(evt);
            }
        });

        pauseButton.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        pauseButton.setForeground(new java.awt.Color(226, 115, 150));
        pauseButton.setText("II");

        javax.swing.GroupLayout playingPanelLayout = new javax.swing.GroupLayout(playingPanel);
        playingPanel.setLayout(playingPanelLayout);
        playingPanelLayout.setHorizontalGroup(
            playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playingPanelLayout.createSequentialGroup()
                .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(playingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(queueButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playingPanelLayout.createSequentialGroup()
                        .addContainerGap(57, Short.MAX_VALUE)
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
                                        .addComponent(favButton))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playingPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(leaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playingPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(backButton)
                .addGap(31, 31, 31)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pauseButton)
                .addGap(33, 33, 33)
                .addComponent(forwardButton)
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
                    .addComponent(forwardButton)
                    .addComponent(pauseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(playingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueButton)
                .addGap(0, 0, 0))
        );

        artistLabel.getAccessibleContext().setAccessibleName("artistLabel");
        playButton.getAccessibleContext().setAccessibleDescription("");

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

        songPanel.setBackground(new java.awt.Color(26, 23, 32));
        songPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        currentCoverLabel.setForeground(new java.awt.Color(240, 240, 240));
        currentCoverLabel.setText("pictur");
        currentCoverLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        currentCoverLabel.setMaximumSize(new java.awt.Dimension(44, 44));
        currentCoverLabel.setMinimumSize(new java.awt.Dimension(44, 44));
        currentCoverLabel.setPreferredSize(new java.awt.Dimension(44, 44));

        currentTitleLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        currentTitleLabel.setForeground(new java.awt.Color(240, 240, 240));
        currentTitleLabel.setText("Song Title");

        currentArtistLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        currentArtistLabel.setForeground(new java.awt.Color(240, 240, 240));
        currentArtistLabel.setText("Song Artist");

        currentDurationLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        currentDurationLabel.setForeground(new java.awt.Color(240, 240, 240));
        currentDurationLabel.setText("XX:XX");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("ıIı");

        javax.swing.GroupLayout songPanelLayout = new javax.swing.GroupLayout(songPanel);
        songPanel.setLayout(songPanelLayout);
        songPanelLayout.setHorizontalGroup(
            songPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentCoverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(songPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentTitleLabel)
                    .addComponent(currentArtistLabel))
                .addGap(196, 196, 196)
                .addComponent(currentDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        songPanelLayout.setVerticalGroup(
            songPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(songPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(songPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentCoverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(songPanelLayout.createSequentialGroup()
                        .addComponent(currentTitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentArtistLabel)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, songPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(currentDurationLabel)
                .addGap(19, 19, 19))
        );

        queueScroll.setBackground(new java.awt.Color(26, 23, 32));
        queueScroll.setBorder(null);
        queueScroll.setForeground(new java.awt.Color(26, 23, 32));
        queueScroll.setMaximumSize(new java.awt.Dimension(252, 370));
        queueScroll.setPreferredSize(new java.awt.Dimension(437, 59));
        queueScroll.setViewportView(null);
        queueScroll.getViewport().setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Next Up");

        javax.swing.GroupLayout queuePanelLayout = new javax.swing.GroupLayout(queuePanel);
        queuePanel.setLayout(queuePanelLayout);
        queuePanelLayout.setHorizontalGroup(
            queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuePanelLayout.createSequentialGroup()
                .addGroup(queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(queuePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(returnButton))
                    .addGroup(queuePanelLayout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addGroup(queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(songPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(queueScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        queuePanelLayout.setVerticalGroup(
            queuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(songPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("jLabel2");

        mainPanel.add(queuePanel, "card3");

        lyricsPanel.setBackground(new java.awt.Color(26, 23, 32));
        lyricsPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        lyricsLabel.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        lyricsLabel.setForeground(new java.awt.Color(240, 240, 240));
        lyricsLabel.setText("Lyrics");

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
        lyricsArea.setCaretPosition(0);
        lyricsArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lyricsScroll.setViewportView(lyricsArea);

        lyricsButton.setBackground(new java.awt.Color(115, 126, 137));
        lyricsButton.setForeground(new java.awt.Color(240, 240, 240));
        lyricsButton.setText("Add Lyrics");
        lyricsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lyricsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lyricsPanelLayout = new javax.swing.GroupLayout(lyricsPanel);
        lyricsPanel.setLayout(lyricsPanelLayout);
        lyricsPanelLayout.setHorizontalGroup(
            lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addComponent(lyricsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addComponent(lyricsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lyricsButton)
                        .addGap(30, 30, 30))))
        );
        lyricsPanelLayout.setVerticalGroup(
            lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyricsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lyricsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lyricsPanelLayout.createSequentialGroup()
                        .addComponent(lyricsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lyricsScroll)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lyricsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lyricsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lyricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lyricsButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                lyricsArea.setText(sb.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
    }//GEN-LAST:event_lyricsButtonActionPerformed


private JPanel createSongPanel(String title, String artist, String duration) {
    JPanel nextSongPanel1 = new JPanel();
    nextSongPanel1.setBackground(new java.awt.Color(26, 23, 32));
    nextSongPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

    JLabel nextCoverLabel1 = new JLabel("pictur");
    nextCoverLabel1.setForeground(new java.awt.Color(240, 240, 240));
    nextCoverLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
    nextCoverLabel1.setMaximumSize(new java.awt.Dimension(44, 44));
    nextCoverLabel1.setMinimumSize(new java.awt.Dimension(44, 44));
    nextCoverLabel1.setPreferredSize(new java.awt.Dimension(44, 44));

    JLabel nextTitleLabel1 = new JLabel(title);
    nextTitleLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18));
    nextTitleLabel1.setForeground(new java.awt.Color(240, 240, 240));

    JLabel nextArtistLabel1 = new JLabel(artist);
    nextArtistLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12));
    nextArtistLabel1.setForeground(new java.awt.Color(240, 240, 240));

    JLabel nextDurationLabel1 = new JLabel(duration);
    nextDurationLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12));
    nextDurationLabel1.setForeground(new java.awt.Color(240, 240, 240));

    JLabel numberLabel1 = new JLabel("  "); //supposed to add yung number ng song pero idk how pa so ehe
    numberLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18));
    numberLabel1.setForeground(new java.awt.Color(240, 240, 240));

    javax.swing.GroupLayout nextSongPanel1Layout = new javax.swing.GroupLayout(nextSongPanel1);
    nextSongPanel1.setLayout(nextSongPanel1Layout);
    nextSongPanel1Layout.setHorizontalGroup(
        nextSongPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextSongPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(numberLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, 16) // 16-pixel non-resizable gap
                .addComponent(nextCoverLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nextSongPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextTitleLabel1)
                    .addComponent(nextArtistLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(nextDurationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
    );
    nextSongPanel1Layout.setVerticalGroup(
        nextSongPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextSongPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nextSongPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nextSongPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numberLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextCoverLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nextSongPanel1Layout.createSequentialGroup()
                        .addComponent(nextTitleLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextArtistLabel1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextSongPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextDurationLabel1)
                .addGap(19, 19, 19))
    );
    // Set the preferred size of nextSongPanel1 to match songPanel1
    nextSongPanel1.setPreferredSize(songPanel.getPreferredSize());

    return nextSongPanel1;
}

    



    private void setSliderProgress(){ //hoping malala this shiz works

//        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
//            Duration totalDuration = mediaPlayer.getTotalDuration();
//            double progress = newValue.toMillis() / totalDuration.toMillis() * 100;
//            progressSlider.setValue((int)progress);
//        });
//        
    }

    
    private void setLyricsArea(String lyrics){ //hoping dat dis works as well ehe
        lyricsArea.setText(lyrics);
    }


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

    public void setCoverUrl(String urlString) {
        try {
            coverUrl = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
        UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
        ex.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PlayView().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PlayView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel artistLabel;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel coverLabel;
    private javax.swing.JPanel coverPanel;
    private javax.swing.JLabel currentArtistLabel;
    private javax.swing.JLabel currentCoverLabel;
    private javax.swing.JLabel currentDurationLabel;
    private javax.swing.JLabel currentTitleLabel;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel favButton;
    private javax.swing.JLabel forwardButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel leaveButton;
    private javax.swing.JTextArea lyricsArea;
    private javax.swing.JButton lyricsButton;
    private javax.swing.JLabel lyricsLabel;
    private javax.swing.JPanel lyricsPanel;
    private javax.swing.JScrollPane lyricsScroll;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel pauseButton;
    private javax.swing.JLabel playButton;
    private javax.swing.JPanel playingPanel;
    private javax.swing.JLabel plusLabel;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JLabel queueButton;
    private javax.swing.JPanel queuePanel;
    private javax.swing.JScrollPane queueScroll;
    private javax.swing.JLabel returnButton;
    private javax.swing.JPanel songPanel;
    private javax.swing.JLabel startLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
