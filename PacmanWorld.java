import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;
import java.util.Scanner;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    
    private static final int COORDINATE_Y = 40;
    private static final int COORDINATE_X =28;
    private static final int INCREASEX = 28;
    private static final int INCREASEY = 28;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()throws Exception
    {    
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() throws Exception
    {

        addCharacters();
    }
    
     private void addCharacters() throws Exception{
        int pacx=0, pacy=0;
         Wall wall = new Wall();
        int withWall = wall.getImage().getWidth();
        
        Banana banana = new Banana();
        int withBanana = banana.getImage().getWidth();
        
        BigBall bigBall = new BigBall();
        int withBigBall = bigBall.getImage().getWidth();
        
        SmallBall smallBall = new SmallBall();
        int withSmallBall = smallBall.getImage().getWidth();
        
        Cherry cherry = new Cherry();
        int withCherry = cherry.getImage().getWidth();
        
        Strawberry strawberry = new Strawberry();
        int withStrawberry = strawberry.getImage().getWidth();
        
        int x,y=COORDINATE_Y;
        
        String text;
        File doc = new File("D:\\Documentos\\Documentos Uni 4to Semestre\\TOO\\Pacman\\PACMAN\\PacmanLevel1.txt");
        Scanner obj = new Scanner(doc);

        while (obj.hasNextLine()) {
            x=COORDINATE_X;
            y+= INCREASEY;
            text = obj.nextLine();
            for (char c : text.toCharArray()) {
                x+=INCREASEX;
                switch (c) {
                    case 'X':
                        wall = new Wall();
                        addObject(wall,x,y);
                        break;
                    case 'b':
                        smallBall = new SmallBall();
                        addObject(smallBall,x,y);
                        break;
                    case 'B':
                        bigBall = new BigBall();
                        addObject(bigBall,x,y);
                        break;
                    case 'C':
                        cherry = new Cherry();
                        addObject(cherry,x,y);
                        break;
                    case 'S':
                        strawberry = new Strawberry();
                        addObject(strawberry,x,y);
                        break;
                    case 'P':
                        pacx=x;
                        pacy=y;
                        break;
                }
            }
        }
        PacmanHud hud = new PacmanHud();
        addObject(hud,0,0);
        
        Pacman pacman = new Pacman(hud);
        addObject(pacman,pacx,pacy);
}
}