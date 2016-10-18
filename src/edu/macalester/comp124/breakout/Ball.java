package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;

/**
 * Created by hgray on 10/18/16.
 */
public class Ball extends Ellipse {
    private static final double BALL_WIDTH = 15;
    public double dx, dy;

    public Ball(double xpos, double ypos){
        super(xpos, ypos, BALL_WIDTH, BALL_WIDTH);
        setFilled(true);
    }


    //need a method to get ball to move and go

    public void ballMove(){

    }

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


