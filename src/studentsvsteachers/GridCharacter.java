/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.Velocity;
import images.Animator;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class GridCharacter {
    
    public void draw (Graphics graphics){
        graphics.drawImage(getImage(), cellData.getSystemCoordX(column, row), cellData.getSystemCoordY(column, row), cellData.getCellWidth(), cellData.getCellHeight(), null);
    }
    
    public Image getImage(){
        return animator.getCurrentImage();
    }
    
    public GridCharacter(int column, int row, CellDataProviderIntf cellData, Animator animator){
        this.cellData = cellData;
        this.animator = animator; 
        this.column = column; 
        this.row = row; 
    }
    
    public Pea shoot(){
        //make a new Pea:
        //  - position = right hand side, 1/4 from top
        return new Pea(getPeaPosition(), new Velocity(2, 0));
    }
    
    private Point getPeaPosition(){;
        return new Point(cellData.getSystemCoordX(column, row) + getImage().getWidth(null), cellData.getSystemCoordY(column, row) + (getImage().getHeight( null) / 4));
    }
    
    private int column, row; 
    private CellDataProviderIntf cellData;
    private Animator animator;
    
}
