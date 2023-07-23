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

/* UPDATE AS OF JULY 23, 2023 5:55 PM:
    WIP:
    the add song panel (change colors n other design shit na lng un. the button for cancel is working)
    
    NOT YET STARTED:
    queuing page
    full screen page ng songs
    design ng playlist overview smth (i wanna change the "helpp" text label to a play button lmfao + insert an add to queue button somewhere sa tab)
    see more ng playlist tabs
*/

public class MainView extends javax.swing.JFrame {
    ArrayList<PlaylistTab> listPlaylists = new ArrayList<>();
    ArrayList<Songs> listSongs = new ArrayList<>();
    private CardLayout cardLayout;
    int index = 0;
    String songName, artistName, i, dateAdd;
    URL url;
    public MainView() throws IOException {
        initComponents();
        
        //plus icon beside both playlist and My song labels
        addPlaylist.setIcon(putIcon(new URL("https://i.imgur.com/OE3vVd4.png"), 22));
        addSongs.setIcon(putIcon(new URL("https://i.imgur.com/OE3vVd4.png"), 22));
        
        //fullscreen song icon (dalawang arrows pointing away)
        fullScreen.setIcon(putIcon(new URL("https://i.imgur.com/nmklyPO.png"), 0));
        
        //upload a song icon (ung may arrow pataas cai)
        uploadSong.setIcon(putIcon(new URL("https://i.imgur.com/nQXQSXE.png"), 20));
        
        //upload a song icon (ung may arrow pataas cai)
        uploadImagebtn.setIcon(putIcon(new URL("https://i.imgur.com/0CGgGDn.png"), 112));
        
        //create a bottom border sa header containing #, title, artist, and date added 
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#B8B8B8"));
        Header.setBorder(bottomBorder);
        
        //all of this just to add left padding inside a jtextfield dfgerhe
        Border emptyBorder = new EmptyBorder(0, 15, 0, 0);
        Border existingBorder = inputTitleSong.getBorder();
        Border compoundBorder; 
        compoundBorder = new CompoundBorder(existingBorder, emptyBorder); 
         
        inputTitleSong.setBorder(compoundBorder);
        inputArtist.setBorder(compoundBorder); //yay ig
        
        //stoko kasi ng dashed panel with custom thickness and distance (u can find the CustomDashedBorder class sa Views.Custom package
        jPanel9.setBorder(new CustomDashedBorder(Color.decode("#B8B8B8"), 3, 10, 8));
         
        
        setSize(1114, 638);
        createPlaylistPanel();
        createSongPanel();
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
    
     private void createPlaylistPanel() throws IOException {
         // insert first 5 playlists only to preview
         
         //dummy playlists to insert in an array
         String playlistName;
         URL playlistImage;
         
         playlistName = "cottage core charot";
         playlistImage = new URL("https://i.pinimg.com/564x/95/2b/ba/952bba9702d94b8715e4210c9e194dab.jpg");
         listPlaylists.add(new PlaylistTab(playlistName, playlistImage));
         
         playlistName = "be gay do witchcraft";
         playlistImage = new URL("https://i.pinimg.com/564x/ac/2e/1e/ac2e1e63e59309c0e2af1e2bc6cb7671.jpg");
         listPlaylists.add(new PlaylistTab(playlistName, playlistImage));
         
         playlistName = "i dont need sleep i need answers";
         playlistImage = new URL("https://i.pinimg.com/564x/68/55/20/6855204585282534fa03069707269e75.jpg");
         listPlaylists.add(new PlaylistTab(playlistName, playlistImage));
         
         playlistName = "it is time to be unhinged";
         playlistImage = new URL("https://i.pinimg.com/564x/3e/d0/45/3ed0457f604d53b779971d05703205fa.jpg");
         listPlaylists.add(new PlaylistTab(playlistName, playlistImage));
         
         playlistImage = new URL("https://i.pinimg.com/564x/64/c4/6e/64c46ecd2d2e3a50761b8ed93c8351ae.jpg");
         playlistName = "emo era";
         listPlaylists.add(new PlaylistTab(playlistName, playlistImage));
         
         //display playlists
         for(PlaylistTab playlist : listPlaylists) {
            playlistContainer.add(playlist);
        }
     }
     
     private void createSongPanel() throws IOException {
         // insert all songs from database
         
         //sample songs to insert in an array
         songName = "Duda";
         artistName = "Zild";
         index ++;
         i = Integer.toString(index);
         dateAdd = "7/21/2023";
         url = new URL("https://i.pinimg.com/564x/b0/e6/1d/b0e61d5ece63df22a54798667c1d5812.jpg");
         listSongs.add(new Songs(songName, artistName, i, dateAdd, url));
         
         songName = "Pagtingin";
         artistName = "Ben&Ben";
         index ++;
         i = Integer.toString(index);
         dateAdd = "7/21/2023";
         url = new URL("https://upload.wikimedia.org/wikipedia/en/7/7e/Ben%26Ben_-_Limasawa_Street.png");
         listSongs.add(new Songs(songName, artistName, i, dateAdd, url));
         
         songName = "Estranghero";
         artistName = "Cup of Joe";
         index ++;
         i = Integer.toString(index);
         dateAdd = "7/21/2023";
         url = new URL("https://i.scdn.co/image/ab67616d0000b273d6b243a650e138a3e549cab7");
         listSongs.add(new Songs(songName, artistName, i, dateAdd, url));
         
         //display songs
          for(Songs songs : listSongs) {
            songsContainer.add(songs);
        }
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        SubPanel1 = new javax.swing.JPanel();
        songPlay1 = new javax.swing.JPanel();
        SubPanel2 = new javax.swing.JPanel();
        block3 = new javax.swing.JPanel();
        playlistContainer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        seeMore = new javax.swing.JButton();
        addPlaylist = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        block4 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        addSongs = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fullScreen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsContainer = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        songPlay = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
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
        jButton3 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(26, 23, 32));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        getContentPane().setLayout(null);

        MainPanel.setLayout(new java.awt.CardLayout());

        songPlay1.setBackground(new java.awt.Color(26, 23, 32));
        songPlay1.setLayout(null);

        SubPanel2.setBackground(new java.awt.Color(26, 23, 32));
        SubPanel2.setLayout(null);

        block3.setBackground(new java.awt.Color(39, 34, 47));
        block3.setLayout(null);

        playlistContainer.setBackground(new java.awt.Color(39, 34, 47));
        playlistContainer.setAlignmentX(0.0F);
        playlistContainer.setAlignmentY(0.0F);
        playlistContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        block3.add(playlistContainer);
        playlistContainer.setBounds(0, 50, 1080, 220);

        jPanel3.setBackground(new java.awt.Color(39, 34, 47));
        jPanel3.setLayout(null);

        seeMore.setBackground(new java.awt.Color(26, 23, 32));
        seeMore.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        seeMore.setForeground(new java.awt.Color(184, 184, 184));
        seeMore.setText("See More");
        seeMore.setBorder(null);
        seeMore.setBorderPainted(false);
        seeMore.setContentAreaFilled(false);
        seeMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seeMoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seeMoreMouseExited(evt);
            }
        });
        jPanel3.add(seeMore);
        seeMore.setBounds(910, 15, 90, 20);

        addPlaylist.setBorder(null);
        addPlaylist.setBorderPainted(false);
        addPlaylist.setContentAreaFilled(false);
        addPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaylistActionPerformed(evt);
            }
        });
        jPanel3.add(addPlaylist);
        addPlaylist.setBounds(162, 13, 22, 22);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("My Playlists");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 10, 133, 30);

        block3.add(jPanel3);
        jPanel3.setBounds(20, 0, 1060, 40);

        SubPanel2.add(block3);
        block3.setBounds(10, 10, 1080, 290);

        block4.setBackground(new java.awt.Color(39, 34, 47));
        block4.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(39, 34, 47));
        jPanel4.setLayout(null);

        addSongs.setBorder(null);
        addSongs.setBorderPainted(false);
        addSongs.setContentAreaFilled(false);
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

        fullScreen.setBackground(new java.awt.Color(26, 23, 32));
        fullScreen.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        fullScreen.setForeground(new java.awt.Color(184, 184, 184));
        fullScreen.setText("Full Screen");
        fullScreen.setBorder(null);
        fullScreen.setBorderPainted(false);
        fullScreen.setContentAreaFilled(false);
        fullScreen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fullScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fullScreenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fullScreenMouseExited(evt);
            }
        });
        jPanel4.add(fullScreen);
        fullScreen.setBounds(905, 15, 90, 20);

        block4.add(jPanel4);
        jPanel4.setBounds(20, 0, 1060, 40);

        jScrollPane1.setBackground(java.awt.Color.gray);
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        songsContainer.setBackground(new java.awt.Color(39, 34, 47));
        songsContainer.setAlignmentX(0.0F);
        songsContainer.setAlignmentY(0.0F);
        songsContainer.setLayout(new javax.swing.BoxLayout(songsContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(songsContainer);

        block4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 1080, 110);

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
        jLabel2.setText("Date Added");
        Header.add(jLabel2);
        jLabel2.setBounds(860, 12, 90, 19);

        block4.add(Header);
        Header.setBounds(40, 40, 1000, 40);

        SubPanel2.add(block4);
        block4.setBounds(10, 310, 1080, 190);

        jPanel1.setBackground(new java.awt.Color(26, 23, 32));
        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logo here");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 100, 16);

        songPlay.setBackground(new java.awt.Color(26, 23, 32));
        songPlay.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(26, 23, 32));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(240, 240, 240));
        jTextField1.setText("jTextField1");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jTextField1.setCaretColor(new java.awt.Color(240, 240, 240));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        songPlay.add(jTextField1);
        jTextField1.setBounds(140, 8, 330, 40);

        javax.swing.GroupLayout SubPanel1Layout = new javax.swing.GroupLayout(SubPanel1);
        SubPanel1.setLayout(SubPanel1Layout);
        SubPanel1Layout.setHorizontalGroup(
            SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(SubPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(songPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(songPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SubPanel1Layout.setVerticalGroup(
            SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(SubPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SubPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songPlay1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MainPanel.add(SubPanel1, "card2");

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
        uploadImagebtn.setPreferredSize(new java.awt.Dimension(135, 135));

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
        uploadSong.setPreferredSize(new java.awt.Dimension(97, 35));

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

        jButton3.setBackground(new java.awt.Color(226, 115, 150));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("Save");
        jButton3.setBorder(null);

        cancel.setBackground(new java.awt.Color(26, 23, 32));
        cancel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        cancel.setForeground(new java.awt.Color(226, 115, 150));
        cancel.setText("Cancel");
        cancel.setBorder(null);
        cancel.setPreferredSize(new java.awt.Dimension(85, 35));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addSongPanelLayout = new javax.swing.GroupLayout(addSongPanel);
        addSongPanel.setLayout(addSongPanelLayout);
        addSongPanelLayout.setHorizontalGroup(
            addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addContainerGap(691, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addSongPanelLayout.setVerticalGroup(
            addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSongPanelLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        MainPanel.add(addSongPanel, "card4");

        getContentPane().add(MainPanel);
        MainPanel.setBounds(0, 0, 1100, 600);
        MainPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeMoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeMoreMouseEntered
        // underlines See More when hovered
        seeMore.setText("<html><u>See More</u></html>");
    }//GEN-LAST:event_seeMoreMouseEntered

    private void seeMoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeMoreMouseExited
        // removes underline of See More when not hovered
        seeMore.setText("See More");
    }//GEN-LAST:event_seeMoreMouseExited

    private void addPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaylistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPlaylistActionPerformed

    private void addSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongsActionPerformed
        // changing from main view to add song card panel
        MainPanel.removeAll();
        MainPanel.add(addSongPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_addSongsActionPerformed

    private void fullScreenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullScreenMouseEntered
        // underlines Full Screen when hovered
        fullScreen.setText("<html><u>Full Screen</u></html>");
    }//GEN-LAST:event_fullScreenMouseEntered

    private void fullScreenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullScreenMouseExited
        // removes underline of Full screen when not hovered
        fullScreen.setText("Full Screen");
    }//GEN-LAST:event_fullScreenMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // changing from add song to main view card panel (di ko lam bat ang layu nila sa isat isa ditu)
        MainPanel.removeAll();
        MainPanel.add(SubPanel1);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_cancelActionPerformed

    private void inputTitleSongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTitleSongFocusGained
        // when user clicks on jtextfield to input song title, mawawala ung placeholder
        if (inputTitleSong.getText().equals("E.g. Raining in Manila")) {
                    inputTitleSong.setText("");
                    inputTitleSong.setForeground(Color.decode("#f0f0f0"));
        }
    }//GEN-LAST:event_inputTitleSongFocusGained

    private void inputTitleSongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTitleSongFocusLost
        // placeholder for song title comes back if empty ung textfield
        if (inputTitleSong.getText().isEmpty()) {
                    inputTitleSong.setText("E.g. Raining in Manila");
                    inputTitleSong.setForeground(Color.decode("#7A7A7A"));
        }
    }//GEN-LAST:event_inputTitleSongFocusLost

    private void inputArtistFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputArtistFocusGained
        // when user clicks on jtextfield to input artist name, mawawala ung placeholder
        if (inputArtist.getText().equals("E.g. Lola Amour")) {
            inputArtist.setText("");
            inputArtist.setForeground(Color.decode("#f0f0f0"));
        }
    }//GEN-LAST:event_inputArtistFocusGained

    private void inputArtistFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputArtistFocusLost
        // placeholder for artist comes back if empty ung textfield
        if (inputArtist.getText().isEmpty()) {
            inputArtist.setText("E.g. Lola Amour");
            inputArtist.setForeground(Color.decode("#7A7A7A"));
        }
    }//GEN-LAST:event_inputArtistFocusLost

    public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (UnsupportedLookAndFeelException ex) {
        ex.printStackTrace();
    }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainView().setVisible(true);
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
    private javax.swing.JButton addPlaylist;
    private javax.swing.JPanel addSongPanel;
    private javax.swing.JButton addSongs;
    private javax.swing.JLabel artist;
    private javax.swing.JPanel block3;
    private javax.swing.JPanel block4;
    private javax.swing.JButton cancel;
    private javax.swing.JButton fullScreen;
    private javax.swing.JTextField inputArtist;
    private javax.swing.JTextField inputTitleSong;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel playlistContainer;
    private javax.swing.JButton seeMore;
    private javax.swing.JLabel song;
    private javax.swing.JLabel song1;
    private javax.swing.JPanel songPlay;
    private javax.swing.JPanel songPlay1;
    private javax.swing.JPanel songsContainer;
    private javax.swing.JLabel titleSong;
    private javax.swing.JLabel titleSong1;
    private javax.swing.JButton uploadImagebtn;
    private javax.swing.JButton uploadSong;
    // End of variables declaration//GEN-END:variables
}
