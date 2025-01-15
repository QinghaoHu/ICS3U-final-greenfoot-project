import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyTankBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyTankBody extends SuperSmoothMover
{
    /**
     * Act - do whatever the enemyTankBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public enemyTankBody() {
        setImage("userTankBody.png");
        getImage().rotate(90);
        setRotation(180);
    }
    
    public void act(){
        move(1);
        int x = Greenfoot.getRandomNumber(6);
        int y = (int)Greenfoot.getRandomNumber(60);
        if (y == 1) {
            x -= 3;
            turn(x);
        }
        
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
