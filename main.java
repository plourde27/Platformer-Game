import javax.swing.*;
public class main{
    public static void main(String[] args){
        JFrame frame = new JFrame("DISPLAY");
        
        Mouse mouse = new Mouse();
     
        
        frame.addMouseListener(mouse);
        Keyboard keyboard = new Keyboard();
        frame.addKeyListener(keyboard);
        
        Game game = new Game();
        Display screen = new Display(game, mouse, keyboard);
        
        frame.add(screen);
        
        frame.setBounds(0,0,1000,720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(game).start();
        new Thread(new frameRateUpdater(30,screen)).start();
    }
}