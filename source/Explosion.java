import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor {
    private int size = 10; // Initial size of the explosion
    private int maxSize = 50; // Maximum size of the explosion
    private int transparency = 255; // Initial transparency

    public Explosion() {
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
        image.setColor(new Color(255, 69, 0, transparency)); // Explosion color (red-orange)
        image.fillOval(0, 0, size, size); // Draw a filled circle
        setImage(image);
    }
}

