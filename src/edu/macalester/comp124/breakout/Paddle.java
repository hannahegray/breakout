package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class Paddle extends Rectangle {
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 10;

    public Paddle(double xpos, double ypos){
        super(xpos, ypos, PADDLE_WIDTH, PADDLE_HEIGHT);
        setFilled(true);
        setFillColor(Color.lightGray);
    }

}
