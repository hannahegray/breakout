package edu.macalester.comp124.breakout;


import comp124graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main program for the breakout game .
 *
 */
public class BreakoutProgram extends CanvasWindow {
    private Ball ball1;
    private double xpos = 200, ypos = 400; //calculate based off of canvas width and height
    private BrickWall wall;
    private Paddle pad;
    private double padx =155, pady = 550;
    private double dx = 1, dy = 1;
    private JLabel lives, end;

    private int lifeCount = 3, brickCount;


    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 600;

    public BreakoutProgram() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        BorderLayout border = new BorderLayout();
        setLayout(border);

        setBackground(Color.black);


        lives = new JLabel("Lives Left: " +lifeCount);
        lives.setHorizontalAlignment(JLabel.CENTER);
        lives.setForeground(Color.lightGray);



        end = new JLabel("YOU WON!");
        end.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 72));
        end.setForeground(Color.white);
        end.setHorizontalAlignment(JLabel.CENTER);
        end.setVisible(false);



        ball1 = new Ball(xpos, ypos);
        wall = new BrickWall(0, 100);
        wall.drawWall();
        brickCount = wall.getNumOfBricks(); //sets the bricks to number of bricks

        pad = new Paddle(padx, pady); //centered on the ball
        addMouseMotionListener(new PaddleListener());


        add(lives, border.NORTH);
        add(wall);
        add(ball1);
        add(pad);
        add(end);


        revalidate();
    }


    private class PaddleListener implements MouseMotionListener{
        public void mouseDragged(MouseEvent e) {}

        public void mouseMoved(MouseEvent e) {
            double newX = e.getX();
            pad.setPosition(newX, pad.getY());
        }
    }


    /**
     * the run method for the program, lets the ball bounce while the player still has lives left,
     * and breaks if they have no more bricks to clear. Shows a message on the canvas at the end.
     */
    public void run(){
        pause(2000);
        while(lifeCount > 0){ //while player has 1 or more lives
            checkCanvasX(ball1.getX());
            checkCanvasY(ball1.getY());
            checkForObject();
            ballMove(dx, dy);
            if (checkTurnEnd()){
                ballReset();
                lifeCount--;
                lives.setText("Lives Left: " + lifeCount);
            }
            if (brickCount == 0){ // here are no more bricks left to clear, the player must have won
                break;
            }
        }
        if (lifeCount == 0){
            end.setText("YOU LOSE!");
        }
        end.setVisible(true);

    }

    /**
     * checks if the ball has touched the bottom of the canvas and returns true if that is the case
     * @return
     */
    private boolean checkTurnEnd(){
        if (ball1.getY() >= CANVAS_HEIGHT){
            return true;
        }
        return false;
    }

    /**
     * resets the ball to the original location on the canvas and pauses for 500 milliseconds
     * to allow the user to reset the paddle before it continues bouncing.
     */
    private void ballReset(){
        ball1.setPosition(xpos, ypos);
        pause(500);
    }



    /**
     * moves the ball object forward by the amount dx and dy each time. Pauses so that the change is visible
     * @param dx the change between the ball's original x position and its new one
     * @param dy the change in y position
     */
    private void ballMove(double dx, double dy){
        ball1.move(dx, dy);
        pause(1);
    }

    /**
     * checks that the ball is within the horizontal bounds of the canvas
     * @param x
     */
    private void checkCanvasX(double x){
        if ( x <= 0.0 || x >= CANVAS_WIDTH){
            dx = -dx;
        }
    }

    /**
     * checks that the ball is within the vertical bounds of the canvas
     * @param y
     */
    private void  checkCanvasY(double y){
        if (y <= 0.0 || y>=CANVAS_HEIGHT) {
            dy = -dy;
        }
    }

    /**
     * checks whether or not the ball is touching another object on the canvas.
     * If so, changes the x or y coordinate to it's negative.
     *
     */
    private void checkForObject() {
        double x = ball1.getX();
        double y = ball1.getY();
        double d = ball1.getWidth();
        double x2 = x + d;
        double y2 = y + d;

        if (checkTopLeft(x, y) && checkTopRight(x2, y)){ //checks top side of ball object
            dy = -dy;
            checkBrickWall(x, y);
            checkBrickWall(x2, y);
        }

        else if (checkTopRight(x2, y) && checkBottomRight(x2, y2)) { //checks right side
            dy = -dy;
            checkBrickWall(x2, y);
            checkBrickWall(x2, y2);
        }

        else if (checkBottomLeft(x, y2 ) && checkBottomRight(x2, y2)) { //checks bottom side
            dy = -dy;
            checkBrickWall(x, y2);
            checkBrickWall(x2, y2);
        }

        else if (checkBottomLeft(x, y2) && checkTopLeft(x, y)) { //checks left side
            dx = -dx;
            checkBrickWall(x, y2);
            checkBrickWall(x, y);
        }

        else if (checkTopLeft(x, y)){   //checks top left corner only
            dx = -dx;
            dy = -dy;
            checkBrickWall(x, y);
        }

        else if (checkTopRight(x2, y)){    //checks top right corner only
            dx = -dx;
            dy = -dy;
            checkBrickWall(x2, y);
        }

        else if (checkBottomLeft(x, y2)){    //checks bottom left corner only
            dx = -dx;
            dy = -dy;
            checkBrickWall(x, y2);
        }

        else if (checkBottomRight(x2, y2)){      //checks bottom right corner only
            dx = -dx;
            dy = -dy;
            checkBrickWall(x2, y2);
        }

    }

    /**
     * checks the top right corner of the ball element, and returns true if there is an
     * GraphicsObject element there at those coordinates
     * @param x
     * @param y
     * @return true if thee is an element, false otherwise
     */
    private boolean checkTopRight(double x, double y){
        if (getElementAt(x, y) != null){
            return true;
        }
        return false;
    }

    /**
     * checks the top left corner of the ball element
     * @param x
     * @param y
     * @return true if there is an element
     */
    private boolean checkTopLeft (double x, double y){
        if (getElementAt(x,y) != null){
            return true;
        }
        return false;
    }

    /**
     * checks the bottom left corner of the ball elemnet
     * @param x
     * @param y
     * @return true if there is an object there
     */
    private boolean checkBottomLeft (double x, double y){
        if (getElementAt(x, y) != null){
            return true;
        }
        return false;
    }

    /**
     * checks the bottom right corner of the ball element
     * @param x
     * @param y
     * @return true if there is an object there
     */
    private boolean checkBottomRight(double x, double y){
        if (getElementAt(x, y) != null){
            return true;
        }
        return false;
    }

    /**
     * checks if the object that was found is a part of the brick wall (and not the paddle).
     * If so, deletes the brick at those coordinates from the wall
     * @param x
     * @param y
     */
    private void checkBrickWall(double x, double y){
        GraphicsObject element = getElementAt(x, y);
        if (element == wall){
            GraphicsObject brick = wall.getElementAt(x, y);
            wall.remove(brick);
            brickCount--;
        }
    }

    public static void main(String[] args){
        BreakoutProgram prog = new BreakoutProgram();
        prog.run();
    }
}
