import java.util.*;

public class Game implements Runnable{
    double x, y;
    double vy;
    boolean falling;
    int level;
    Level l;
    Player player;
    ArrayList<Block> blocks;
    public Game(){
        x = 0;
        y = 0;
        vy = 0;
        falling = true;
        level = 1;
        player = new Player();
        l = new Level(level);
        blocks = l.generateLevel();
    }
    public void run(){
        while(true) {
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}