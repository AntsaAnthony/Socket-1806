package game;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
    int id;
    double x;
    double y;
    double vitesse =  0;
    int devX = 1;
    int devY = 1 ; 
    double cosX = 1 ;
    double sinY = 1 ;
    double deceleration = 0.0008; 
    boolean bouge = false;
    boolean police = false;
    
    public Ball(int id,int x,int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.setLayout(null);
        // this.setLocation(x, y);
        //this.setBackground(Color.green);
        this.setBounds(x,y,20,20);
        this.setVisible(true);
        
    }
    public void paint(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;
        Color DARK_BLUE = new Color(0,0,204);
        //System.out.println(this.getX());
        if (id==1){
            g.setColor(Color.red);
            g.fillOval(0,0,20,20);
        }
        if(id==2){
            g.setColor(DARK_BLUE);
            g.fillOval(0,0,20,20);
        }
        //g.setColor(Color.yellow);
    }
    public double getCosX() {
        return cosX;
    }
    public void setCosX(double cosX) {
        this.cosX = cosX;
    }
    public double getSinY() {
        return sinY;
    }
    public void setSinY(double sinY) {
        this.sinY = sinY;
    }
    public int getDevX() {
        return devX;
    }
    public void setDevX(int devX) {
        this.devX = devX;
    }
    public int getDevY() {
        return devY;
    }
    public void setDevY(int devY) {
        this.devY = devY;
    }
    public double getXBall() {
        return x;
    }
    public void setXBall(double x) {
        this.x = x;
    }
    public double getYBall() {
        return y;
    }
    public void setYBall(double y) {
        this.y = y;
    }
    
    public double getVitesse() {
        return vitesse;
    }
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }
    
    public boolean isBouge() {
        return bouge;
    }
    public void setBouge(boolean bouge) {
        this.bouge = bouge;
    }
    public double getDeceleration() {
        return deceleration;
    }
    public void setDeceleration(double deceleration) {
        this.deceleration = deceleration;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isPolice() {
        return police;
    }
    public void setPolice(boolean police) {
        this.police = police;
    }
    
}
