import javax.swing.*;
import java.awt.*;
public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard keyboard;
    public Display(Game g, Mouse m, Keyboard k){
        game = g;
        mouse = m;
        keyboard = k;
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(5, 5, 135, 255));
        
        game.player.update(game, mouse, keyboard);
        game.player.draw(g);
        
        for (int i = 0 ; i < game.blocks.size() ; i++) {
            game.blocks.get(i).draw(g);
        }
    }
}