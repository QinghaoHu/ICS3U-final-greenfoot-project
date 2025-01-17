import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class armor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armor extends SuperSmoothMover
{
    /**
     * Act - do whatever the armor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Armor() {
        setImage("armor.png");
    }
    
    public int armorIncreaes() {
        return 20 + Greenfoot.getRandomNumber(20);
    }
    
    public void used() {
        getWorld().removeObject(this);
    }
}
