import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    private GreenfootImage image;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private String text;

    private static final Color niceRed = new Color (204, 0, 0);
    private static final Color niceYellow = new Color (255, 246, 144);
    
    private static final Font buttonFont = new Font("Comic Sans MS", true, false, 36);

    
    public Button (String text) {
        this.text = text;
        drawButton (text);
    }

    private void drawButton (String text){
        image = new GreenfootImage(300, 50);
        image.setColor(niceYellow);
        image.fill();
        image.setColor(niceRed);
        image.setFont(buttonFont);
        image.drawString (text, 24, 40);
        setImage(image);
    }

}
