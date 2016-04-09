/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

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

    Image macinnis_1;
    Image macinnis_2;
    Image macinnis_3;
    Image macinnis_4;
    Image macinnis_5;
    Image macinnis_6;
    Image macinnis_7;
    Image macinnis_8;
    Image macinnis_9;
    Image macinnis_10;
    Image macinnis_11;
    Image macinnis_12;
    Image macinnis_13;
    Image macinnis_14;

    public BattleField() {

        grid = new Grid(17 , 17, 52, 36, new Point(10, 10), new Color(254, 8, 8));

        BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");

        grid = new Grid(25, 15, 40, 40, new Point(10, 50), Color.MAGENTA);

        this.setBackground(temp.getScaledInstance(1000, 900, Image.SCALE_SMOOTH));

        macinnis_1 = ResourceTools.loadImageFromResource("StudentsVsTeachers/macinnis_1.png");
        macinnis_2 = ResourceTools.loadImageFromResource("StudentsVsTeachers/macinnis_2.png");
        macinnis_3 = ResourceTools.loadImageFromResource("StudentsVsTeachers/macinnis_3.png");
        macinnis_4 = ResourceTools.loadImageFromResource("StudentsVsTeachers/macinnis_4.png");
        macinnis_5 = ResourceTools.loadImageFromResource("StudentsVsTeachers/macinnis_5.png");
        

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

        if (score < 0) {
            graphics.drawString("Game Over", 300, 300);

        } 
        
       
            
        
                
    }

}
