/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public interface CellDataProviderIntf {

    public int getCellWidth();
    public int getCellHeight();

    public int getSystemCoordX(int column, int row);
    public int getSystemCoordY(int column, int row);

}
