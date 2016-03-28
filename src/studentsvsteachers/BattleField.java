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


public class BattleField extends Environment{
    
    private Grid grid;
    
    public BattleField(){
        
        grid = new Grid(10, 10, 52, 36, new Point(10, 10), new Color(100, 49, 178, 100));

          BufferedImage temp = (BufferedImage) ResourceTools.loadImageFromResource("items/background.png");
        this.setBackground(temp.getScaledInstance(1000, 700, Image.SCALE_SMOOTH));
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
    }
    
}
