package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class Paddle extends Rectangle {


    public Paddle(){
            super(xpos, ypos, bWidth, bHeight);
            setFilled(true);
    }

    //need a method to create move, move horizontally only.
}
