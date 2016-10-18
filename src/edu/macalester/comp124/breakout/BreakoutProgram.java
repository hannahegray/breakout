package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;

import java.awt.*;

/**
 * Main program for the breakout game .
 *
 */
public class BreakoutProgram extends CanvasWindow {
    private Ball ball1;
    private double origx = 400, origy = 900;
    private BrickWall wall;

    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 1000;

    public BreakoutProgram() {
        super("Breakout!", 800, 1000);
        ball1 = new Ball(origx, origy);
        wall = new BrickWall(0,100);
        wall.drawWall();

        add(wall);
        add(ball1);



    }


    public static void main(String[] args){
        BreakoutProgram prog = new BreakoutProgram();
    }

}
