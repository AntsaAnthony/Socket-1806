package game;

import listener.*;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {
    int x;
    int y;
    int MouseX;
    int MouseY;

    public Player(int x,int y){
        this.x = x;
        this.y = y;
        this.setBackground(Color.gray);
        this.setLayout(null);
        this.setBounds(x, y, 50, 100);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        Color DARK_BLUE = new Color(0,0,204);
        g.setColor(DARK_BLUE);
        g.fillRect(0,0, 20, 30);
       // this.setBounds(MouseX, MouseY, 50, 100);
       // System.out.println(MouseX+"  "+MouseY);
       // repaint();
    }

    public int getPX() {
        return x;
    }

    public void setPX(int x) {
        this.x = x;
    }

    public int getPY() {
        return y;
    }

    public void setPY(int y) {
        this.y = y;
    }
    public int getMouseX() {
        return MouseX;
    }
    public void setMouseX(int mouseX) {
        MouseX = mouseX;
    }
    public int getMouseY() {
        return MouseY;
    }
    public void setMouseY(int mouseY) {
        MouseY = mouseY;
    }
    


}
