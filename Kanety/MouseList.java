package listener;
import game.*;

import java.awt.event.*;
import java.io.DataOutputStream;

public class MouseList implements MouseListener{
    Ball ball;
    Terrain terrain;
    DataOutputStream out;
    public MouseList(Ball ball,Terrain terrain){
        this.ball = ball;
        this.terrain=terrain;
    }
    public void mouseReleased(MouseEvent e){
        shooting(e,ball);
    }
    public void shooting(MouseEvent e,Ball b )
    {
        
        b.setDevX(1);
        b.setDevY(1);
        
        
        double ctOppose = e.getY() - b.getYBall()-10;
        double ctAdjacent = e.getX() - b.getXBall()-10;
        
        double tangente = (ctOppose/ctAdjacent);
        double degree = Math.atan(tangente);
        
        double sinY =  Math.sin(degree);
        double cosX =  Math.cos(degree);
        
        if(e.getX()<(b.getXBall()+10)&&cosX>0&&b.getDevX()>0&&b.getDevY()>0)
        {
            cosX *= -1;
            sinY *= -1;
        }
        b.setCosX(cosX);
        b.setSinY(sinY);
        b.setVitesse(1);   
    }   
    public Ball getBall() {
        return ball;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public Terrain getTerrain() {
        return terrain;
    }
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public void mouseClicked(MouseEvent e){ 
    }

    public void mouseExited(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    
    public void mousePressed(MouseEvent e){
        
    }
    
}
    



    