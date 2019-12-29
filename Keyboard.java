import java.awt.event.*;
public class Keyboard extends KeyAdapter{
    boolean[] keys;
    public Keyboard() {
        keys = new boolean[200];
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        keys[key] = true;
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        keys[key] = false;
    }
}