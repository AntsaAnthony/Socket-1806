package listener;
import game.*;

import java.awt.event.*;

public class MouseMotion implements MouseMotionListener{
    Ball boule;
    Terrain terrain;
    public MouseMotion(Ball boule,Terrain terrain){
        this.boule=boule;
        this.terrain=terrain;
    }
    public void mouseMoved(MouseEvent e){
       // System.out.println("coucou"+e.getX()+" "+e.getY());
       
       //    System.out.println("x : "+terrain.getMouseX()+" y : "+terrain.getMouseY());
       //    boule.setXBall(e.getX());
       //    boule.setYBall(e.getY());
    //    System.out.println("x : "+boule.getXBall());

}
    public void mouseDragged(MouseEvent e){
        terrain.setMouseX(e.getX());
        terrain.setMouseY(e.getY());
    }
}
