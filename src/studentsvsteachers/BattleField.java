/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import audio.SoundManager;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Aleah
 */
class BattleField extends Environment {

    private Grid grid;
    private int score;

    

    public BattleField() {

        grid = new Grid(17 , 17, 52, 36, new Point(10, 10), new Color(254, 8, 8));

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");

        grid = new Grid(25, 15, 40, 40, new Point(10, 50), Color.MAGENTA);

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

    }
    
     SoundManager soundmanager;
   
    
    
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

        if (score < 0) {
            graphics.drawString("Game Over", 300, 300);

        } 
        
       
            
        
                
    }

}
