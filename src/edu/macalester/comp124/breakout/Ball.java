package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class Ball extends Ellipse {
    private static final double BALL_RADIUS = 15;


    public Ball(double xpos, double ypos){
        super(xpos, ypos, BALL_RADIUS, BALL_RADIUS);
        setFilled(true);
        setFillColor(Color.red);
        setStroked(false);
    }

}


