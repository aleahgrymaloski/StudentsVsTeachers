/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsvsteachers;

import environment.Actor;
import environment.Velocity;
import images.ResourceTools;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author sofialuzgalbanpatterson
 */
public class Cookie extends Actor {

    public Cookie(Point position, Velocity velocity) {
        super(ResourceTools.loadImageFromResource("items/Cookie.png"), position, velocity);
    }
    
}
