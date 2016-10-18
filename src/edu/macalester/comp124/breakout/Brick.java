package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class Brick extends Rectangle {

    public Brick(double xpos, double ypos, double bHeight, double bWidth, Color col){
        super(xpos, ypos, bWidth, bHeight);
        setFilled(true);
        setFillColor(col);
        setStrokeColor(Color.white);
    }
}
