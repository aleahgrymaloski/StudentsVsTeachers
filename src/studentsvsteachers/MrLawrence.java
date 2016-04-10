/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.Direction;
import images.ImageManager;
import images.ResourceTools;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class MrLawrence {

    private int x;
    private int y;
    private CellDataProviderIntf cellData;
    private MoveValidatorIntf moveValidator;
    private Direction direction;

    public void move() {

    }

    public MrLawrence(int x, int y, Direction direction, CellDataProviderIntf cellData, MoveValidatorIntf moveValidator) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cellData = cellData;
        this.moveValidator = moveValidator;
    }

    private ImageManager im = new ImageManager();


    /**
     * @return the x
     */
       
    private int x;
    private int y;
    private Image image;
    private Image lawrence_1, lawrence_2, lawrence_3, lawrence_4;

    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the cellData
     */
    public CellDataProviderIntf getCellData() {
        return cellData;
    }

    /**
     * @param cellData the cellData to set
     */
    public void setCellData(CellDataProviderIntf cellData) {
        this.cellData = cellData;
    }

    /**
     * @return the moveValidator
     */
    public MoveValidatorIntf getMoveValidator() {
        return moveValidator;
    }

    /**
     * @param moveValidator the moveValidator to set
     */
    public void setMoveValidator(MoveValidatorIntf moveValidator) {
        this.moveValidator = moveValidator;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the im
     */
    public ImageManager getIm() {
        return im;
    }

    /**
     * @param im the im to set
     */
    public void setIm(ImageManager im) {
        this.im = im;
    }
}
