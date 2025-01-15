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
    private userTankBody tbk;
    private gunTower gtw;
    private enemyTankBody etb;
    /**
     * Constructor for objects of class gameWorld.
     * 
     */
    public gameWorld()
    {
        super(1000, 750, 1);
        
        tbk = new userTankBody();
        addObject(tbk, 300, 200);
        
        gtw = new gunTower(tbk);
        addObject(gtw, 300, 200);
        
        etb = new enemyTankBody();
        addObject(etb, 700, 600);
        
    }
}
