import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard keyboard;
    String scene = "Play";
    int[][] pos;
    double[] fac;
    int xpos;
    
    
    public Display(Game g, Mouse m, Keyboard k){
        game = g;
        mouse = m;
        keyboard = k;
        pos = new int[50][5];
        fac = new double[50];
        
        for (int i = 0 ; i < pos.length ; i++) {
            pos[i][0] = (int) (Math.random() * 1080);
            pos[i][1] = (int) (Math.random() * 750);
            pos[i][2] = (int) (Math.random() * 9);
            pos[i][3] = (int) (Math.random() * 200 + 80);
            fac[i] = Math.random() * 3 - 1.5;
        }
    }
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (scene.equals("Menu")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1080, 740);
            g.setColor(new Color(200, 200, 200, 40));
            for (int i = 0 ; i < pos.length ; i++) {
                g.setFont(new Font("monospace", Font.PLAIN, pos[i][3]));
                g.drawString(Integer.toString(pos[i][2]), (int) (((pos[i][0] + xpos) * fac[i] + 4000) % 2000 - 500), pos[i][1]);
            }
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 70));
            g.drawString("Number Platformer", 200, 170);
            g.setFont(new Font("Avenir", Font.PLAIN, 15));
            g.drawString("Made by Xavier Plourde (plourde27)", 400, 195);
            g.setFont(new Font("Avenir", Font.PLAIN, 38));
            g.drawString("Click to Play", 380, 450);
            if (mouse.clicked) {
                scene = "Play";
            }
            xpos += 3;
        }
        else if (scene.equals("Play")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1080, 740);
            
            g.setColor(new Color(5, 5, 135, 255));
            
            for (int i = 0 ; i < game.blocks.size() ; i++) {
                game.blocks.get(i).draw(g);
            }
            
            game.player.update(game, mouse, keyboard);
            game.player.draw(g);
            
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("monospace", Font.PLAIN, 36));
            g.drawString("Level " + game.level, 130, 120);
            g.drawString("Your Number: " + game.player.number, 710, 120);
            g.drawString("Bonus Points: " + game.player.bonusPoints, 340, 120);
            
            g.setColor(new Color(5, 5, 185, 105));
            if (game.player.number == game.l.num) {
                g.setColor(new Color(5, 5, 185, 25));
            }
            
            g.fillRect(1050, 660, 30, 30);
            
            g.setFont(new Font("monospace", Font.PLAIN, 15));
            
            g.setColor(new Color(0, 0, 0));
            
            g.drawString(Integer.toString(game.l.num), 1052, 681);
            
            
            if (game.player.shouldExplode) {
                game.player.explode(g);
            }
        }
    }
}