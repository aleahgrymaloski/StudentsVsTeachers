/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.Actor;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class Pea extends Actor {

    public Pea(Point position, Velocity velocity) {
        super(ResourceTools.loadImageFromResource("items/pea.png"), position, velocity);
    }
    
}
