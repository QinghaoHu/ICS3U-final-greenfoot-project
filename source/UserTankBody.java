import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class userTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserTankBody extends SuperSmoothMover {
    /**
     * Act - do whatever the userTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int hp;
    private int movingSpeed;
    private int tankSoundIndex;
    
    private GreenfootSound[] tankSound;
    
    public UserTankBody() {
        setImage("userTankBody.png");
        getImage().rotate(90);
        hp = 1500;
        tankSoundIndex = 0;
        tankSound = new GreenfootSound[2];
        for (int i = 0; i < 2; i++) {
            tankSound[i] = new GreenfootSound("tankDriving.wav");
            tankSound[i].setVolume(50);
        }
    }
    
    public void act(){
        checkKey();
    }
    
    private void checkKey() {
        boolean isMove = false;
        int originalLocationX = getX(), originalLocationY = getY();
        int originalAngle = getRotation();
        
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
        
        EnemyTankBody enemyTank = (EnemyTankBody)getOneIntersectingObject(EnemyTankBody.class);
        if (enemyTank != null) {
            // Reset position and rotation if a collision occurs
            setLocation(originalLocationX, originalLocationY);
            setRotation(originalAngle);
            isMove = false; // Stop moving
        }
        
        if (isMove) {
            playSound();
        }
    }
    
    public int getHP() {
        return hp; 
    }
    
    public void damageMe() {
        int damage = Greenfoot.getRandomNumber(100) + 400;
        hp -= damage;
        // End the game if HP = 0
    }
    
    private void playSound() {
        tankSound[tankSoundIndex % 2].play();
        tankSoundIndex++;
    }
    
}
