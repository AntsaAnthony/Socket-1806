package listener;
import game.*;

import java.awt.event.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MouseMove implements MouseMotionListener{
    Player p;
    Map map;
    public MouseMove(Player p,Map map){
        this.p=p;
        this.map=map;
    }
    public void mouseMoved(MouseEvent e){
        DataOutputStream dataOut = null;
        try {
            dataOut = new DataOutputStream(map.getFenetre().getSocket().getOutputStream());
        } catch (Exception E) {
            System.out.println(E);
        }
    //   DataInputStream dataIn = new DataInputStream(map.getFenetre().getSocket().getInputStream());
        int xPos = e.getX(); 
        int yPos = e.getY();
       p.setMouseX(xPos);
       p.setMouseY(xPos);
       p.setLocation(xPos, yPos);
       System.out.println("Mietsika xPos ="+xPos);
       System.out.println("Mietsika yPos ="+yPos);

       try {
        dataOut.writeUTF(xPos+","+yPos);
        p.repaint();
        System.out.println("Lasaaa");

       } catch (Exception e1) {
        System.out.println(e1);
       }
       //System.out.println("tsy "+p.getMouseX()+" "+p.getMouseY());

    }
    public void mouseDragged(MouseEvent e){
    }
}
