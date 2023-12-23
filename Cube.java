import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Shape
{
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public void rotate(){
        setLocation(getX(),getY());
    }

    public int[] createIt(){
        int x=((getX()-445)/40);
        int y=((getY()-45)/40);
        Game.gameboard[x][y]=1;
        Game.gameboard[x][y+1]=1;
        Game.gameboard[x+1][y]=1;
        Game.gameboard[x+1][y+1]=1;
        getWorld().removeObject (this);
        int[]coords={x,y,x+1,y,x,y+1,x+1,y+1};
        return coords;
    }

    public boolean checkDown(){
        List checkIntersection = getObjectsAtOffset (20,60,Blocks.class);
        checkIntersection.remove (this);
        List checkIntersection1 = getObjectsAtOffset (-20,60,Blocks.class);
        checkIntersection1.remove (this);
        if (checkIntersection1.isEmpty () && checkIntersection.isEmpty ()){
            return true;

        }

        return false;
    }

    public boolean checkLeft(){
        List checkIntersection = getObjectsAtOffset (-60,-20,Blocks.class);
        checkIntersection.remove (this);
        List checkIntersection1 = getObjectsAtOffset (-60,20,Blocks.class);
        checkIntersection1.remove (this);
        if (checkIntersection1.isEmpty () && checkIntersection.isEmpty ()){
            return true;

        }

        return false;
    }

    public boolean checkRight(){
        List checkIntersection = getObjectsAtOffset (60,-20,Blocks.class);
        checkIntersection.remove (this);
        List checkIntersection1 = getObjectsAtOffset (60,20,Blocks.class);
        checkIntersection1.remove (this);
        if (checkIntersection1.isEmpty () && checkIntersection.isEmpty ()){
            return true;

        }

        return false;
    }
}
