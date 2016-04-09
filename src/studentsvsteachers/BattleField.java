/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import audio.Playlist;
import audio.Source;
import audio.Track;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Aleah
 */
class BattleField extends Environment {

    private Grid grid;
    private String trackNameGameTimer;
    private int score;

    audio.SoundManager soundManager;
    public static final String ZOMBIES_SONG = "zombie";

    public BattleField() {

        grid = new Grid(17, 17, 52, 36, new Point(10, 10), new Color(254, 8, 8));

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");
        this.setBackground(temp.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));

        grid = new Grid(25, 15, 40, 40, new Point(10, 50), Color.MAGENTA);

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

        setUpSound();
        soundManager.play(ZOMBIES_SONG, -1);
    }

    private void setUpSound() {
        // set up a list of tracks in a playlist
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track(ZOMBIES_SONG, Source.RESOURCE, "/items/theme_songg.wav"));
        Playlist playlist = new Playlist(tracks);
        // pass the playlist to a sound manager
        soundManager = new audio.SoundManager(playlist);
    }

    public void setScore(int score) {
        this.score = score;

    }

    public void addScore(int score) {
        setScore(this.score + score);
        if (score >= 0);

    }

    @Override
    public void initializeEnvironment() {

    }

    @Override
    public void timerTaskHandler() {
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Typewriter", Font.BOLD, 35));
        graphics.drawString("Score: " + score, 10, 30);

        if (score < 0) {
            graphics.drawString("Game Over", 300, 300);
        }
    }

}
