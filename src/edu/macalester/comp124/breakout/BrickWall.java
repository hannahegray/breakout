package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;
import java.awt.*;

/**
 * Created by hgray on 10/18/16.
 */
public class BrickWall extends GraphicsGroup{
    private double xpos;
    private double ypos;
    private double BRICK_HEIGHT = 10;
    private double BRICK_WIDTH = 100;

    private double numOfBrick = BreakoutProgram.CANVAS_WIDTH / BRICK_WIDTH;
    private int numOfRows = 10;
    private Brick brick1;

    public BrickWall(double xpos, double ypos){
        super(xpos, ypos);
        this.xpos = 0;
        this.ypos = 0;
    }

    private void drawRow(Color col) {
        for (int i = 0; i < numOfBrick; i++){
            brick1 = new Brick(xpos, ypos, BRICK_HEIGHT, BRICK_WIDTH, col);
            add(brick1);
            xpos = xpos + BRICK_WIDTH+2; //change the xpos
        }
        ypos = ypos + BRICK_HEIGHT+ 2;
        xpos = 0;
    }

    public void drawWall(){
        drawRow(Color.red);
        drawRow(Color.red);
        drawRow(Color.orange);
        drawRow(Color.orange);
        drawRow(Color.yellow);
        drawRow(Color.yellow);
        drawRow(Color.green);
        drawRow(Color.green);
        drawRow(Color.blue);
        drawRow(Color.blue);

    }
}

