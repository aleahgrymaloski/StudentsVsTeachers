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

    private Image newPlantButton;
    private Image newCafLadyButton;

    private Point newPlantPosition;

    private ArrayList<GridCharacter> plants;
    private ArrayList<Pea> peas;
    private GridCharacter lawrenceZombie;
    private ArrayList<Cookie> cookies;
    private GridCharacter caffLady;

    private ZombieImageManager zim;

    public ArrayList<Pea> getPeasSafe() {
        ArrayList<Pea> safePeas = new ArrayList<>();
        for (Pea pea : peas) {
            safePeas.add(pea);
        }
        return safePeas;
    }

    public ArrayList<Cookie> getCookiesSafe() {
        ArrayList<Cookie> safeCookies = new ArrayList<>();
        for (Cookie cookie : cookies) {
            safeCookies.add(cookie);

        }
        return safeCookies;

    }

    public ArrayList<GridCharacter> getPlantsSafe() {
        ArrayList<GridCharacter> safePlants = new ArrayList<>();
        for (GridCharacter plant : plants) {
            safePlants.add(plant);
        }
        return safePlants;
    }

    public BattleField() {
        newPlantButton = ResourceTools.loadImageFromResource("items/sof_1.png");
        newCafLadyButton = ResourceTools.loadImageFromResource("items/caflady_1.png");

        newPlantPosition = new Point(200, 10);

        peas = new ArrayList<>();
        plants = new ArrayList<>();
        cookies = new ArrayList<>();

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");
        this.setBackground(temp.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));

        grid = new Grid(9, 4, 100, 160, new Point(10, 100), new Color(2, 20, 30, 1));

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

        setUpSound();
        soundManager.play(ZOMBIES_SONG, -1);

        zim = new ZombieImageManager();
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

        if (peas != null) {
            for (Pea pea : peas) {
                pea.move();
            }
        }

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.move();
            }
        }

        if (plants != null) {
            for (GridCharacter plant : getPlantsSafe()) {
                if ((plant instanceof PeaShooter) && (Math.random() < .01)) {
                    peas.add(((PeaShooter) plant).shoot());
                }

                if ((plant instanceof CafLady) && (Math.random() < .01)) {
                    cookies.add(((CafLady) plant).shootCookie());
                }
            }
//            if (caffLady != null) {
//                for (Cookie caffLady : getCookiesSafe()) {
//                    if (Math.random() < .01) {
//                        cookies.add(caffLady.shootCookie());
//                    }
//                }
//            }

        }

    }

    private void movelawrenceZombie() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    private SelectionState selectionState;

    @Override
    public void environmentMouseClicked(MouseEvent e) {
//        System.out.println("mouse click - screen " + e.getPoint());
//        System.out.println("mouse click - grid   " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));

        //check if I hit the new Plant button..

        if (selectionState == SelectionState.CREATE_PS) {
            double randShooter = Math.random();
            if (randShooter < .5) {
                plants.add(new PeaShooter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.ALEAH_PLANT, 200)));
            } else {
                plants.add(new PeaShooter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.SOF_PLANT, 200)));
            }
            
            selectionState = SelectionState.NORMAL;
            
        } else if (selectionState == SelectionState.CREATE_CL) {
            plants.add(new CafLady(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.CAFF_LADY, 200)));
            selectionState = SelectionState.NORMAL;
        } else {
            // select  cookies and stuff
        }

        if ((new Rectangle(newPlantPosition.x, newPlantPosition.y, newPlantButton.getWidth(null), newPlantButton.getHeight(null))).contains(e.getPoint())) {
            selectionState = SelectionState.CREATE_PS;
        } else if ((new Rectangle(newPlantPosition.x, newPlantPosition.y, newPlantButton.getWidth(null), newCafLadyButton.getHeight(null))).contains(e.getPoint())) {
            selectionState = SelectionState.CREATE_CL;
        }

//        double randPlant = Math.random();
//        if (randPlant < .66) {
//            plants.add(new CafLady(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.ALEAH_PLANT, 200)));
//        } else {
//            plants.add(new PeaShooter(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.SOF_PLANT, 200)));
//        }
//        double randCookie = Math.random();
//        if (randCookie < .33) {
//            cookies.add(new Cookie(grid.getCellLocationFromSystemCoordinate(e.getPoint()).x, grid.getCellLocationFromSystemCoordinate(e.getPoint()).y, this, new Animator(zim, ZombieImageManager.CAFF_LADY, 200)));
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
            for (GridCharacter plant : plants) {
                plant.draw(graphics);
            }
        }

        if (peas != null) {
            for (Pea pea : getPeasSafe()) {
                pea.paint(graphics);
            }
        }

        if (cookies != null) {
            for (Cookie cookie : getCookiesSafe()) {
                cookie.paint(graphics);
            }
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
