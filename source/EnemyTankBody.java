import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyTankBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTankBody extends SuperSmoothMover
{
    /**
     * Act - do whatever the enemyTankBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isOnRotate;
    private int rotateDegree, hp;
    private EnemyGunTower gunTower;
    
    public EnemyTankBody() {
        setImage("enemyTankBody.png");
        getImage().rotate(90);
        setRotation(180);
        isOnRotate = false;
        rotateDegree = 0;
        hp = 600;
    }
    
    public void setGunTower(EnemyGunTower gunTower) {
        this.gunTower = gunTower;
    }
    
    public void act(){
        int originalLocationX = getX(), originalLocationY = getY();
        int originalAngle = getRotation();
        
        if (isOnRotate) {
            turn(1);
            rotateDegree += 1;
            if (rotateDegree == 180) {
                isOnRotate = false;
                rotateDegree = 0;
            }
        } else {
        move(1);
            int x = Greenfoot.getRandomNumber(4);
            int y = (int)Greenfoot.getRandomNumber(120);
            if (y == 1) {
                x -= 2;
                turn(x);
            }
            if (isAtEdge()) {
                isOnRotate = true;
            }
        }
        
        EnemyTankBody enemyTank = (EnemyTankBody)getOneIntersectingObject(EnemyTankBody.class);
        if (enemyTank != null) {
            // Reset position and rotation if a collision occurs
            setLocation(originalLocationX, originalLocationY);
            setRotation(originalAngle);
        }
        
        UserTankBody userTank = (UserTankBody)getOneIntersectingObject(UserTankBody.class);
        if (userTank != null) {
            // Reset position and rotation if a collision occurs
            setLocation(originalLocationX, originalLocationY);
            setRotation(originalAngle);
        }
    }
    
    public void getDamage() {
        hp -= 200 + Greenfoot.getRandomNumber(400);
        if (hp <= 0) {
            GameWorld.addPoints();
            getWorld().removeObject(gunTower);
            getWorld().removeObject(this);
        }
    }
}
