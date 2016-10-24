package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class Ball extends Ellipse {
    private static final double BALL_WIDTH = 15;


    public Ball(double xpos, double ypos){
        super(xpos, ypos, BALL_WIDTH, BALL_WIDTH);
        setFilled(true);
        setFillColor(Color.red);
        setStroked(false);
    }

    //need a method to get ball to move and go

    private void ballMove(double dx, double dy){
        while(true){
            move(dx,dy);
            //pause(100);
        }
    }



//
//    public double getDx(){
//        dx = Ball.getX();
//
//    }
//
//    public double getDy(){
//        dy = Ball.getY();
//    }
//
}


