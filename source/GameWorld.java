import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private static Counter scoreCounter, armorCounter, hpCounter, fpsCounter;
    private UserTankBody userTankBody;
    private GunTower gunTower;
    private EnemyTankBody enemyTankBody;
    private EnemyGunTower enemyGunTower;
    private static int score = 0;
    private int frames;
    private long lastTime = System.currentTimeMillis();
    private Health health;
    private Armor armor;
    
    private int enemyTankSpawnCoolDown, healthSpawnCoolDown, armorSpawnCoolDown;
    
    /**
     * Constructor for objects of class gameWorld.
     * 
     */
    public GameWorld()
    {
        super(1000, 750, 1);
        
        setPaintOrder(Counter.class,  EnemyGunTower.class, EnemyTankBody.class);
        
        userTankBody = new UserTankBody();
        addObject(userTankBody, 300, 200);
        
        gunTower = new GunTower(userTankBody);
        addObject(gunTower, 300, 200);
        
        score = 0;
        
        scoreCounter = new Counter ("Points: ");
        hpCounter = new Counter ("Life: ");
        armorCounter = new Counter ("Armor Left: ");
        fpsCounter = new Counter ("FPS: ");
        addObject(scoreCounter, 940, 32);
        addObject(hpCounter, 670, 32);
        addObject(armorCounter, 370, 32);
        addObject(fpsCounter, 100, 32);
        
        enemyTankSpawnCoolDown = 1;
        healthSpawnCoolDown = 1;
        armorSpawnCoolDown = 1;
        
        frames = 0;
    }
    
   public void act() {
        enemyTankSpawnCoolDown--;
        healthSpawnCoolDown--;
        armorSpawnCoolDown--;
        
        hpCounter.setValue(userTankBody.getHP());
        scoreCounter.setValue(score);
        armorCounter.setValue(gunTower.getArmor());
        countFPS();
        
        if (enemyTankSpawnCoolDown == 0) {
            createEnemyTank();
            enemyTankSpawnCoolDown = 120 + Greenfoot.getRandomNumber(150);
        }
        
        if (healthSpawnCoolDown == 0) {
            createHealth();
            healthSpawnCoolDown = 300 + Greenfoot.getRandomNumber(200);
        }
        
        if (armorSpawnCoolDown == 0) {
            createArmor();
            armorSpawnCoolDown = 300 + Greenfoot.getRandomNumber(200);
        }
    }
    
    public void countFPS() {
        frames++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= 1000) { 
            fpsCounter.setValue(frames);
            frames = 0;
            lastTime = currentTime;
        }
    }
    
    private void createArmor() {
        armor = new Armor();
        addObject(armor, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(750));
    }
    
    public static void addPoints() {
        score++;
    }
    
    private void createEnemyTank() {
        int y = Greenfoot.getRandomNumber(750);
        enemyTankBody = new EnemyTankBody();
        addObject(enemyTankBody, 700, y);
        enemyTankBody.addedToWorld(this);
        enemyGunTower = new EnemyGunTower(enemyTankBody, gunTower);
        addObject(enemyGunTower, 700, y);
        enemyTankBody.setGunTower(enemyGunTower);
    }
    
    private void createHealth() {
        health = new Health();
        addObject(health, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(750));
    }
}
