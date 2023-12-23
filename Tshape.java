import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Tshape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tshape extends Shape
{
    private int rotation=0;
    /**
     * Act - do whatever the Tshape wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void rotate(){
        if (getRotation() == 0) {
            List checkIntersection = getObjectsAtOffset (0,60,Blocks.class);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty () ) {
                setRotation (getRotation()+90);
                setLocation (getX () +20,getY () +20);
            }
            else {
                List checkIntersection1 = getObjectsAtOffset (0,-60,Blocks.class);
                checkIntersection1.remove (this);
                List checkIntersection2 = getObjectsAtOffset (40,-20,Blocks.class);
                checkIntersection2.remove (this);
                if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()) {
                    setRotation (getRotation()+90);
                    setLocation (getX () +20,getY () -20);
                }
            }
        }
        else if (getRotation() == 90) {
            List checkIntersection = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection.remove (this);
            if (checkIntersection.isEmpty () ) {

                setRotation (getRotation()+90);
                setLocation (getX () -20,getY () -20);
            }
            else {
                List checkIntersection1 = getObjectsAtOffset (60,0,Blocks.class);
                checkIntersection1.remove (this);
                List checkIntersection2 = getObjectsAtOffset (20,40,Blocks.class);
                checkIntersection2.remove (this);
                if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty () ) {

                    setRotation (getRotation()+90);
                    setLocation (getX () +20,getY () -20);
                }
            }
        }
        else if (getRotation() == 180) {
            List checkIntersection1 = getObjectsAtOffset (20,-40,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-60,-40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()) {
                setRotation (getRotation()+90);
                setLocation (getX () -20,getY () -20);
            }
            else {
                List checkIntersection = getObjectsAtOffset (60,-40,Blocks.class);
                checkIntersection.remove (this);
                if (checkIntersection.isEmpty () && checkIntersection1 .isEmpty () ) {

                    setRotation (getRotation()+90);
                    setLocation (getX () +20,getY () -20);
                }
            }

        }
        else if (getRotation() == 270) {
            List checkIntersection1 = getObjectsAtOffset (-20,40,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()) {
                setRotation (0);
                setLocation (getX () +20,getY () +20);
            }
            else {
                List checkIntersection = getObjectsAtOffset (-60,40,Blocks.class);
                checkIntersection.remove (this);
                if (checkIntersection.isEmpty () && checkIntersection1 .isEmpty () ) {

                    setRotation (0);
                    setLocation (getX () -20,getY () +20);
                }
            }
        }
    }
    public int[] createIt(){
        if (getRotation () == 0) {
            int x = (getX () - 445)/40;
            int y = (getY () - 45)/40;
            Game.gameboard [x] [y] = 7;
            Game.gameboard [x] [y+1] = 7;
            Game.gameboard [x-1] [y+1] = 7;
            Game.gameboard [x+1] [y+1] = 7;
            getWorld().removeObject (this);
            int [] coords = {x,y,x,y+1,x-1,y+1,x+1,y+1};

            return coords;

        }
        else if (getRotation () == 90) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 7;
            Game.gameboard [x] [y-1] = 7;
            Game.gameboard [x] [y+1] = 7;
            Game.gameboard [x+1] [y] = 7;
            getWorld().removeObject (this);
            int[] coords = {x,y,x,y-1,x,y+1,x+1,y};

            return coords;

        }
        else if (getRotation () == 180) {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 7;
            Game.gameboard [x-1] [y] = 7;
            Game.gameboard [x+1] [y] = 7;
            Game.gameboard [x] [y+1] = 7;
            getWorld().removeObject (this);
            int[] coords = {x,y,x-1,y,x+1,y,x,y+1};

            return coords;

        }
        else {
            int x = ((getX () - 445)/40);
            int y = ((getY () - 45)/40);
            Game.gameboard [x] [y] = 7;
            Game.gameboard [x+1] [y+1] = 7;
            Game.gameboard [x+1] [y-1] = 7;
            Game.gameboard [x+1] [y] = 7;
            getWorld().removeObject (this);
            int[] coords = {x,y,x+1,y+1,x+1,y-1,x+1,y};

            return coords;
        }
    }
    public boolean checkDown(){
        if(getRotation()==0){
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
        else if(getRotation()==90){
            List checkIntersection1 = getObjectsAtOffset (20,40,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,80,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else if(getRotation()==180){
            List checkIntersection = getObjectsAtOffset (0,60,Blocks.class);
            List checkIntersection2 = getObjectsAtOffset (40,20,Blocks.class);
            List checkIntersection3 = getObjectsAtOffset (-40,20,Blocks.class);
            checkIntersection.remove (this);
            checkIntersection2.remove (this);
            checkIntersection3.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection2.isEmpty () && checkIntersection3.isEmpty ()){
                return true;

            }
        }
        else{
            List checkIntersection1 = getObjectsAtOffset (20,80,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,30,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection1.isEmpty () &&checkIntersection2.isEmpty ()){
                return true;

            }
        }
        return false;
    }
    public boolean checkLeft(){
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (-80,20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (-40,-20,Blocks.class);
            checkIntersection1.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () ){
                return true;
            }
        }

        else if (getRotation () == 90 ) {
            List checkIntersection = getObjectsAtOffset (-60,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-60,40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()){
                return true;

            }
        }
        else if (getRotation () == 180) {
            List checkIntersection = getObjectsAtOffset (-80,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (-40,20,Blocks.class);
            checkIntersection1.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () ){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (-60,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (-20,40,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (-20,-40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()){
                return true;
            }
        }

        return false;
    }
    public boolean checkRight(){
        if (getRotation () == 0) {
            List checkIntersection = getObjectsAtOffset (60,20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (40,-20,Blocks.class);
            checkIntersection1.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () ){
                return true;
            }
        }

        else if (getRotation () == 90 ) {
            List checkIntersection = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (20,40,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (20,-40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()){
                return true;
            }
        }
        else if (getRotation () == 180) {
            List checkIntersection = getObjectsAtOffset (60,-20,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (40,20,Blocks.class);
            checkIntersection1.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () ){
                return true;
            }
        }
        else {
            List checkIntersection = getObjectsAtOffset (60,-40,Blocks.class);
            checkIntersection.remove (this);
            List checkIntersection1 = getObjectsAtOffset (60,0,Blocks.class);
            checkIntersection1.remove (this);
            List checkIntersection2 = getObjectsAtOffset (60,40,Blocks.class);
            checkIntersection2.remove (this);
            if (checkIntersection.isEmpty () && checkIntersection1.isEmpty () && checkIntersection2.isEmpty ()){
                return true;

            }
        }
        return false;
    }
}
