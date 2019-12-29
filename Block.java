import javax.swing.*;
import java.awt.*;

public class Block {
    int x, y, w, h;
    
    public Block(int bx, int by, int bw, int bh) {
        x = bx;
        y = by;
        w = bw;
        h = bh;
    }
    
    public void draw(Graphics gr) {
        gr.fillRect(x, y, w, h);
    }
    
    public boolean collidingWithPlayer(Player p) {
        if (x + w >= p.x && x <= p.x + p.w && y + h >= p.y && y <= p.y + p.h) {
            return true;
        }
        return false;
    }
}
