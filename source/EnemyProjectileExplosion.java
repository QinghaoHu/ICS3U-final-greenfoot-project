import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectileExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectileExplosion extends Actor
{
    private int size = 10; // Initial size of the explosion
    private int maxSize = 50; // Maximum size of the explosion
    private int transparency = 255; // Initial transparency

    public EnemyProjectileExplosion() {
        updateImage();
    }

    public void act() {
        size += 5; // Increase size each frame
        transparency -= 20; // Reduce transparency each frame

        if (transparency <= 0) {
            getWorld().removeObject(this); // Remove explosion when it's invisible
        } else {
            updateImage();
        }
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(size, size);
        image.setColor(new Color(173, 216, 230, transparency)); // Explosion color (red-orange)
        image.fillOval(0, 0, size, size); // Draw a filled circle
        setImage(image);
    }
}
