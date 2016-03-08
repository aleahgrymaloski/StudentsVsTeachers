/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.ApplicationStarter;
import java.awt.Dimension;

/**
 *
 * @author Aleah
 */
public class StudentsVsTeachers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationStarter.run(new String [0], "Students Vs Teachers", new Dimension(1000, 800), new BattleField());
    }
    
}
