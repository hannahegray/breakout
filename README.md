Breakout!
==========================

For this homework assignment, you will write a program to play the classic arcade game of Breakout, which
was developed in 1976 by Steve Wozniak, who would later become one of the founders 
of Apple. In Breakout, your goal is to clear a collection of bricks by hitting each of them with 
a bouncing ball.

The initial configuration of the Breakout game appears in the left image below. The colored 
rectangles in the top part of the screen are bricks, two rows each of red, orange, yellow, green, and cyan. 
The slightly larger rectangle at the bottom is the paddle. The paddle is in a fixed position in the vertical 
dimension, but moves back and forth accross the screen along with the mouse until it 
reaches the edge of its space.

![Example of breakout game](./diagram.png)

A complete Breakout game consists of three turns. On each turn, a ball is launched from the center 
of the window towards the bottom of the screen at a random angle. That ball bounces off of the paddle and the walls 
of the world. Thus, after two bounces --- One off of the paddle and one off of the right wall --- the ball 
might have the trajectory shown in the second diagram. (Note that the dotted line is used to show the 
ball's path won't appear on the screen.)

As you can see from the second diagram, the ball is about to collide with one of the bricks on the bottom row. When that happens, the ball 
bounces just as it does on any other collision, but the brick disappears. The third diagram shows what the game 
looks like after that collision and after you ave moved the paddle to line it up with the 
oncoming ball. The play continues in this way until one of the following conditions occurs:

- The ball hits the lower wall, which means that you must have missed it with the paddle. In this case, 
the turn ends and the next ball is served, assuming that you have not already exhausted your allotment of
three turns. If you have, the game ends in a loss.
- The last brick is eliminated. In this case, the game ends immediately, and you can retire in victory.

After all the bricks in a particular column have been cleared, a path will open to the top wall. When this 
delightful situation occurs, the ball will often bounce back and forth several times between the top wall and the upper 
line of bricks without the user ever having to worry about hitting the ball with the paddle. This condition is the 
reward for "breaking out" and gives meaning to the name of the game.

It is important to note that, even though breaking out is a very exciting part of the player's experience,
you don't have to do anything special in your program to make it happen. The game is operated by the same rules as always:
bouncing off walls, clearing bricks, and obeying the laws of physics.

The only part of the implementation that does require some explanation is the problem of checking to see 
whether the ball has collided with a brick or the paddle. The easiest strategy to adopt 
is to call getElemntAt(x,y), which returns the object that covers the point (x,y) on the canvas.

Given the ball is not a single point, it is not sufficient to check only the coordinates of the center. In this program, 
the simplest strategy is to check the four corner points on the square in which the ball is inscribed. The fact that an Ellipse
is defined in terms of its bounding rectangle means that if the upper left corner of the ball is at point (x,y), the other corners will be at the locations
shown in this diagram:

![Diagram of ball corner positions](./corners.png)

These points have the advantage of being outside the ball -- which means that getElementAt can't return the ball itself. Thus,
for each of the four corners, you need to call getElementAt on that location to see whether anything is there. If the value you get back 
is not null, you have a collision with either a brick or the paddle. 

