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
    private GunTower gunTower;
    private int speed;
    
    private GreenfootSound[] tankSound;
    
    public UserTankBody(int speed) {
        setImage("userTankBody.png");
        getImage().rotate(90);
        hp = 3500;
        tankSoundIndex = 0;
        tankSound = new GreenfootSound[2];
        this.speed = speed;
        /** for (int i = 0; i < 2; i++) {
            //tankSound[i] = new GreenfootSound("tankDriving.wav");
            tankSound[i].setVolume(50);
        } **/
    }
    
    public void act(){
        checkKey();
    }
    
    private void checkKey() {
        boolean isMove = false;
        int originalLocationX = getX(), originalLocationY = getY();
        int originalAngle = getRotation();
        
        if (Greenfoot.isKeyDown("w")) {
            move(speed); // Move forward
            isMove = true;
        } else if (Greenfoot.isKeyDown("s")) {
            move(-speed); // Move backward
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
            move(speed); // Move forward
            isMove = true;
        } else if (Greenfoot.isKeyDown("down")) {
            move(-speed); // Move backward
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
        
        Health health = (Health)getOneIntersectingObject(Health.class);
        if (health != null) {
            // Reset position and rotation if a collision occurs
            this.addHP(health.hpIncrease());
            health.used();
        }
        
        Armor armor = (Armor)getOneIntersectingObject(Armor.class);
        if (armor != null) {
            gunTower.addArmor(armor.armorIncreaes());
            armor.used();
        }
    }
    
    public void setGunTower(GunTower gunTower) {
        this.gunTower = gunTower;
    }
    
    public int getHP() {
        return hp; 
    }
    
    public void addHP(int x) {
        hp += x;
        if (hp > 3500) hp = 3500;
    }
    
    public int getXc() {
        return getX();
    }
    
    public int getYc() {
        return getY();
    }
    
    public void damageMe() {
        int damage = Greenfoot.getRandomNumber(100) + 400;
        hp -= damage;
        // End the game if HP = 0
        hp = Math.max(hp, 0);
        if (hp == 0) {
            Greenfoot.setWorld(new EndGameWorld());
        }
    }
    
    private void playSound() {
        tankSound[tankSoundIndex % 2].play();
        tankSoundIndex++;
    }
    
}
