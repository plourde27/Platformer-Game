import javax.swing.*;
import java.awt.*;

public class Block {
    int x, y, w, h, type;
    int[][] colors = {
        {220, 20, 20},
        {20, 220, 20},
        {20, 20, 220},
        {180, 180, 20},
        {220, 20, 220},
        {220, 110, 20},
        {20, 110, 20},
        {110, 110, 110},
        {20, 220, 220},
        {110, 220, 20}
    };
    
    boolean collected = false;
    
    public Block(int bx, int by, int bw, int bh, int t) {
        x = bx;
        y = by;
        w = bw;
        h = bh;
        type = t;
    }
    
    public void draw(Graphics gr) {
        if (type == 1) {
            gr.setColor(new Color(5, 5, 135, 225));
            gr.fillRect(x, y, w, h);
        }
        else if (type == 2) {
            gr.setColor(new Color(110, 110, 110, 200));
            gr.fillRect(x, y, w, h);
        }
        else {
            if (!collected) {
                gr.setColor(new Color(colors[type - 3][0], colors[type - 3][1], colors[type - 3][2], 155));
            }
            else {
                gr.setColor(new Color(colors[type - 3][0], colors[type - 3][1], colors[type - 3][2], 25));
            }
            gr.fillOval(x + 5, y + 5, 20, 20);
            gr.setColor(new Color(200, 200, 200, 200));
            gr.setFont(new Font("monospace", Font.PLAIN, 14));
            gr.drawString(Integer.toString(type - 2), x + 11, y + 20);
        }
        
        if (type == 2) {
            gr.setColor(new Color(185, 185, 25));
            gr.fillRect(x + 10, y + 12, 10, 13);
            //gr.fillTriangle(x + 8, y + 12, x + 15, y + 5, x + 22, y + 12);
        }
    }
    
    public boolean collidingWithPlayer(Player p) {
        if (x + w >= p.x && x <= p.x + p.w && y + h >= p.y && y <= p.y + p.h) {
            return true;
        }
        return false;
    }
}
