import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.util.ArrayList;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    public static final int width = 530;
    public static final int height = 450;
    public static final float fontsize= 30.0f;
    

    public ScoreBoard(String title,int score, int highscore){
        makeScore(title, "Score:",score,highscore);
    }

    public ScoreBoard( int[] scores){
        makelist(scores);
        
    }
     public ScoreBoard(){
        
        
    }
    public boolean makeCredits(boolean bol){
         if(!bol){
        GreenfootImage board=new GreenfootImage(width,height);
        board.setColor(new Color(0, 0, 0, 160));
        board.fillRect(0, 0, width, height);
        board.setColor(new Color(255, 255, 255, 100));
        board.fillRect(5, 5, width-10, height-10);
        Font font = board.getFont();
        font = font.deriveFont(fontsize);
        board.setFont(font);
        board.setColor(Color.WHITE);
        board.drawString("Credits",80,120);
        board.drawString("Jake Wong",80, 195);
        board.drawString("William Wang",80,265);
        board.drawString("Bryan Chung",80, 335);
        setImage(board);
        return true;
       }
       else{
           getWorld().removeObject(this);
           return false;
        }
    }

    public void makeScore(String header, String title,int score, int highscore){
        GreenfootImage board=new GreenfootImage(width,height);
        board.setColor(new Color(0, 0, 0, 160));
        board.fillRect(0, 0, width, height);
        board.setColor(new Color(255, 255, 255, 100));
        board.fillRect(5, 5, width-10, height-10);
        Font font = board.getFont();
        font = font.deriveFont(fontsize);
        board.setFont(font);
        board.setColor(Color.WHITE);
        board.drawString(header, 80, 120);
        board.drawString(title + score, 80, 195);
        board.drawString("The hi-Score: " + highscore, 80, 270);
        board.drawString("Press 1 to play again", 80, 345);
        board.drawString("Press 2 to view credits", 80, 385);
        setImage(board);
    }

    public void makelist( int[] scores){
        GreenfootImage board=new GreenfootImage(width/2,height);
        board.setColor(new Color(0, 0, 0, 160));
        board.fillRect(0, 0, width/2, height);
        board.setColor(new Color(255, 255, 255, 100));
        board.fillRect(5, 5, width/2-10, height-10);
        Font font = board.getFont();
        font = font.deriveFont(fontsize);
        board.setFont(font);
        board.setColor(Color.WHITE);
        
        for(int i =0;i<10;i++){
            board.drawString(scores[i]+"",120,135+30*i);
        }
        board.drawString("Recent Scores ", 40, 60);
        setImage(board);
    }
}
