import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shape extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void rotate(){
        
    }
    public int[] createIt(){
        int[]x=new int [1];
        return x;
    }
    public boolean checkDown(){
        return true;
    }
    public boolean checkLeft(){
        return true;
    }
    public boolean checkRight(){
        return true;
    }
}
