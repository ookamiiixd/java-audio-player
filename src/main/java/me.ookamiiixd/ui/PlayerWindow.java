package me.ookamiiixd.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;
import me.ookamiiixd.main.Utils;
import me.ookamiiixd.player.AudioPlayer;
import me.ookamiiixd.player.BasePlayer;

public class PlayerWindow extends javax.swing.JFrame {

    private File file;
    private AudioPlayer player;
    private Timer timer;

    /**
     * Creates new form Main
     */
    public PlayerWindow() {
        initComponents();
    }

    public void play(File file, long position) {
        try {
            if (player != null && player.getStatus() == BasePlayer.STATUS.PLAY) {
                player.stop();
            }
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }

            this.file = file;
            player = new AudioPlayer(file);
            var totalLength = player.getLength();
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (player.isFinished()) {
                        timer.stop();
                        progressBar.setValue(10000);
                        lengthElapsed.setText(Utils.formatMs(totalLength));
                        playBtn.setEnabled(true);
                        pauseBtn.setEnabled(false);
                        stopBtn.setEnabled(false);
                        return;
                    }

                    var currentPosition = player.getPosition();
                    lengthElapsed.setText(Utils.formatMs(currentPosition));
                    var currentPercentage = (double) currentPosition / totalLength * 10000.d;
                    progressBar.setValue((int) currentPercentage);
                }
            });

            filename.setText(file.getName());
            lengthTotal.setText(Utils.formatMs(totalLength));
            player.play(position);
            timer.start();
            progressBar.setEnabled(true);
            playBtn.setEnabled(false);
            pauseBtn.setEnabled(true);
            stopBtn.setEnabled(true);
        } catch (Exception e) {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        filename = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        bgContainer = new javax.swing.JPanel();
        progressBar = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        lengthElapsed = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lengthTotal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        playBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        chooseBtn = new javax.swing.JMenu();
        aboutBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Audio Player");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        filename.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        filename.setForeground(new java.awt.Color(153, 153, 153));
        filename.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filename.setText(" ");
        filename.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(filename);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        bgContainer.setBackground(new java.awt.Color(102, 102, 102));
        bgContainer.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel6.add(bgContainer, gridBagConstraints);

        progressBar.setMaximum(10000);
        progressBar.setValue(0);
        progressBar.setEnabled(false);
        progressBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                progressBarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                progressBarMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(progressBar, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lengthElapsed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lengthElapsed.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(lengthElapsed, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("/");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(jLabel3, gridBagConstraints);

        lengthTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lengthTotal.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel2.add(lengthTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        playBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playBtn.setEnabled(false);
        playBtn.setFocusPainted(false);
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel7.add(playBtn, gridBagConstraints);

        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        pauseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pauseBtn.setEnabled(false);
        pauseBtn.setFocusPainted(false);
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel7.add(pauseBtn, gridBagConstraints);

        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stop.png"))); // NOI18N
        stopBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopBtn.setEnabled(false);
        stopBtn.setFocusPainted(false);
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel7.add(stopBtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel1.add(jPanel7, gridBagConstraints);

        getContentPane().add(jPanel1);

        chooseBtn.setText("Play");
        chooseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseBtn.setFocusable(false);
        chooseBtn.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                chooseBtnMenuSelected(evt);
            }
        });
        menuBar.add(chooseBtn);

        aboutBtn.setText("About");
        aboutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutBtn.setFocusable(false);
        aboutBtn.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                aboutBtnMenuSelected(evt);
            }
        });
        menuBar.add(aboutBtn);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        player.pause();
        timer.stop();
        playBtn.setEnabled(true);
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(true);
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        player.stop();
        timer.stop();
        lengthElapsed.setText("00:00");
        progressBar.setValue(0);
        playBtn.setEnabled(true);
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(false);
    }//GEN-LAST:event_stopBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        playBtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        stopBtn.setEnabled(true);

        var status = player.getStatus();
        if (status == BasePlayer.STATUS.PLAY) {
            return;
        } else if (status == BasePlayer.STATUS.PAUSE) {
            player.resume();
            timer.start();
            return;
        }
        play(file, 0);
    }//GEN-LAST:event_playBtnActionPerformed

    private void chooseBtnMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_chooseBtnMenuSelected
        chooseBtn.setSelected(false);
        var fileChooserWindow = new FileChooserWindow(this, true);
        fileChooserWindow.setLocationRelativeTo(null);
        fileChooserWindow.setVisible(true);
    }//GEN-LAST:event_chooseBtnMenuSelected

    private void progressBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressBarMousePressed
        if (player.getStatus() == BasePlayer.STATUS.PLAY) {
            player.pause();
            timer.stop();
        }
        playBtn.setEnabled(false);
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(false);
    }//GEN-LAST:event_progressBarMousePressed

    private void progressBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressBarMouseReleased
        var value = progressBar.getValue();
        var position = (long) ((double) value / 10000.d * player.getLength());
        if (player.isFinished()) {
            play(file, position);
            return;
        }

        player.play(position);
        timer.start();
        playBtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        stopBtn.setEnabled(true);
    }//GEN-LAST:event_progressBarMouseReleased

    private void aboutBtnMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_aboutBtnMenuSelected
        aboutBtn.setSelected(false);
        var aboutWindow = new AboutWindow(this, true);
        aboutWindow.setLocationRelativeTo(null);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutBtnMenuSelected

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutBtn;
    private javax.swing.JPanel bgContainer;
    private javax.swing.JMenu chooseBtn;
    private javax.swing.JLabel filename;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lengthElapsed;
    private javax.swing.JLabel lengthTotal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton playBtn;
    private javax.swing.JSlider progressBar;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
}