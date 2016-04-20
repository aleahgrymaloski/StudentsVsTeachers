/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import audio.SoundManager;
import audio.Playlist;
import audio.Source;
import audio.Track;
import environment.Direction;
import environment.Environment;
import grid.Grid;
import images.Animator;
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
import map.Item;

/**
 *
 * @author Aleah
 */
class BattleField extends Environment implements CellDataProviderIntf {

    private Grid grid;
    private String trackNameGameTimer;
    private int score;

    private audio.SoundManager soundManager;
    public static final String ZOMBIES_SONG = "zombie";

    private GridCharacter sofMonster;
    private GridCharacter aleahMonster;
    private GridCharacter cafLady;
    private GridCharacter lawrenceZombie;

    private ZombieImageManager zim;

    public BattleField() {

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");
        this.setBackground(temp.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));

        grid = new Grid(9, 4, 100, 160, new Point(10, 100), new Color(2, 20, 30, 1));

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

        setUpSound();
        soundManager.play(ZOMBIES_SONG, -1);

        zim = new ZombieImageManager();

        sofMonster = new GridCharacter(1, 1, this, new Animator(zim, ZombieImageManager.SOF_PLANT, 200));
        aleahMonster = new GridCharacter(1, 2, this, new Animator(zim, ZombieImageManager.ALEAH_PLANT, 200));
        cafLady = new GridCharacter(0, 0, this, new Animator(zim, ZombieImageManager.CAFF_LADY, 200));

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
    
    private int counter;
    private int limit = 2;

    @Override
    public void timerTaskHandler() {
      
        }

    
    private void checkIntersections(){ 
        
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
        if (grid != null) {
            grid.paintComponent(graphics);
        }

        graphics.setColor(Color.white);
        graphics.setFont(new Font("Typewriter", Font.BOLD, 35));
        graphics.drawString("Score: " + score, 10, 30);

        if (score < 0) {
            graphics.drawString("Game Over", 300, 300);
        }

        if (sofMonster != null) {
            sofMonster.draw(graphics);
        }
        if (aleahMonster != null) {
            aleahMonster.draw(graphics);
        }

        if (cafLady != null) {
            cafLady.draw(graphics);
        }
     
    }

//<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf ">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();

    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();

    }

    @Override
    public int getSystemCoordX(int column, int row) {
        return grid.getCellSystemCoordinate(column, row).x;

    }

    @Override
    public int getSystemCoordY(int column, int row) {
        return grid.getCellSystemCoordinate(column, row).y;

    }
//</editor-fold>

}
