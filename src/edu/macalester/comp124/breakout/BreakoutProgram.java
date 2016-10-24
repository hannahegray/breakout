package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.*;

/**
 * Main program for the breakout game .
 *
 */
public class BreakoutProgram extends CanvasWindow {
    private Ball ball1;
    private double xpos = 400, ypos = 500; //calculate based off of canvas width and height
    private BrickWall wall;
    private Paddle pad;
    private double dx = -10, dy = -10;

    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 600;

    public BreakoutProgram() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        ball1 = new Ball(xpos, ypos);
        wall = new BrickWall(0, 100);
        wall.drawWall();
        pad = new Paddle(355, 515); //centered on the ball
        //addMouseListener(new paddleListener());


        add(wall);
        add(ball1);
        add(pad);

    }


//    private class paddleListener implements MouseListener{
//        public void mouseClicked(MouseEvent e){
//            double newX = e.getX();
//            newX = pad.getX() +newX;
//            pad.move(newX, 0);
//        }
//        public void mousePressed(MouseEvent e){}
//        public void mouseEntered(MouseEvent e){}
//        public void mouseExited(MouseEvent e){}
//        public void mouseReleased(MouseEvent e){}
//    }

    public void run(){
        while(true){
            double x = changeXDirection(ball1.getX());
            double y = changeYDirection(ball1.getY());
            ballMove(x,y);
        }
    }



    private void ballMove(double dx, double dy){
        ball1.move(dx, dy);
        pause(100);

    }

    private double changeXDirection(double x){
        if ( x <= 0.0 || x >= CANVAS_WIDTH){
            dx = -dx;
        }
        return dx;
    }

    private double changeYDirection(double y){
        if (y <= 0.0 || y>=CANVAS_HEIGHT) {
            dy = -dy;
        }
        return dy;
    }

    private boolean checkChangeDirection(double x, double y){
        if (0< x && x < CANVAS_WIDTH && 0 < y && y < CANVAS_HEIGHT){
            return false;
        }
        return true;
    }


    public static void main(String[] args){
        BreakoutProgram prog = new BreakoutProgram();
        prog.run();
    }
}
