import javax.swing.*;
import java.awt.*;

public class Player {
    double x;
    double y;
    boolean falling;
    double vy, vx;
    int w, h;
    double ox, oy;
    public Player() {
        x = 300;
        y = 200;
        w = 20;
        h = 20;
        falling = true;
        vy = 0;
        vx = 0;
    }
    
    public void update(Game g, Mouse m, Keyboard k) {
        
        if (k.keys[37]) {
            vx = -4.5;
        }
        else if (k.keys[39]) {
            vx = 4.5;
        }
        else {
            vx = 0;
        }
        
        ox = x;
        oy = y;
        vy += 0.5;
        y += vy;
        x += vx;
        
       // System.out.println(vx);
        falling = true;
        
        for (int i = 0 ; i < g.blocks.size() ; i++) {
            Block b = g.blocks.get(i);
            if (b.collidingWithPlayer(this)) {
                if (vy > 0 && oy + h <= b.y && ox + w > b.x && ox < b.x + b.w) {
                    vy = 0;
                    falling = false;
                    y = b.y - h;
                    oy = y;
                }
                else if (vy < 0 && oy >= b.y + b.h && ox + w > b.x && ox < b.x + b.w) {
                    vy = 0;
                    
                    y = b.y + g.blocks.get(i).h;
                    oy = y;
                }
            }
        }
        
        
        
        for (int i = 0 ; i < g.blocks.size() ; i++) {
            Block b = g.blocks.get(i);
            
            if (b.collidingWithPlayer(this)) {
                if (vx < 0 && ox >= b.x + b.w && y + h > b.y) {
                    x = b.x + b.w;
                    vx = 0;
                    ox = x;
                }
                else if (vx > 0 && ox + w <= b.x && y + h > b.y) {
                    x = b.x - w;
                    ox = x;
                    vx = 0;
                }
            }
        }
        
        if (k.keys[38] && !falling) {
            falling = true;
            vy = -12;
        }
        
        
    }
    
    public void draw(Graphics gr) {
        //gr.setColor(Color.rgb(1, 1, 1));
        gr.fillOval(((int) x), ((int) y), w, h);
    }
}
