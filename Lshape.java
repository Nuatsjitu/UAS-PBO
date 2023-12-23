import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Lshape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lshape extends Shape
{
    /**
     * Act - do whatever the Lshape wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void rotate () {
        //When the shape is 0 degree rotation
        if (getRotation() == 270) { 
            //Checks coords if possible to rotate
            List checkIntersection = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty ()) {
                setRotation (0);
                setLocation (getX () +20,getY () +20);
            }
            //bounces the shape so it is possible to rotate
            else {
                List checkIntersection1 = getObjectsAtOffset (-60,0,Blocks.class);
                checkIntersection1.remove (this);
                if (checkIntersection1.isEmpty ()){
                    setLocation (getX () -40,getY ());
                    setRotation (getRotation()+90);
                    setLocation (getX () +20,getY () +20);
                }

            }

            
        }
        //When it is 90 degree rotation
        else if (getRotation() == 0) {
            List checkIntersection = getObjectsAtOffset (0,-60,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-40,-60,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                setRotation (getRotation()+90);
                setLocation (getX () -20,getY () -20);

            }

        }
        //When 180 degree rotation
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty ()) {
                setRotation (getRotation()+90);
                setLocation (getX () -20,getY () -20);
            }
            else {
                //bounces the shape so it is possible to rotate
                List checkIntersection1 = getObjectsAtOffset (60,0,Blocks.class);
                checkIntersection.remove (this);
                List checkIntersection2 = getObjectsAtOffset (60,-40,Blocks.class);
                checkIntersection.remove (this);
                if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()) {
                    setLocation (getX () +40,getY ());
                    setRotation (getRotation()+90);
                    setLocation (getX () -20,getY () -20);
                }
                

            }

            
        }
        //When 270 degrees rotation
        else {
            List checkIntersection = getObjectsAtOffset (0,60,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (40,60,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (0,-20,Blocks.class);
            checkIntersection3.remove (this);

            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                setRotation (getRotation()+90);
                setLocation (getX () +20,getY () +20);

            }
            else if (checkIntersection3.isEmpty ()) 
            {
                setRotation (getRotation()+90);
                setLocation (getX () ,getY ()-40);
                setLocation (getX () +20,getY () +20);
            }

            
        }
    }

    //Check if it is possible to move left, structure is the same as rotate
    public boolean checkLeft () {
        if (getRotation () == 270) {
            List checkIntersection = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-60,-40,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }

        else if (getRotation () == 0 ) {
            List checkIntersection = getObjectsAtOffset (-80,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-80,20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else if (getRotation () == 90) {
            List checkIntersection = getObjectsAtOffset (-60,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,0,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-20,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-80,20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,-20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }

        return false;

    }

    //Check if it is possible to move right, structure is the same as rotate
    public boolean checkRight () {
        if (getRotation () == 270) {
            List checkIntersection = getObjectsAtOffset (20,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (20,-40,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }

        else if (getRotation () == 0 ) {
            List checkIntersection = getObjectsAtOffset (80,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else if (getRotation () == 90) {
            List checkIntersection = getObjectsAtOffset (60,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (80,20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (80,-20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        return false;
    }

    //Check if it is possible to move down, structure is the same as rotate
    public boolean checkDown () {
        if (getRotation () == 270){
            
            List checkIntersection1 = getObjectsAtOffset (20,80,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,0,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else if (getRotation () == 0){
            List checkIntersection = getObjectsAtOffset (0,60,Blocks.class);
            List checkIntersection2 = getObjectsAtOffset (-40,60,Blocks.class);
            List checkIntersection3 = getObjectsAtOffset (40,60,Blocks.class);
            checkIntersection.remove (this);
            checkIntersection2.remove (this);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;

            }
            
        }
        else if (getRotation () == 90){
            List checkIntersection1 = getObjectsAtOffset (20,80,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,80,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (0,20,Blocks.class);
            List checkIntersection2 = getObjectsAtOffset (40,20,Blocks.class);
            List checkIntersection3 = getObjectsAtOffset (-40,60,Blocks.class);
            checkIntersection.remove (this);
            checkIntersection2.remove (this);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;

            }
        }
        return false;
    }

    //Registers the shape into the array and sends back coords so it can be drawn into the world
    public int [] createIt () {
        if (getRotation () == 270) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x+1] [y] = 6;
            Game.gameboard [x+1] [y+1] = 6;
            Game.gameboard [x+1] [y-1] = 6;
            Game.gameboard [x] [y-1] = 6;
             getWorld().removeObject (this);
            int[] coords = {x+1,y,x+1,y+1,x+1,y-1,x,y-1}; 
            
                return coords;
           

        }
        else if (getRotation () == 0) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            
            Game.gameboard [x] [y+1] = 6;
            Game.gameboard [x+1] [y+1] = 6;
            Game.gameboard [x-1] [y+1] = 6;
            Game.gameboard [x+1] [y] = 6;
            getWorld().removeObject (this);
            int[] coords = {x,y+1,x+1,y+1,x-1,y+1,x+1,y};    
                return coords;


        }
        else if (getRotation () == 90) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 6;
            Game.gameboard [x] [y+1] = 6;
            Game.gameboard [x] [y-1] = 6;
            Game.gameboard [x+1] [y+1] = 6;
            getWorld().removeObject (this);
            int[] coords = {x,y,x,y+1,x,y-1,x+1,y+1}; 
              
            return coords;


        }
        else {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 6;
            Game.gameboard [x+1] [y] = 6;
            Game.gameboard [x-1] [y] = 6;
            Game.gameboard [x-1] [y+1] = 6;
             getWorld().removeObject (this);
            int[] coords = {x,y,x+1,y,x-1,y,x-1,y+1};
            
                
                return coords;

        }
    }
}
