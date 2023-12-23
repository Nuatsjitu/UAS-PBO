import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ReverseLshape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseLshape extends Shape
{
    /**
     * Act - do whatever the ReverseLshape wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void rotate(){
        if (getRotation() == 270) { 
            List checkIntersection = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty ()) {
                setRotation (0);
                setLocation (getX () +20,getY () +20);
            }

            else {
                List checkIntersection1 = getObjectsAtOffset (-60,0,Blocks.class);
                checkIntersection1.remove (this);
                if (checkIntersection1.isEmpty ()){
                    setLocation (getX () -40,getY ());
                    setRotation (0);
                    setLocation (getX () +20,getY () +20);
                }

            }

        }
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
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (-60,-40,Blocks.class);
            checkIntersection.remove (this);

            if (checkIntersection.isEmpty ()) {
                setRotation (getRotation()+90);
                setLocation (getX () -20,getY () -20);
            }
            else {
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

    public int[] createIt(){
        if (getRotation () == 270) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 3;
            Game.gameboard [x] [y+1] = 3;
            Game.gameboard [x] [y-1] = 3;
            Game.gameboard [x+1] [y-1] = 3;
            getWorld().removeObject (this);
            int[] coords = {x,y,x,y+1,x,y-1,x+1,y-1};
            return coords;

        }
        else if (getRotation () == 0) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
           Game.gameboard [x] [y] = 3;
            Game.gameboard [x-1] [y] = 3;
            Game.gameboard [x+1] [y+1] = 3;
            Game.gameboard [x+1] [y] =3;
            getWorld().removeObject (this);
            int[] coords = {x,y,x-1,y,x+1,y+1,x+1,y};

            return coords;

        }
        else if (getRotation () == 90) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x+1] [y] = 3;
            Game.gameboard [x+1] [y+1] = 3;
            Game.gameboard [x+1] [y-1] = 3;
            Game.gameboard [x] [y+1] = 3;
            getWorld().removeObject (this);
            int[] coords = {x+1,y,x+1,y+1,x+1,y-1,x,y+1};

            return coords;

        }
        else {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            
             Game.gameboard [x] [y+1] = 3;
            Game.gameboard [x+1] [y+1] = 3;
            Game.gameboard [x-1] [y] = 3;
            Game.gameboard [x-1] [y+1] =3;
            getWorld().removeObject (this);
            int[] coords = {x,y+1,x+1,y+1,x-1,y,x-1,y+1};
            return coords;
        }
    }

    public boolean checkDown(){
        if (getRotation () == 270){
            List checkIntersection1 = getObjectsAtOffset (-20,80,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (20,0,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else if (getRotation () == 0){
            List checkIntersection = getObjectsAtOffset (0,20,Blocks.class);
            List checkIntersection2 = getObjectsAtOffset (-40,20,Blocks.class);
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
            List checkIntersection = getObjectsAtOffset (0,60,Blocks.class);
            List checkIntersection2 = getObjectsAtOffset (40,60,Blocks.class);
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

    public boolean checkLeft(){
        if (getRotation () == 270) {
            List checkIntersection = getObjectsAtOffset (-20,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,-40,Blocks.class);
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
            List checkIntersection2 = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (-60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-80,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        return false;
    }

    public boolean checkRight(){
        if (getRotation () == 270) {
            List checkIntersection = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (60,-40,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;
            }
        }

        else if (getRotation () == 0 ) {
            List checkIntersection = getObjectsAtOffset (80,20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (0,-20,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () ){
                return true;

            }
        }
        else if (getRotation () == 90) {
            List checkIntersection = getObjectsAtOffset (60,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection2 = getObjectsAtOffset (20,0,Blocks.class);
            checkIntersection2.remove (this);
            List checkIntersection3 = getObjectsAtOffset (20,40,Blocks.class);
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
}
