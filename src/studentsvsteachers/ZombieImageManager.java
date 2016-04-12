/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;


import images.ImageManager;  
import images.ResourceTools;
import java.awt.Image;
import java.util.ArrayList;


/**
 *
 * @author Aleah
 */
public class ZombieImageManager  extends ImageManager {
    
    public static final String MACINNIS_ZOMBIE_01 = "MACINNIS_ZOMBIE_01";
    public static final String MACINNIS_ZOMBIE_02 = "MACINNIS_ZOMBIE_02";
    public static final String MACINNIS_ZOMBIE_03 = "MACINNIS_ZOMBIE_03";
    public static final String MACINNIS_ZOMBIE_04 = "MACINNIS_ZOMBIE_04";
    //carry on!!!!

    public static ArrayList<String> MACINNIS_ZOMBIE_WALK;

    
    public static final String LAWRENCE_ZOMBIE_01 = "LAWRENCE_ZOMBIE_01";
    //carry on...
    
    public static ArrayList<String> LAWRENCE_ZOMBIE_WALK;
    
    
    
    {
        addImage(MACINNIS_ZOMBIE_01, ResourceTools.loadImageFromResource("items/macinnis_1.png"));
        //carry on!!!!

        MACINNIS_ZOMBIE_WALK = new ArrayList<>();
        MACINNIS_ZOMBIE_WALK.add(MACINNIS_ZOMBIE_01);
        MACINNIS_ZOMBIE_WALK.add(MACINNIS_ZOMBIE_02);
        //carry on!!!!

        LAWRENCE_ZOMBIE_WALK = new ArrayList<>();
        LAWRENCE_ZOMBIE_WALK.add(LAWRENCE_ZOMBIE_01);
        //carry on!!!!
    }

    
}
