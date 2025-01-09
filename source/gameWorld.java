import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameWorld extends World
{
    private static Counter scoreCounter;
    /**
     * Constructor for objects of class gameWorld.
     * 
     */
    public gameWorld()
    {
        super(1000, 750, 1); 
        scoreCounter = new Counter("Points: ");
        addObject(scoreCounter, 940, 30);
        
    }
}
