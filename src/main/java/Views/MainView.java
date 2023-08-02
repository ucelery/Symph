package Views;
import Views.Custom.CustomDashedBorder;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/* UPDATE AS OF JULY 23, 2023 5:55 PM:
    WIP:
    the add song panel (change colors n other design shit na lng un. the button for cancel is working)
    
    NOT YET STARTED:
    queuing page
    full screen page ng songs
    design ng playlist overview smth (i wanna change the "helpp" text label to a play button lmfao + insert an add to queue button somewhere sa tab)
    see more ng playlist tabs
*/

import Controllers.Controller;
import Utilities.MusicPlayer.MusicPlayerListener;
import Utilities.PlayerManager;
import Utilities.Playlist;
import Utilities.Song;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainView extends javax.swing.JFrame implements MusicPlayerListener {
    ArrayList<PlaylistTab> listPlaylists = new ArrayList<>();
    private CardLayout cardLayout;
    
    Controller controller;
    private static MainView mainView;
    Song songToUpload = new Song();
    Playlist playlistToMake = new Playlist();
    
    public MainView() throws IOException {
        int maxProcesses = 6;
        
        Thread initThread = new Thread(() -> {
            try {
                // TODO Add Loading
                LoadingView loadingView = new LoadingView();
                loadingView.setMaxLoadingBar(maxProcesses);
                loadingView.setVisible(true);
                
                loadingView.incrementLoadingBar();
                
                // Initialize Controller
                controller = new Controller();
                loadingView.incrementLoadingBar();

                // Initialize Components
                initComponents();
                loadingView.incrementLoadingBar();
                
                // Initialize Views
                try {
                    playingView1.setController(controller);
                    loadingView.incrementLoadingBar();
                    
                    controller.getPlayerManager().addListener(playingView1);
                    controller.getPlayerManager().addListener(this);
                    loadingView.incrementLoadingBar();
                    initSongComponents();
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // TODO Exit Loading
                loadingView.setVisible(false);
                loadingView.incrementLoadingBar();
                
                // Show Main View
                mainView.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        initThread.start();
    }
    
        @Override
    public void onSongEnd(Song song) {
        
    }

    @Override
    public void onSongPlay(Song song) {
        try {
            // Update Song Cover Image, Song Title, Song Artist, Lyrics (if any)
            // Cover URL
            try {
                URL coverUrl = new URL(song.getImageURL());
                Image coverImage = ImageIO.read(coverUrl);

                int labelWidth = currentSongImage.getWidth();
                Image scaledCover = coverImage.getScaledInstance(labelWidth, -1, Image.SCALE_SMOOTH);
                ImageIcon coverIcon = new ImageIcon(scaledCover);
                currentSongImage.setIcon(coverIcon);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            
            // Song Title
            songTitle.setText(song.getTitle());
            
            // Song Artist
            artist1.setText(song.getArtist());
            
            // Slider Max
            progressSlider.setMaximum(song.getDuration());
        } catch (IOException ex) {
            Logger.getLogger(PlayingView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onSongPause(Song song) {
        
    }

    @Override
    public void onSongResume(Song song) {
        
    }

    @Override
    public void onSongPlaying(int currentDur) {
        int min = currentDur / 60;
        int sec = currentDur - (min * 60);
        
        progressSlider.setValue(currentDur);
    }

    @Override
    public void onQueueUpdate(java.util.Queue<Song> songs) {
        
    }

    @Override
    public void onQueueEnd() {
        
    }
     
    
    private void initSongComponents() throws MalformedURLException, IOException {
        //plus icon beside both playlist and My song labels
        miniLogo.setIcon(putIcon(new URL("https://cdn.discordapp.com/attachments/1062615866665082992/1131590443147202650/Symph_Logo_-_Light.png"), 30));
        addSongs.setIcon(putIcon(new URL("https://i.imgur.com/OE3vVd4.png"), 22));
        
        
        //upload a song icon (ung may arrow pataas cai)
        uploadSong.setIcon(putIcon(new URL("https://i.imgur.com/nQXQSXE.png"), 20));
        
        //upload a song icon (ung may arrow pataas cai)
        uploadImagebtn.setIcon(putIcon(new URL("https://i.imgur.com/0CGgGDn.png"), 112));
        
        previousBtn.setIcon(putIcon(new URL("https://i.imgur.com/x8Ou0KM.png"), 18));
        playBtn.setIcon(putIcon(new URL("https://i.imgur.com/puOQ4gv.png"), 30));
        nextBtn.setIcon(putIcon(new URL("https://i.imgur.com/8u4hKzs.png"), 18));
        
        openPlayingViewbtn.setIcon(putIcon(new URL("https://i.imgur.com/NY0U5EG.png"), 18));
        
        //create a bottom border sa header containing #, title, artist, and date added 
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#B8B8B8"));
        Header.setBorder(bottomBorder);
        Border topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.decode("#333333"));
        songPlay1.setBorder(topBorder);
        
        //all of this just to add left padding inside a jtextfield dfgerhe
        Border emptyBorder = new EmptyBorder(0, 15, 0, 0);
        Border existingBorder = inputTitleSong.getBorder();
        Border compoundBorder; 
        compoundBorder = new CompoundBorder(existingBorder, emptyBorder); 
         
        inputTitleSong.setBorder(compoundBorder);
        inputArtist.setBorder(compoundBorder); //yay ig
        
        //stoko kasi ng dashed panel with custom thickness and distance (u can find the CustomDashedBorder class sa Views.Custom package
        jPanel9.setBorder(new CustomDashedBorder(Color.decode("#B8B8B8"), 3, 10, 8));
        
        LeaveButtonMouseListener leaveButtonListener = new LeaveButtonMouseListener();
        playingView1.leaveButton.addMouseListener(leaveButtonListener);
        
        MainPanel.removeAll();
        MainPanel.add(SubPanel1);
        MainPanel.repaint();
        MainPanel.revalidate();
        
        setSize(1114, 638);
        //createPlaylistPanel();
        createSongPanel(controller.getSongs());
        setLocationRelativeTo(null);
        setResizable(false);
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
    
     /* private void createPlaylistPanel() throws IOException {
         // insert first 5 playlists only to preview
         int limit = 5;
         
         //display playlists
         int index = 0;
         for(PlaylistTab playlist : listPlaylists) {
            playlistContainer.add(playlist);
            index++;
            
            if (index >= limit)
                break;
        }
     }
     */
     
     private void createSongPanel(ArrayList<Song> songs) throws IOException {
         //display songs
         int index = 0;
            songsContainer.removeAll();
            songsContainer.repaint();
            songsContainer.revalidate(); 
            for(Song song : songs) {
                Songs newSongsRow = new Songs(String.valueOf(index + 1), song);
                songsContainer.add(newSongsRow);
                newSongsRow.addListener(controller);
                index++;
            }
     }

    @Override
    public void onSongBankAdd(ArrayList<Song> songs) {
        try {
            for (Song song : songs) {
                System.out.println(song);
            }
            createSongPanel(songs);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class LeaveButtonMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // Action to be performed when Button 1 is clicked
            MainPanel.removeAll();
            MainPanel.add(SubPanel1);
            MainPanel.repaint();
            MainPanel.revalidate();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        SubPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        miniLogo = new javax.swing.JLabel();
        SubPanel2 = new javax.swing.JPanel();
        block4 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        addSongs = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsContainer = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        songPlay1 = new javax.swing.JPanel();
        currentSongImage = new javax.swing.JLabel();
        songTitle = new javax.swing.JLabel();
        artist1 = new javax.swing.JLabel();
        progressSlider = new javax.swing.JSlider();
        previousBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        openPlayingViewbtn = new javax.swing.JButton();
        playingView1 = new Views.PlayingView();
        addSongPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        song1 = new javax.swing.JLabel();
        uploadImagebtn = new javax.swing.JButton();
        titleSong = new javax.swing.JLabel();
        inputTitleSong = new javax.swing.JTextField();
        artist = new javax.swing.JLabel();
        inputArtist = new javax.swing.JTextField();
        song = new javax.swing.JLabel();
        uploadSong = new javax.swing.JButton();
        titleSong1 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 23, 32));
        setMinimumSize(new java.awt.Dimension(1115, 638));
        getContentPane().setLayout(null);

        MainPanel.setLayout(new java.awt.CardLayout());

        SubPanel1.setBackground(new java.awt.Color(26, 23, 32));

        jPanel1.setBackground(new java.awt.Color(26, 23, 32));
        jPanel1.setLayout(null);

        miniLogo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        miniLogo.setForeground(new java.awt.Color(240, 240, 240));
        miniLogo.setText("Symph");
        jPanel1.add(miniLogo);
        miniLogo.setBounds(10, 6, 260, 40);

        SubPanel2.setBackground(new java.awt.Color(26, 23, 32));
        SubPanel2.setLayout(null);

        block4.setBackground(new java.awt.Color(39, 34, 47));
        block4.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(39, 34, 47));
        jPanel4.setLayout(null);

        addSongs.setBorder(null);
        addSongs.setBorderPainted(false);
        addSongs.setContentAreaFilled(false);
        addSongs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongsActionPerformed(evt);
            }
        });
        jPanel4.add(addSongs);
        addSongs.setBounds(140, 15, 22, 22);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("My Songs");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 10, 120, 30);

        block4.add(jPanel4);
        jPanel4.setBounds(20, 0, 1060, 40);

        jScrollPane1.setBackground(java.awt.Color.gray);
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        songsContainer.setBackground(new java.awt.Color(39, 34, 47));
        songsContainer.setAlignmentX(0.0F);
        songsContainer.setAlignmentY(0.0F);
        songsContainer.setLayout(new javax.swing.BoxLayout(songsContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(songsContainer);

        block4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 1080, 420);

        Header.setBackground(new java.awt.Color(39, 34, 47));
        Header.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(184, 184, 184));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("#");
        Header.add(jLabel3);
        jLabel3.setBounds(0, 12, 10, 19);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(184, 184, 184));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Title");
        Header.add(jLabel4);
        jLabel4.setBounds(40, 12, 40, 19);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(184, 184, 184));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Artist");
        Header.add(jLabel5);
        jLabel5.setBounds(470, 12, 40, 19);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(184, 184, 184));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Duration");
        Header.add(jLabel2);
        jLabel2.setBounds(860, 12, 90, 19);

        block4.add(Header);
        Header.setBounds(40, 40, 1000, 40);

        SubPanel2.add(block4);
        block4.setBounds(10, 0, 1080, 500);

        songPlay1.setBackground(new java.awt.Color(26, 23, 32));
        songPlay1.setLayout(null);

        currentSongImage.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        currentSongImage.setForeground(new java.awt.Color(184, 184, 184));
        currentSongImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        currentSongImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        songPlay1.add(currentSongImage);
        currentSongImage.setBounds(30, 5, 40, 40);

        songTitle.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        songTitle.setForeground(new java.awt.Color(240, 240, 240));
        songTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        songTitle.setText("                                                    ");
        songPlay1.add(songTitle);
        songTitle.setBounds(80, 5, 310, 23);

        artist1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        artist1.setForeground(new java.awt.Color(240, 240, 240));
        artist1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        artist1.setText("                                                                              ");
        songPlay1.add(artist1);
        artist1.setBounds(80, 28, 300, 16);

        progressSlider.setBackground(new java.awt.Color(40, 40, 57));
        progressSlider.setForeground(new java.awt.Color(226, 115, 150));
        progressSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        songPlay1.add(progressSlider);
        progressSlider.setBounds(660, 15, 310, 16);

        previousBtn.setBackground(new java.awt.Color(26, 23, 32));
        previousBtn.setBorder(null);
        previousBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });
        songPlay1.add(previousBtn);
        previousBtn.setBounds(460, 10, 30, 30);

        playBtn.setBackground(new java.awt.Color(26, 23, 32));
        playBtn.setBorder(null);
        playBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playBtnMousePressed(evt);
            }
        });
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        songPlay1.add(playBtn);
        playBtn.setBounds(520, 10, 30, 30);

        nextBtn.setBackground(new java.awt.Color(26, 23, 32));
        nextBtn.setBorder(null);
        nextBtn.setBorderPainted(false);
        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        songPlay1.add(nextBtn);
        nextBtn.setBounds(580, 10, 30, 30);

        openPlayingViewbtn.setBackground(new java.awt.Color(26, 23, 32));
        openPlayingViewbtn.setBorder(null);
        openPlayingViewbtn.setContentAreaFilled(false);
        openPlayingViewbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openPlayingViewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPlayingViewbtnActionPerformed(evt);
            }
        });
        songPlay1.add(openPlayingViewbtn);
        openPlayingViewbtn.setBounds(1040, 10, 30, 30);

        javax.swing.GroupLayout SubPanel1Layout = new javax.swing.GroupLayout(SubPanel1);
        SubPanel1.setLayout(SubPanel1Layout);
        SubPanel1Layout.setHorizontalGroup(
            SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanel1Layout.createSequentialGroup()
                .addGroup(SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        SubPanel1Layout.setVerticalGroup(
            SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        MainPanel.add(SubPanel1, "card2");
        MainPanel.add(playingView1, "card5");

        addSongPanel.setBackground(new java.awt.Color(26, 23, 32));
        addSongPanel.setMaximumSize(new java.awt.Dimension(1100, 600));
        addSongPanel.setPreferredSize(new java.awt.Dimension(1100, 600));

        jPanel7.setBackground(new java.awt.Color(39, 34, 47));

        jPanel9.setBackground(new java.awt.Color(39, 34, 47));
        jPanel9.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        jPanel9.setPreferredSize(new java.awt.Dimension(288, 288));

        song1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        song1.setForeground(new java.awt.Color(226, 115, 150));
        song1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        song1.setText("Select an Image to Upload");

        uploadImagebtn.setBackground(new java.awt.Color(39, 34, 47));
        uploadImagebtn.setBorder(null);
        uploadImagebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadImagebtn.setPreferredSize(new java.awt.Dimension(135, 135));
        uploadImagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImagebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(song1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(uploadImagebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(uploadImagebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(song1)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        titleSong.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        titleSong.setForeground(new java.awt.Color(184, 184, 184));
        titleSong.setText("TITLE OF SONG");

        inputTitleSong.setBackground(new java.awt.Color(39, 34, 47));
        inputTitleSong.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        inputTitleSong.setForeground(new java.awt.Color(122, 122, 122));
        inputTitleSong.setText("E.g. Raining in Manila");
        inputTitleSong.setToolTipText("");
        inputTitleSong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        inputTitleSong.setCaretColor(new java.awt.Color(240, 240, 240));
        inputTitleSong.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputTitleSong.setMargin(new java.awt.Insets(5, 6, 2, 6));
        inputTitleSong.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        inputTitleSong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTitleSongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTitleSongFocusLost(evt);
            }
        });

        artist.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        artist.setForeground(new java.awt.Color(184, 184, 184));
        artist.setText("ARTIST");

        inputArtist.setBackground(new java.awt.Color(39, 34, 47));
        inputArtist.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        inputArtist.setForeground(new java.awt.Color(122, 122, 122));
        inputArtist.setText("E.g. Lola Amour");
        inputArtist.setToolTipText("");
        inputArtist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        inputArtist.setCaretColor(new java.awt.Color(240, 240, 240));
        inputArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputArtist.setMargin(new java.awt.Insets(5, 6, 2, 6));
        inputArtist.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        inputArtist.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputArtistFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputArtistFocusLost(evt);
            }
        });

        song.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        song.setForeground(new java.awt.Color(184, 184, 184));
        song.setText("SONG");

        uploadSong.setBackground(new java.awt.Color(39, 34, 47));
        uploadSong.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        uploadSong.setForeground(new java.awt.Color(203, 157, 223));
        uploadSong.setText("Upload Song");
        uploadSong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        uploadSong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadSong.setPreferredSize(new java.awt.Dimension(97, 35));
        uploadSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadSongActionPerformed(evt);
            }
        });

        titleSong1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        titleSong1.setForeground(new java.awt.Color(184, 184, 184));
        titleSong1.setText("Accepted File Types: .png, .jpg, and .jpeg only");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(titleSong1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTitleSong, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleSong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(artist, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(song, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uploadSong, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(titleSong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTitleSong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(artist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(song)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadSong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(titleSong1)
                .addContainerGap())
        );

        submitBtn.setBackground(new java.awt.Color(226, 115, 150));
        submitBtn.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(240, 240, 240));
        submitBtn.setText("Save");
        submitBtn.setBorder(null);
        submitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(26, 23, 32));
        cancelBtn.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(226, 115, 150));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(null);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setPreferredSize(new java.awt.Dimension(85, 35));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addSongPanelLayout = new javax.swing.GroupLayout(addSongPanel);
        addSongPanel.setLayout(addSongPanelLayout);
        addSongPanelLayout.setHorizontalGroup(
            addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addContainerGap(698, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addSongPanelLayout.setVerticalGroup(
            addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        MainPanel.add(addSongPanel, "card4");

        getContentPane().add(MainPanel);
        MainPanel.setBounds(0, 0, 1100, 600);
        MainPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongsActionPerformed
        // changing from main view to add song card panel
        MainPanel.removeAll();
        MainPanel.add(addSongPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_addSongsActionPerformed

    private void openPlayingViewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPlayingViewbtnActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.add(playingView1);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_openPlayingViewbtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        controller.skipAudio();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_previousBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // changing from add song to main view card panel (di ko lam bat ang layu nila sa isat isa ditu)
        MainPanel.removeAll();
        MainPanel.add(SubPanel1);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // On Add Song Submit
        String songTitle = inputTitleSong.getText();
        String songArtist = inputArtist.getText();
        songToUpload.setArtist(songArtist);
        songToUpload.setTitle(songTitle);

        controller.uploadSong(songToUpload);
    }//GEN-LAST:event_submitBtnActionPerformed

    private void uploadSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadSongActionPerformed
        // Upload Song File
        songToUpload.setAudioFile();
    }//GEN-LAST:event_uploadSongActionPerformed

    private void inputArtistFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputArtistFocusLost
        // placeholder for artist comes back if empty ung textfield
        if (inputArtist.getText().isEmpty()) {
            inputArtist.setText("E.g. Lola Amour");
            inputArtist.setForeground(Color.decode("#7A7A7A"));
        }
    }//GEN-LAST:event_inputArtistFocusLost

    private void inputArtistFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputArtistFocusGained
        // when user clicks on jtextfield to input artist name, mawawala ung placeholder
        if (inputArtist.getText().equals("E.g. Lola Amour")) {
            inputArtist.setText("");
            inputArtist.setForeground(Color.decode("#f0f0f0"));
        }
    }//GEN-LAST:event_inputArtistFocusGained

    private void inputTitleSongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTitleSongFocusLost
        // placeholder for song title comes back if empty ung textfield
        if (inputTitleSong.getText().isEmpty()) {
            inputTitleSong.setText("E.g. Raining in Manila");
            inputTitleSong.setForeground(Color.decode("#7A7A7A"));
        }
    }//GEN-LAST:event_inputTitleSongFocusLost

    private void inputTitleSongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTitleSongFocusGained
        // when user clicks on jtextfield to input song title, mawawala ung placeholder
        if (inputTitleSong.getText().equals("E.g. Raining in Manila")) {
            inputTitleSong.setText("");
            inputTitleSong.setForeground(Color.decode("#f0f0f0"));
        }
    }//GEN-LAST:event_inputTitleSongFocusGained

    private void uploadImagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImagebtnActionPerformed
        songToUpload.setCoverFile();
    }//GEN-LAST:event_uploadImagebtnActionPerformed

    private void playBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMousePressed
         if (controller.getMusicPlayerStatus() == PlayerManager.PlayerState.IDLE) {
            controller.playAudio();
        } else {
            controller.toggleAudio();
        }
    }//GEN-LAST:event_playBtnMousePressed

    public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (UnsupportedLookAndFeelException ex) {
        ex.printStackTrace();
    }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainView = new MainView();
                    mainView.setVisible(false); // Initially Hidden since we have to load stuff first
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel SubPanel1;
    private javax.swing.JPanel SubPanel2;
    private javax.swing.JPanel addSongPanel;
    private javax.swing.JButton addSongs;
    private javax.swing.JLabel artist;
    private javax.swing.JLabel artist1;
    private javax.swing.JPanel block4;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel currentSongImage;
    private javax.swing.JTextField inputArtist;
    private javax.swing.JTextField inputTitleSong;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel miniLogo;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton openPlayingViewbtn;
    private javax.swing.JButton playBtn;
    private Views.PlayingView playingView1;
    private javax.swing.JButton previousBtn;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JLabel song;
    private javax.swing.JLabel song1;
    private javax.swing.JPanel songPlay1;
    private javax.swing.JLabel songTitle;
    private javax.swing.JPanel songsContainer;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel titleSong;
    private javax.swing.JLabel titleSong1;
    private javax.swing.JButton uploadImagebtn;
    private javax.swing.JButton uploadSong;
    // End of variables declaration//GEN-END:variables
}
