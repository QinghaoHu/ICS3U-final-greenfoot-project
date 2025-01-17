import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends SuperSmoothMover
{
    /**
     * Act - do whatever the enemyProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int angle;
    private static final Color niceRed = new Color (204, 0, 0);
    private static final Color niceYellow = new Color (255, 215, 0);
    
    public EnemyProjectile(int angle) {
    // Create an image of size 16x16 for the projectile
        GreenfootImage image = new GreenfootImage(16, 16);
        
        // Draw the bullet body (main rectangle)
        image.setColor(niceYellow); // Set the color for the rectangle
        image.fillRect(6, 10, 4, 6); // Rectangle dimensions (x, y, width, height)
        
        // Draw triangular tip of the bullet
        image.setColor(niceRed); // Set the color for the triangle
        int[] xPoints = {6, 10, 8}; // X-coordinates of triangle vertices
        int[] yPoints = {10, 10, 6}; // Y-coordinates of triangle vertices
        image.fillPolygon(xPoints, yPoints, 3); // Draw the triangle
        
        // Set the image for the actor
        setImage(image);
        getImage().rotate(90);
        this.angle = angle;
        setRotation(angle); 
    }
    
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Move the projectile
        move(15);

        // Add a trail piece at the current location
        getWorld().addObject(new TrailPiece(getImage(), 30, angle), getX(), getY());
        
        UserTankBody userTank = (UserTankBody)getOneIntersectingObject(UserTankBody.class);
        if (userTank != null) {
            userTank.damageMe();
            EnemyProjectileExplosion explosion = new EnemyProjectileExplosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this);
            return;
        }

        // Remove the projectile if it reaches the edge of the world
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
