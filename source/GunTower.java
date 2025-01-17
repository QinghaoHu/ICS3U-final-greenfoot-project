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
        maxCoolDown = 90;
        coolDown = 80;
        coolDownBar = new SuperStatBar (maxCoolDown, coolDown, this, 40, 8, -32, Color.BLUE, Color.RED, true, Color.GRAY, 1); 
    }
    
    public void addedToWorld (World w) {
        w.addObject (coolDownBar, getX(), getY());
        coolDownBar.update(coolDown);
    }


    public void act() {
         if (tankBody == null) {
            getWorld().removeObject(this);
         }
         
         if (coolDown > 0) coolDown--;
         
         coolDownBar.update(coolDown);
         
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
                if (coolDown == 0 && armor > 0) {
                    shootProjectile(angle);
                    coolDown = maxCoolDown;
                    armor--;
                }
            }
        }
    }
    
    public void addArmor(int x) {
        armor += x;
        if (armor > 50) armor = 50;
    }
    
    private void shootProjectile(int angle) {
        Projectile projectile = new Projectile(angle, tankBody, this); // Create a projectile
        getWorld().addObject(projectile, getX(), getY());
    }
    
    public int getArmor() {
        return armor;
    }
}
