Breakout!
==========================

A program based on the classic arcade game of Breakout, which
was developed in 1976 by Steve Wozniak, who would later become one of the founders 
of Apple. In Breakout, the goal is to clear a collection of bricks by hitting each of them with 
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
