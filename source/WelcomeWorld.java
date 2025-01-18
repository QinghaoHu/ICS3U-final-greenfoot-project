import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WelcomeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{
    private Button startButton;

    public WelcomeWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        startButton = new Button("     Start");
        addObject(startButton, 500, 550);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
