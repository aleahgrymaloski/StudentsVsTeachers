/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.Velocity;
import images.Animator;

/**
 *
 * @author Aleah
 */
public class CafLady extends GridCharacter {

    public CafLady(int column, int row, CellDataProviderIntf cellData, Animator animator) {
        super(column, row, cellData, animator);
    }
    
    
        /**
     *
     * @return
     */
    public Cookie shootCookie(){ 
        return new Cookie(getProductionPosition(), new Velocity(0,0)); 
    } 

}
