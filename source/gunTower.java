import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gunTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gunTower extends SuperSmoothMover
{
     private userTankBody tankBody;

    public gunTower(userTankBody body) {
        tankBody = body; // Link the tank body
        setImage("gunTower.png"); // Set the gun tower image
        getImage().rotate(90);
    }

    public void act() {
        // Keep the gun tower positioned on the tank body
        setLocation(tankBody.getX(), tankBody.getY());

        // Rotate the gun tower to point at the mouse when clicked
        MouseInfo mouse = Greenfoot.getMouseInfo(); // Get mouse info
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int angle = (int) Math.toDegrees(Math.atan2(mouseY - getY(), mouseX - getX()));
            setRotation(angle); // Point the gun tower toward the mouse
            if (Greenfoot.mouseClicked(null)) {
                shootProjectile(angle);
            }
        }
    }
    
    public void shootProjectile(int angle) {
        Projectile projectile = new Projectile(angle); // Create a projectile
        getWorld().addObject(projectile, getX(), getY());
    }
}
