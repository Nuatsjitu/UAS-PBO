
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.*;
import java.util.*;
import java.util.ArrayList;

public class Game extends World
{
    public static int[][] gameboard= new int[10][18];
    public Shape nextBlock;
    public Shape currentBlock;
    private int nextShape=6;
    Counter scorecount=new Counter("Score:");
    Counter hiScore = new Counter("High Score:");
    public int delayTime=40;
    public boolean gameDone=false;
    public boolean gameStarted=false;
    Greenfoot thing=new Greenfoot();
    public int[] last10 = new int[10];
    public boolean creditsExist=false;
    public Explanation instructions=new Explanation();
    public ScoreBoard credits = new ScoreBoard();
    public boolean onbugs=false;
    public int scoreCompleted=0;
    public int level=1;
    public int currentDelayTime=40;
    GreenfootSound backgroundMusic = new GreenfootSound ("Level 1.mp3");
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {
        super(850,770,1);

        prepare();
    }

    public void act(){
        moveThatBlock();

    }

    public void makeIt(){
        if((getObjectsAt(605,45,Blocks.class)).isEmpty()&&(getObjectsAt(605,45,Shape.class)).isEmpty()){
            convertIntoBlocks(currentBlock.createIt());
            lineCheck();
            moveIntoPlay();
            if(scorecount.getValue()>hiScore.getValue()){
                hiScore.setValue(scorecount.getValue());
            }
        }
        else if(gameDone==false){
            gameOver();
            gameDone=true;
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        initializeWorld();
    }

    public void moveIntoPlay(){
        currentBlock=nextBlock;
        String spawner=""+nextShape;
        if(spawner.indexOf("0")>=0){
            currentBlock.setLocation(625,65);
        }
        else if(spawner.indexOf("1")>=0){
            currentBlock.setLocation(605,65);
        }
        else if(spawner.indexOf("2")>=0){
            currentBlock.setLocation(605,65);
        }
        else if(spawner.indexOf("3")>=0){
            currentBlock.setLocation(625,85);
        }
        else if(spawner.indexOf("4")>=0){
            currentBlock.setLocation(625,85);
        }
        else if(spawner.indexOf("5")>=0){
            currentBlock.setLocation(625,45);
        }
        else if(spawner.indexOf("6")>=0){
            currentBlock.setLocation(605,65);
        }
        spawner();
    }

    public void delays(){
        if (delayTime >0){ 
            delayTime--;
        }
        else{
            if(scoreCompleted>=300){
                scoreCompleted-=300;
                if(level==1){
                    level=2;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 2.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==2){
                    level=3;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 3.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==3){
                    level=4;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 4.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==4){
                    level=5;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 5.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==5){
                    level=6;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 6.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==6){
                    level=7;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 7.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==7){
                    level=8;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 8.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==8){
                    level=9;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 9.mp3");
                    backgroundMusic.playLoop();
                }
                else if(level==9){
                    level=10;
                    backgroundMusic.stop ();
                    backgroundMusic = new GreenfootSound  ("Level 10.mp3");
                    backgroundMusic.playLoop();
                }
                
                if(level==10){
                    currentDelayTime-=2;
                }
            }
            delayTime=currentDelayTime;
            if(currentBlock.checkDown()){
                currentBlock.setLocation(currentBlock.getX(),currentBlock.getY()+40);
            }
            else{
                makeIt();
            }
        }
    }

    public void moveThatBlock(){
        if (thing.isKeyDown("1")) {
            reset();
            thing.delay(10);
        }
        if(thing.isKeyDown("enter")&&!gameStarted) {
            removeObject(instructions);
            gameStarted=true;
        }
        else if(thing.isKeyDown("4")&&!onbugs&&!gameStarted) {
            instructions.bugs();
            onbugs=true;
            thing.delay(20);
        }
        else if(thing.isKeyDown("4")&& onbugs&&!gameStarted) {
            instructions.window();
            onbugs=false;
            thing.delay(20);
        } 

        if(!gameDone&&gameStarted){
            delays();
            if (thing.isKeyDown("down")) {

                boolean checkIntersection = currentBlock.checkDown();
                if (checkIntersection == true){
                    currentBlock.setLocation (currentBlock.getX (),currentBlock.getY ()+40 );
                }

                //This delay so the it the block doesnt move too fast
                thing.delay (2);

            }

            //Hard Drops the shape
            if (thing.isKeyDown("space")) {

                boolean checkIntersection = currentBlock.checkDown();

                //keeps dropping the shape until it hits something.
                while (checkIntersection == true) {
                    checkIntersection = currentBlock.checkDown();
                    if (checkIntersection == true){
                        currentBlock.setLocation (currentBlock.getX (),currentBlock.getY ()+40 );

                    }
                    else{
                        makeIt();
                    }
                }
                thing.delay (15);
            }

            //Rotates the Shape
            if (thing.isKeyDown("up")) {
                currentBlock.rotate ();
                delayTime-=8;
                thing.delay (8);
            }
            //Checks if it is possible to move shape left, if it is, then move it
            else if (thing.isKeyDown ("left")) {
                boolean checkIntersection = currentBlock.checkLeft();
                if (checkIntersection == true){

                    currentBlock.setLocation (currentBlock.getX ()-40,currentBlock.getY () );
                }
                delayTime-=2;
                thing.delay (3);
            }

            //Checks if it is possible to move shape right, if it is, then move it
            else if (thing.isKeyDown("right")) {

                boolean checkIntersection = currentBlock.checkRight();
                if (checkIntersection == true){

                    currentBlock.setLocation (currentBlock.getX ()+40,currentBlock.getY () );
                }
                delayTime-=2;
                thing.delay (3);
            }
        }
        else{
            if (thing.isKeyDown("2")) {
                creditsExist= credits.makeCredits(creditsExist);
                if(creditsExist){
                    addObject(credits, getWidth()/2,getHeight()/2);
                }
                thing.delay(20);
            }
        }
    }

    public void convertIntoBlocks(int[]x){
        for (int h = 0; h < 4; h++) {
            int i;
            int j;

            if (h==0) {
                i = x [0];
                j = x [1];
            }
            else if (h==1) {
                i = x [2];
                j = x [3];
            }
            else if (h==2) {
                i = x [4];
                j = x [5];
            }
            else {
                i = x [6];
                j = x [7];
            }
            //Draws the blocks if needed.
            if (gameboard [i] [j]== 6) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , L.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)) ; 
                }
                addObject(new L (), i * 40 + 445, j * 40 + 45); 
            }

            else if (gameboard[i] [j] == 2) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Ls.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)) ; 
                }
                addObject(new Ls (), i * 40 + 445, j * 40 + 45); 
            }

            else if (gameboard[i] [j] == 3) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , R.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                }
                addObject(new R (), i * 40 + 445, j * 40 + 45); 
            }

            else if (gameboard [i] [j]== 4) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , S1.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                }
                addObject(new S1 (), i * 40 + 445, j * 40 + 45); 
            }

            else if (gameboard [i] [j]== 5) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , S2.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class));
                }
                addObject(new S2 (), i * 40 + 445, j * 40 + 45); 
            }

            else if (gameboard [i] [j]== 1) {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , C.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class));
                }
                addObject(new C (), i * 40 + 445, j * 40 + 45); 
            }

            else {
                if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , T.class)).isEmpty ())) {
                    continue;
                }
                else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                    removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class));
                }
                addObject(new T (), i * 40 + 445, j * 40 + 45); 
            }
        }
    }

    public void createBoarder (){

        for (int i = 0; i < 19; i++) {
            addObject(new Boarder (), 405, i * 40 + 45); 
        }
        for (int i = 0; i < 19; i++) {
            addObject(new Boarder (), 845, i * 40 + 5); 
        }
        for (int i = 0; i < 11; i++) {
            addObject(new Boarder (), i * 40 + 405, 5); 
        }
        for (int i = 0; i < 11; i++) {
            addObject(new Boarder (), i * 40 + 405, 765); 
        }

    }

    public void lineCheck(){
        int linesCleared = 0; 

        //Loops through the array for filled line
        for (int i = 0 ; i < 18; i++) {
            boolean lineIsFull = true;
            for (int j = 0; j < 10; j++) {
                if (gameboard [j] [i] == 0) {
                    lineIsFull = false;
                    break;
                }
            }
            if (lineIsFull == false) {
                continue;
            }
            //If there is a filled line, clear the line and move all the lines down
            else if (lineIsFull == true) {
                linesCleared++;
                for (int k = i; k >= 0; k--) {
                    for (int l = 0; l < 10; l++) {
                        if (k == 0) {
                            gameboard [l] [k] = 0;
                        }
                        else {
                            gameboard [l] [k] = gameboard [l] [k-1];
                        }
                    }
                }
            }
        }
        if(linesCleared>0){
            scoreCompleted+=scorecount.addPoints(linesCleared);
            redraw();
        }

    }

    public void redraw(){
        for(int i=0; i<10;i++){
            for(int j=0; j<18;j++){
                if(gameboard [i] [j]== 0){
                    if ((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ()) {
                        continue;
                    }
                    else{
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                }
                else    if (gameboard [i] [j]== 6) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , L.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new L (), i * 40 + 445, j * 40 + 45); 
                }

                else if (gameboard[i] [j] == 2) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Ls.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new Ls (), i * 40 + 445, j * 40 + 45); 
                }

                else if (gameboard[i] [j] == 3) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , R.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new R (), i * 40 + 445, j * 40 + 45); 
                }

                else if (gameboard [i] [j]== 4) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , S1.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new S1 (), i * 40 + 445, j * 40 + 45); 
                }

                else if (gameboard [i] [j]== 5) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , S2.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new S2 (), i * 40 + 445, j * 40 + 45); 
                }

                else if (gameboard [i] [j]== 1) {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , C.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new C (), i * 40 + 445, j * 40 + 45); 
                }

                else {
                    if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , T.class)).isEmpty ())) {
                        continue;
                    }
                    else if (!((getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)).isEmpty ())){
                        removeObjects(getObjectsAt (i * 40 + 445, j * 40 + 45 , Blocks.class)); 
                    }
                    addObject(new T (), i * 40 + 445, j * 40 + 45); 
                }
            }
        }
    }

    public void initializeWorld(){
        Background background=new Background();
        addObject(new Border(),625,385);
        addObject(background,625,385);
        addObject(scorecount,200,730);
        addObject(new NextBlockBox(), 200, 100);
        addObject(new ScoreBoard(last10),200,430);
        createBoarder();
        firstBlockSpawn();
        spawner();
        instructions.window();
        addObject(instructions,getWidth()/2,getHeight()/2);
        backgroundMusic.playLoop();
    }

    public void spawner(){
        nextShape=thing.getRandomNumber(7);
        String spawner=""+nextShape;
        if(spawner.indexOf("0")>=0){
            nextBlock=new Cube();
            addObject(nextBlock, 200, 100);
        }
        else if(spawner.indexOf("1")>=0){
            nextBlock=new Tshape();
            addObject(nextBlock,200,100);
        }
        else if(spawner.indexOf("2")>=0){
            nextBlock=new Lshape();
            addObject(nextBlock,200,100);
        }
        else if(spawner.indexOf("3")>=0){
            nextBlock=new Stair1();
            addObject(nextBlock,200,100);
        }
        else if(spawner.indexOf("4")>=0){
            nextBlock=new Stair2();
            addObject(nextBlock,200,100);
        }
        else if(spawner.indexOf("5")>=0){
            nextBlock=new Line();
            addObject(nextBlock,200,100);
        }
        else if(spawner.indexOf("6")>=0){
            nextBlock=new ReverseLshape();
            addObject(nextBlock,200,100);
        }

    }

    public void firstBlockSpawn(){
        Greenfoot thing=new Greenfoot();
        String spawner=""+thing.getRandomNumber(6);
        if(spawner.indexOf("0")>=0){
            currentBlock=new Cube();
            addObject(currentBlock, 625, 65);
        }
        else if(spawner.indexOf("1")>=0){
            currentBlock=new Tshape();
            addObject(currentBlock,605,65);
        }
        else if(spawner.indexOf("2")>=0){
            currentBlock=new Lshape();
            addObject(currentBlock,605,65);
        }
        else if(spawner.indexOf("3")>=0){
            currentBlock=new Stair1();
            addObject(currentBlock,625,85);
        }
        else if(spawner.indexOf("4")>=0){
            currentBlock=new Stair2();
            addObject(currentBlock,625,85);
        }
        else if(spawner.indexOf("5")>=0){
            currentBlock=new Line();
            addObject(currentBlock,625,45);
        }
        else if(spawner.indexOf("6")>=0){
            currentBlock=new ReverseLshape();
            addObject(currentBlock,605,65);
        }

    }

    public void gameOver(){
        addObject(new ScoreBoard("Game Over",scorecount.getValue(), hiScore.getValue ()), getWidth()/2, getHeight()/2);
        backgroundMusic.stop(); 
    }

    public void reset(){
        removeObjects (getObjects(null));
        for(int i=0; i<10;i++){
            for(int j=0; j<18;j++){
                gameboard[i][j]=0;
            }
        }
        for(int i=9;i>0;i--){
            last10[i]=last10[i-1];
        }
        last10[0]=scorecount.getValue();
        redraw();
        backgroundMusic.stop();
        backgroundMusic = new GreenfootSound  ("Level 1.mp3");
        scorecount.setValue(0);
        initializeWorld();
        level=1;
        currentDelayTime=40;
        scoreCompleted=0;
        gameDone=false;
        gameStarted=false;
    }
}
