import java.util.*;

public class Level {
    int l;
    
    public Level(int lv) {
        l = lv;
    }
    
    public ArrayList<Block> generateLevel() {
        ArrayList<Block> blocks = new ArrayList<Block>();
        
        String[] grid = new String[18];
        
        switch (l) {
            case 1:
                String[] g = {
                    "xxxxxxxxxxxxxxxxxxxxxxxxx",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x.......................x",
                    "x...........x.....x.....x",
                    "x.....x..............x..x",
                    "x......xxxx...x.........x",
                    "x.......................x",
                    "x..................xxx..x",
                    "x..............x........x",
                    "x...........x...........x",
                    "x.......................x",
                    "xxxxxxxxxxxxxxxxxxxxxxxxx"};
                grid = g;
        }
        
        String let;
        for (int i = 0 ; i < 18 ; i++) {
            for (int j = 0 ; j < 25 ; j++) {
                let = grid[i].substring(j, j+1);
                if (let.equals("x")) {
                    blocks.add(new Block(j * 40, i * 40, 40, 40));
                }
            }
        }
        
        
        return blocks;
    }
}
