package Views;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PlayView extends javax.swing.JFrame {
    public PlayView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progressSlider = new javax.swing.JSlider();
        ppButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        forwardButton = new javax.swing.JLabel();
        volumeSlider = new javax.swing.JSlider();
        titleLabel = new javax.swing.JLabel();
        coverPanel = new javax.swing.JPanel();
        plusLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lyricsPanel = new javax.swing.JPanel();
        lyricsLabel = new javax.swing.JLabel();
        lyricsScroll = new javax.swing.JScrollPane();
        lyricsArea = new javax.swing.JTextArea();
        lyricsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symph [Playing]");
        setBackground(new java.awt.Color(26, 23, 32));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(26, 23, 32));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));

        progressSlider.setBackground(new java.awt.Color(40, 40, 57));
        progressSlider.setForeground(new java.awt.Color(226, 115, 150));

        ppButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        ppButton.setForeground(new java.awt.Color(240, 240, 240));
        ppButton.setText("Play/Pause");

        backButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(240, 240, 240));
        backButton.setText("Back");

        forwardButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        forwardButton.setForeground(new java.awt.Color(240, 240, 240));
        forwardButton.setText("Forward");

        volumeSlider.setBackground(new java.awt.Color(40, 40, 57));
        volumeSlider.setForeground(new java.awt.Color(226, 115, 150));

        titleLabel.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(240, 240, 240));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Song Title");

        javax.swing.GroupLayout coverPanelLayout = new javax.swing.GroupLayout(coverPanel);
        coverPanel.setLayout(coverPanelLayout);
        coverPanelLayout.setHorizontalGroup(
            coverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        coverPanelLayout.setVerticalGroup(
            coverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        plusLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        plusLabel.setForeground(new java.awt.Color(240, 240, 240));
        plusLabel.setText("+");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("hart");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Song Artist");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ppButton)
                        .addGap(18, 18, 18)
                        .addComponent(forwardButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(plusLabel)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(progressSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(coverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(coverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plusLabel)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(progressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ppButton)
                    .addComponent(backButton)
                    .addComponent(forwardButton))
                .addGap(29, 29, 29)
                .addComponent(volumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jLabel2.getAccessibleContext().setAccessibleName("artistLabel");

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
        lyricsArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Aliquet porttitor lacus luctus accumsan tortor posuere ac. Libero nunc consequat interdum varius sit amet mattis vulputate enim. A lacus vestibulum sed arcu non odio euismod. Faucibus scelerisque eleifend donec pretium. Mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus. Integer vitae justo eget magna fermentum iaculis. Morbi enim nunc faucibus a pellentesque sit amet porttitor eget. Lobortis elementum nibh tellus molestie nunc non blandit massa. Integer quis auctor elit sed vulputate mi. Nunc sed augue lacus viverra vitae. Dui faucibus in ornare quam viverra orci sagittis. Nec ullamcorper sit amet risus nullam eget felis eget nunc. Fringilla ut morbi tincidunt augue interdum velit euismod in pellentesque.  Pharetra pharetra massa massa ultricies. Auctor eu augue ut lectus arcu. In hac habitasse platea dictumst vestibulum rhoncus est. Et leo duis ut diam quam. In egestas erat imperdiet sed. Est ultricies integer quis auctor elit sed vulputate. Mattis pellentesque id nibh tortor id. Fringilla ut morbi tincidunt augue interdum velit euismod in. Bibendum ut tristique et egestas quis ipsum suspendisse ultrices. Consectetur lorem donec massa sapien faucibus et. Velit dignissim sodales ut eu. Nisl nunc mi ipsum faucibus vitae. Arcu odio ut sem nulla pharetra diam.  Nibh mauris cursus mattis molestie. Nulla facilisi nullam vehicula ipsum a arcu. Pellentesque nec nam aliquam sem. Magna fringilla urna porttitor rhoncus dolor purus non. Erat imperdiet sed euismod nisi porta. Lectus arcu bibendum at varius. Accumsan in nisl nisi scelerisque eu ultrices vitae auctor eu. Felis bibendum ut tristique et egestas. Risus quis varius quam quisque id. Venenatis tellus in metus vulputate eu. Tempus iaculis urna id volutpat lacus laoreet non curabitur. Placerat orci nulla pellentesque dignissim. Massa massa ultricies mi quis hendrerit dolor magna eget. Risus viverra adipiscing at in tellus integer feugiat scelerisque varius. Velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus. Vel elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi. Iaculis nunc sed augue lacus viverra vitae. Porta non pulvinar neque laoreet suspendisse interdum consectetur.  Elit scelerisque mauris pellentesque pulvinar pellentesque habitant. Sed turpis tincidunt id aliquet risus feugiat in ante. Odio pellentesque diam volutpat commodo sed egestas. Egestas erat imperdiet sed euismod nisi porta lorem mollis. Venenatis urna cursus eget nunc scelerisque. Pulvinar pellentesque habitant morbi tristique senectus et netus et malesuada. Euismod nisi porta lorem mollis. A condimentum vitae sapien pellentesque habitant morbi tristique senectus. Felis bibendum ut tristique et egestas quis. Volutpat ac tincidunt vitae semper quis. Augue interdum velit euismod in pellentesque massa placerat. Etiam erat velit scelerisque in dictum non consectetur a erat. Eu facilisis sed odio morbi quis commodo odio aenean sed. Sodales neque sodales ut etiam sit amet nisl purus. Mattis rhoncus urna neque viverra justo nec. Odio morbi quis commodo odio aenean sed. Malesuada fames ac turpis egestas integer eget aliquet. Massa sed elementum tempus egestas sed sed risus. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac.  A scelerisque purus semper eget. Condimentum mattis pellentesque id nibh. Scelerisque varius morbi enim nunc faucibus a pellentesque. Et ultrices neque ornare aenean euismod elementum nisi quis. Diam sollicitudin tempor id eu nisl nunc mi. Egestas diam in arcu cursus euismod quis viverra. Dictum varius duis at consectetur lorem donec. Mus mauris vitae ultricies leo integer malesuada nunc vel. Mi sit amet mauris commodo quis imperdiet massa tincidunt nunc. Velit ut tortor pretium viverra suspendisse potenti nullam. Risus viverra adipiscing at in tellus integer feugiat scelerisque varius. Tellus at urna condimentum mattis pellentesque id nibh tortor. Adipiscing bibendum est ultricies integer quis. Ipsum consequat nisl vel pretium. Nunc faucibus a pellentesque sit amet porttitor eget. Aliquam malesuada bibendum arcu vitae elementum curabitur vitae nunc. Sit amet commodo nulla facilisi nullam vehicula ipsum. Suspendisse potenti nullam ac tortor vitae purus.");
        lyricsArea.setWrapStyleWord(true);
        lyricsArea.setAutoscrolls(false);
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
                .addContainerGap()
                .addGroup(lyricsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lyricsPanelLayout.createSequentialGroup()
                        .addComponent(lyricsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lyricsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                new PlayView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel coverPanel;
    private javax.swing.JLabel forwardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea lyricsArea;
    private javax.swing.JButton lyricsButton;
    private javax.swing.JLabel lyricsLabel;
    private javax.swing.JPanel lyricsPanel;
    private javax.swing.JScrollPane lyricsScroll;
    private javax.swing.JLabel plusLabel;
    private javax.swing.JLabel ppButton;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
