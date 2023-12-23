import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line extends Shape
{
    /**
     * Act - do whatever the Line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void rotate () {
        if (getRotation() == 0 ) {
            
            List checkIntersection = getObjectsAtOffset (-20,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,40,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-20,80,Blocks.class);
            checkIntersection3.remove (this);
            List checkIntersection4 = getObjectsAtOffset (0,-80,Blocks.class);
            checkIntersection4.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty () ){
                setRotation (90);
                setLocation (getX () -20,getY () +20);
            }
            else if (  checkIntersection.isEmpty () && checkIntersection3.isEmpty () && checkIntersection4.isEmpty ()) {

                setRotation (90);
                setLocation (getX () -20,getY () -60);
            }
        }
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (-40,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (40,-20,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (80,-20,Blocks.class);
            checkIntersection3.remove (this);
            List checkIntersection4 = getObjectsAtOffset (120,-20,Blocks.class);
            checkIntersection4.remove (this);
            List checkIntersection5 = getObjectsAtOffset (-80,-20,Blocks.class);
            checkIntersection5.remove (this);
            List checkIntersection6 = getObjectsAtOffset (-120,-20,Blocks.class);
            checkIntersection6.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty () ){
                setRotation (0);
                setLocation (getX () +20,getY () -20);
            }
            else if (  checkIntersection2.isEmpty () && checkIntersection3.isEmpty () && checkIntersection4.isEmpty ()) {
                setRotation (0);
                setLocation (getX () +60,getY () -20);
            }
            else if (  checkIntersection.isEmpty () && checkIntersection5.isEmpty () && checkIntersection6.isEmpty () ) {
                setRotation (0);
                setLocation (getX () -60,getY () -20);
            }
        }
    }

    public boolean checkLeft () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (-100,0,Blocks.class);
            checkIntersection.remove (this);

            if (checkIntersection.isEmpty ()){
                return true;

            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-40,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-40,-20,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-40,60,Blocks.class);
            checkIntersection3.remove (this);
            List checkIntersection4 = getObjectsAtOffset (-40,-60,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty () && checkIntersection4.isEmpty ()){
                return true;
            }
            
        }

        return false;

    }

    public boolean checkRight () {
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (80,0,Blocks.class);
            checkIntersection.remove (this);

            if (checkIntersection.isEmpty ()){
                return true;

            }
            
        }
        else {
            List checkIntersection = getObjectsAtOffset (40,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (40,-20,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (40,60,Blocks.class);
            checkIntersection3.remove (this);
            List checkIntersection4 = getObjectsAtOffset (40,-60,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty () && checkIntersection4.isEmpty ()){
                return true;
            }
            
        }
        return false;
    }

    public boolean checkDown () {
        if (getRotation () == 0){
            List checkIntersection = getObjectsAtOffset (0,40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,40,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection3.remove (this);
            List checkIntersection4 = getObjectsAtOffset (-60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty () && checkIntersection4.isEmpty ()){
                return true;
            }
            
        }
        else {
            List checkIntersection = getObjectsAtOffset (0,80,Blocks.class);
            checkIntersection.remove (this);

            if (checkIntersection.isEmpty () ){
                return true;

            }
        }
        return false;
    }

    public int []createIt () {
        if (getRotation () == 0) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 2;
            Game.gameboard [x+1] [y] = 2;
            Game.gameboard [x-1] [y] = 2;
            Game.gameboard [x+2] [y] = 2;
            int[] coords = {x,y,x+1,y,x-1,y,x+2,y};
            getWorld().removeObject (this);
            

            return coords;

        }
        else {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 65)/40);
            Game.gameboard [x] [y] = 2;

            Game.gameboard [x] [y-1] = 2;

            Game.gameboard [x] [y+2] = 2;

            Game.gameboard [x] [y+1] = 2;
            getWorld().removeObject (this);

            int[] coords = {x,y,x,y-1,x,y+2,x,y+1};
            

            return coords;

        }
    }
}
