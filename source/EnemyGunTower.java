import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class eneGunTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyGunTower extends SuperSmoothMover
{
    private EnemyTankBody enemyTankBody;
    private GunTower userTankBody;
    private int cooldown = 0;
    private int angle;
    int rotationDuration = 0, randomFactor = 20;
    
    public EnemyGunTower(EnemyTankBody enemyTankBody, GunTower userTankBody) {
        this.enemyTankBody = enemyTankBody;
        this.userTankBody = userTankBody;
        setImage("enemyGunTower.png");
        getImage().rotate(90);
    }
    
    public void act()
    {
        rotationDuration++;
        setLocation(enemyTankBody.getX(), enemyTankBody.getY());
        int userX = userTankBody.getX(), userY = userTankBody.getY();
        this.angle = (int)Math.toDegrees(Math.atan2(userY - getY(), userX - getX()));
        if (rotationDuration == 60) {
            randomFactor = Greenfoot.getRandomNumber(8);
        }
        setRotation(angle + randomFactor - 10);
        cooldown++;
        if (cooldown == 300) {
            enemyShoot();
            cooldown = 0;
        }
    }
    
    public void enemyShoot() {
        EnemyProjectile projectile = new EnemyProjectile(angle); // Create a projectile
        getWorld().addObject(projectile, getX(), getY());
    }
}
