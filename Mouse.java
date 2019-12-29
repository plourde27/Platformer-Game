import java.awt.event.*;
public class Mouse implements MouseListener{
    boolean clicked;
    public Mouse(){
        clicked = false;
    }
    public void mousePressed(MouseEvent e){
        clicked = true;
    }
    public void mouseReleased(MouseEvent e){
        clicked = false;
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
}