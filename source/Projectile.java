import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SuperSmoothMover
{
    private int angle;

    /**
     * Constructor for Projectile.
     * @param angle The angle at which the projectile is launched.
     */
    public Projectile(int angle) {
        // Create an image of size 16x16 for the projectile
        GreenfootImage image = new GreenfootImage(16, 16);
        
        // Draw the bullet body (main rectangle)
        image.setColor(Color.GRAY); // Set the color for the rectangle
        image.fillRect(6, 10, 4, 6); // Rectangle dimensions (x, y, width, height)

        // Draw triangular tip of the bullet
        image.setColor(Color.RED); // Set the color for the triangle
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
        move(40);

        // Add a trail piece at the current location
        getWorld().addObject(new TrailPiece(getImage(), 20, angle), getX(), getY());

        // Remove the projectile if it reaches the edge of the world
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
