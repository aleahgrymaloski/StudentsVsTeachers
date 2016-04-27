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
public class PeaShooter extends GridCharacter {

    public PeaShooter(int column, int row, CellDataProviderIntf cellData, Animator animator) {
        super(column, row, cellData, animator);
    }
    
        public Pea shoot(){
        //make a new Pea:
        //  - position = right hand side, 1/4 from top
        return new Pea(getProductionPosition(), new Velocity(2, 0));

    }
    

    
}
