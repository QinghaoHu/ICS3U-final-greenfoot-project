import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class userTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class userTankBody extends SuperSmoothMover {
    /**
     * Act - do whatever the userTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public userTankBody() {
        setImage("userTankBody.png");
        getImage().rotate(90);
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("up")) {
            move(2); // Move forward
        } else if (Greenfoot.isKeyDown("down")) {
            move(-2); // Move backward
        }

        // Rotate the tank body with left/right arrow keys (optional)
        if (Greenfoot.isKeyDown("left")) {
            turn(-2); // Rotate counter-clockwise
        } else if (Greenfoot.isKeyDown("right")) {
            turn(2); // Rotate clockwise
        }
    }
}
