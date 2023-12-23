import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;
/**
 * Write a description of class Explanation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explanation extends Actor
{   public static final int width = 530;
    public static final int height = 450;
    public static final float fontsize= 24.0f;
    
     public Explanation(){
         window();
    }
    public void window(){
         
        GreenfootImage board=new GreenfootImage(width,height);
        board.setColor(new greenfoot.Color(0, 0, 0, 160));
        board.fillRect(0, 0, width, height);
        board.setColor(new greenfoot.Color(255, 255, 255, 100));
        board.fillRect(5, 5, width-10, height-10);
        greenfoot.Font font = board.getFont();
        font = font.deriveFont(fontsize);
        board.setFont(font);
        board.setColor(greenfoot.Color.WHITE);
        board.drawString("TETRIS",225,60);
        board.drawString("Controls:",20,120);
        board.drawString("Press up arrow to turn block.",20, 165);
        board.drawString("Press left and right arrows to move block.",20,210);
        board.drawString("Press down arrow to move block down faster.",20, 255);
        board.drawString("Press the space bar to hard drop it.",20, 300);
        board.drawString("Press 4 for bugs",20,345);
        board.drawString("Press ENTER to begin.",20,390);
        setImage(board);
    }
    public void bugs(){
        GreenfootImage board=new GreenfootImage(width,height);
        board.setColor(new greenfoot.Color(0, 0, 0, 160));
        board.fillRect(0, 0, width, height);
        board.setColor(new greenfoot.Color(255, 255, 255, 100));
        board.fillRect(5, 5, width-10, height-10);
        greenfoot.Font font = board.getFont();
        font = font.deriveFont(fontsize);
        board.setFont(font);
        board.setColor(greenfoot.Color.WHITE);
        board.drawString("Bugs",225,60);
        board.drawString("There are no bugs currently found.",20,120);
        board.drawString("Please inform us otherwise.",20, 165);
        board.drawString("The little lag before it makes the block",20, 255);
        board.drawString("is part of the game, not a bug.",20, 300);
        board.drawString("Press 4 to go back",20,345);
        board.drawString("Press ENTER to begin.",20,390);
        
        setImage(board);
    }
    /**
     * Act - do whatever the Explanation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
