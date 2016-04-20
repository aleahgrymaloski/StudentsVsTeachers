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
import environment.Environment;
import grid.Grid;
import images.Animator;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
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

//    private GridCharacter sofMonster;
//    private GridCharacter aleahMonster;
//    private GridCharacter cafLady;

    private Image newPlantButton;
    private Point newPlantPosition;
    
    private ArrayList<GridCharacter> plants;
    private GridCharacter lawrenceZombie;

    private ZombieImageManager zim;

    public BattleField() {
        newPlantButton = ResourceTools.loadImageFromResource("items/sof_1.png");
        newPlantPosition = new Point(200, 10);
        
        plants = new ArrayList<>();

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");
        this.setBackground(temp.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));

        grid = new Grid(9, 4, 100, 160, new Point(10, 100), new Color(2, 20, 30, 1));

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

        setUpSound();
        soundManager.play(ZOMBIES_SONG, -1);

        zim = new ZombieImageManager();

//        sofMonster = new GridCharacter(1, 1, this, new Animator(zim, ZombieImageManager.SOF_PLANT, 200));
//        aleahMonster = new GridCharacter(1, 2, this, new Animator(zim, ZombieImageManager.ALEAH_PLANT, 200));
//        cafLady = new GridCharacter(0, 0, this, new Animator(zim, ZombieImageManager.CAFF_LADY, 200));

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
//        if (lawrenceZombie != null) {
//            if (counter < limit) {
//                counter++;
//            }else { 
//                counter = 0;
//                lawrenceZombie.move(); 
//                
//            }
//        }

    }
    
    private void movelawrenceZombie(){ 
        
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
//        System.out.println("mouse click - screen " + e.getPoint());
//        System.out.println("mouse click - grid   " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));

        //check if I hit the new Plant button..
        if ( (new Rectangle(newPlantPosition.x, newPlantPosition.y, newPlantButton.getWidth(null), newPlantButton.getHeight(null))).contains(e.getPoint())) {
            System.out.println("NEW PLANT TO BE CREATED");
        }
        
        
        
//        double randPlant = Math.random();
//        if (randPlant < .33) {
//            plants.add(new GridCharacter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.CAFF_LADY, 200)));
//        } else if (randPlant < .66){
//            plants.add(new GridCharacter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.ALEAH_PLANT, 200)));
//        } else {
//            plants.add(new GridCharacter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.SOF_PLANT, 200)));
//        }
        

    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }

        graphics.setColor(Color.white);
        graphics.setFont(new Font("Typewriter", Font.BOLD, 35));
        graphics.drawString("Score: " + score, 10, 30);

        graphics.drawImage(newPlantButton, newPlantPosition.x, newPlantPosition.y, 25, 25, this);
        if (score < 0) {
            graphics.drawString("Game Over", 300, 300);
        }

        if (plants != null) {
            for(GridCharacter plant: plants){
                plant.draw(graphics);
            }
            
        }
//        if (sofMonster != null) {
//            sofMonster.draw(graphics);
//        }
//        if (aleahMonster != null) {
//            aleahMonster.draw(graphics);
//        }
//
//        if (cafLady != null) {
//            cafLady.draw(graphics);
//        }
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
