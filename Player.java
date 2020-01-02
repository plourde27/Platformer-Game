import javax.swing.*;
import java.awt.*;

public class Player {
    double x;
    double y;
    boolean falling;
    double vy, vx, ovy;
    int w, h;
    double ox, oy;
    int number = 1;
    //int[] nums = {14, 11, 8, 6, 4};
    int bonusPoints;
    boolean shouldExplode;
    int sz;
    int mode;
    
    public Player() {
        x = 300;
        y = 200;
        w = 20;
        h = 20;
        falling = true;
        vy = 0;
        vx = 0;
        bonusPoints = 0;
        shouldExplode = false;
        sz = 0;
        mode = 1;
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
        ovy = vy;
        vy += 0.5;
        y += vy;
        x += vx;
        
       // System.out.println(vx);
        falling = true;
        
        for (int i = 0 ; i < g.blocks.size() ; i++) {
            Block b = g.blocks.get(i);
            if (b.collidingWithPlayer(this)) {
                if (b.type == 1) {
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
                else if (b.type == 2) {
                    vy = -28;
                }
                else if (!b.collected) {
                    if (ovy > 0) {
                        number *= (b.type - 2);
                    }
                    else {
                        number += (b.type - 2);
                    }
                    b.collected = true;
                }
            }
        }
        
        for (int j = 0 ; j < g.blocks.size() ; j++) {
            Block c = g.blocks.get(j);
            
            if (c.collidingWithPlayer(this) && c.type == 1) {
                if (vx < 0 && ox >= c.x + c.w && y + h > c.y) {
                    x = c.x + c.w;
                    vx = 0;
                    ox = x;
                }
                else if (vx > 0 && ox + w <= c.x && y + h > c.y) {
                    x = c.x - w;
                    ox = x;
                    vx = 0;
                }
            }
        }
        
        if (k.keys[38] && !falling) {
            falling = true;
            vy = -12;
        }
        
        if (x < 0) {
            x = 0;
        }
        
        if (x >= 1050 - w && number == g.l.num) {
            g.l.l++;
            g.level++;
            g.blocks = g.l.generateLevel();
            x = 0;
            y = 670;
            number = 1;
        }
        else if (x >= 1050 - w) {
            x = 1050 - w;
        }
    }
    
    public void draw(Graphics gr) {
        gr.fillOval(((int) x), ((int) y), w, h);
        
        gr.setColor(new Color(200, 200, 200, 200));
        
        if (number >= 1000) {
            shouldExplode = true;
        }
        
        //gr.setFont(new Font("monospace", Font.PLAIN, nums[sz]));
        //gr.drawString(Integer.toString(number), (int) (x + 5), (int) (y + 15));
        
    }
    
    public void explode(Graphics gr) {
        System.out.println(sz);
        gr.setColor(new Color(220, 220, 0));
        gr.fillOval((int) (x - sz), (int) (y - sz), sz * 2, sz * 2);
        if (mode == 1) {
            sz += 16;
            if (sz > 800) {
                mode = 2;
            }
        }
        else {
            sz -= 16;
            if (sz <= 0) {
                sz = 0;
                shouldExplode = false;
                bonusPoints ++;
                number = 1;
                mode = 1;
            }
        }
    }
}
