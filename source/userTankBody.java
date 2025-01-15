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
    private int hp;
    private int movingSpeed;
    private int tankSoundIndex;
    
    private GreenfootSound[] tankSound;
    
    public userTankBody() {
        setImage("userTankBody.png");
        getImage().rotate(90);
        hp = 1000;
        tankSoundIndex = 0;
        tankSound = new GreenfootSound[2];
        for (int i = 0; i < 2; i++) {
            tankSound[i] = new GreenfootSound("tankDriving.wav");
            tankSound[i].setVolume(75);
        }
    }
    
    public void act(){
        checkKey();
    }
    
    public void checkKey() {
        boolean isMove = false;
        if (Greenfoot.isKeyDown("w")) {
            move(2); // Move forward
            isMove = true;
        } else if (Greenfoot.isKeyDown("s")) {
            move(-2); // Move backward
            isMove = true;
        }
        // Rotate the tank body with left/right arrow keys (optional)
        if (Greenfoot.isKeyDown("a")) {
            turn(-2); // Rotate counter-clockwise
            isMove = true;
        } else if (Greenfoot.isKeyDown("d")) {
            turn(2); // Rotate clockwise
            isMove = true;
        }
        
        if (Greenfoot.isKeyDown("up")) {
            move(2); // Move forward
            isMove = true;
        } else if (Greenfoot.isKeyDown("down")) {
            move(-2); // Move backward
            isMove = true;
        }

        // Rotate the tank body with left/right arrow keys (optional)
        if (Greenfoot.isKeyDown("left")) {
            turn(-2); // Rotate counter-clockwise
            isMove = true;
        } else if (Greenfoot.isKeyDown("right")) {
            turn(2); // Rotate clockwise
            isMove = true;
        }
        
        if (isMove) {
            playSound();
        }
    }
    
    public void playSound() {
        tankSound[tankSoundIndex % 2].play();
        tankSoundIndex++;
    }
    
}
