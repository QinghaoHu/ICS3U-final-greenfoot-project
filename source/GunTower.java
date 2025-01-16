import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gunTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunTower extends SuperSmoothMover
{
    private UserTankBody tankBody;
    private int armor;
    private SuperStatBar coolDownBar;
    private int coolDown;
    private int maxCoolDown;

    public GunTower(UserTankBody body) {
        tankBody = body; // Link the tank body
        setImage("gunTower.png"); // Set the gun tower image
        getImage().rotate(90);
        armor = 30;
        maxCoolDown = 120;
        coolDownBar = new SuperStatBar (maxCoolDown, coolDown, this, 40, 8, -32, Color.GREEN, Color.RED, true, Color.YELLOW, 1); 
        // getWorld().addObject(coolDownBar, getX(), getY());
    }

    public void act() {
         if (tankBody == null) {
            getWorld().removeObject(this);
         }
        // Keep the gun tower positioned on the tank body
        setLocation(tankBody.getX(), tankBody.getY());

        // Rotate the gun tower to point at the mouse when clicked
        MouseInfo mouse = Greenfoot.getMouseInfo(); // Get mouse info
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int angle = (int) Math.toDegrees(Math.atan2(mouseY - getY(), mouseX - getX()));
            int difference = angle - getRotation();
            turn(difference);
            // setRotation(angle); // Point the gun tower toward the mouse
            if (Greenfoot.mouseClicked(null)) {
                shootProjectile(angle);
            }
        }
    }
    
    private void shootProjectile(int angle) {
        Projectile projectile = new Projectile(angle); // Create a projectile
        getWorld().addObject(projectile, getX(), getY());
    }
    
    public int getArmor() {
        return armor;
    }
}
