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
    
    /**
     * Constructor for objects of class gameWorld.
     * 
     */
    public GameWorld()
    {
        super(1000, 750, 1);
        
        setPaintOrder(Counter.class,  EnemyGunTower.class);
        
        userTankBody = new UserTankBody();
        addObject(userTankBody, 300, 200);
        
        gunTower = new GunTower(userTankBody);
        addObject(gunTower, 300, 200);
        
        score = 0;
        
        scoreCounter = new Counter ("Points: ");
        hpCounter = new Counter ("Life: ");
        armorCounter = new Counter ("Bomb: ");
        fpsCounter = new Counter ("FPS: ");
        addObject(scoreCounter, 960, 32);
        addObject(hpCounter, 960, 56);
        addObject(armorCounter, 960, 80);
        addObject(fpsCounter, 960, 103);
        frames = 0;
    }
    
   public void act() {
        hpCounter.setValue(userTankBody.getHP());
        scoreCounter.setValue(score);
        
        countFPS();
        
        int spawnOption = Greenfoot.getRandomNumber(100);
        if (spawnOption == 0) {
            createEnemyTank();
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
    
    public static void addPoints() {
        score++;
    }
    
    private void createEnemyTank() {
        int y = Greenfoot.getRandomNumber(750);
        enemyTankBody = new EnemyTankBody();
        addObject(enemyTankBody, 700, y);
        enemyGunTower = new EnemyGunTower(enemyTankBody, gunTower);
        addObject(enemyGunTower, 700, y);
        enemyTankBody.setGunTower(enemyGunTower);
    }
}
