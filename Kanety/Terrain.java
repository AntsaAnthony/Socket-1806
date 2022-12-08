package game;

import listener.*;
import frame.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.DataOutputStream;
import java.io.DataInputStream;



public class Terrain extends JPanel {
    int mouseX;
    int mouseY;
    // int tour = 1;
    int max = 100;
    int min = 400;
    int score1 = 0;
    int score2 = 0;
    int piqueX = 0; 
    int piqueY = 0;
    Ball b1 = null;
    Ball b2 = null;
    Ball ballS;
    Ball ballC;

    Fenetre fenetre;
    public Terrain(Fenetre fenetre){
        this.fenetre = fenetre;
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setSize(500,450);
         b1 = new Ball(1, 10, 10);
         b2 = new Ball(2, 450, 350);

         this.piqueX = (int)(Math.random()*(max-min+1)+min);
         this.piqueY = (int)(Math.random()*(max-min+1)+min); 
        this.add(b1);
        this.add(b2);
        if(this.fenetre.isServer()){
            this.ballS = b1;
            this.ballC = b2;
            System.out.println("SERVER");
            Thread th = new Thread(new LinkS(this));
            this.addMouseMotionListener(new MouseMotion(ballS,this));
            th.start();
            this.addMouseListener(new MouseList(ballS,this));
        }
        else{
            this.ballS = b2;
            this.ballC = b1;
            System.out.println("CLIENT");
            Thread th = new Thread(new LinkC(this));
            th.start();
            this.addMouseListener(new MouseList(ballS,this));
        }
            
    }
    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        try {
            Thread.sleep(2);
        } catch (Exception e) {
            // TODO: handle exception
        }
        g.setColor(Color.white);
        g.fillRect(piqueX, piqueY, 2, 20);
        g.fillRect(piqueX+30, piqueY, 2, 20);

        g.drawString(""+score1, 200, 25);
        g.drawString(" :  "+score2, 210, 25);

         moveBall(this.getBallS());
       if(b1.isBouge()==false){
           g.drawLine((int)b1.getXBall(), (int)b1.getYBall(), this.mouseX, this.mouseY);
       }
         mamono(b1, b2);
        // receive();
        repaint();
    }
    
    public void moveBall(Ball balle){
        if(balle.getVitesse()>0)
        {
            balle.setBouge(true);
        }
        if(balle.isBouge()==true)
        {
            double xPos = balle.getXBall();
            double yPos = balle.getYBall();
    
            balle.setVitesse(balle.getVitesse()-balle.getDeceleration());
            // System.out.println("zany ny vitesse en temps reel : "+balle.getVitesse());
            
            if(balle.getVitesse()<=0)
            {
                balle.setBouge(false);
            }
            
            xPos +=   balle.getVitesse() * balle.getDevX() * balle.getCosX();
            yPos +=   balle.getVitesse() * balle.getDevY() * balle.getSinY();
            balle.setXBall(xPos);
            balle.setYBall(yPos);
            this.send_info(xPos, yPos,this.piqueX,this.piqueY,this.score1,this.score2);
            // System.out.println(balle.getXBall()+"  "+balle.getYBall());
            balle.setLocation((int)xPos,(int) yPos);
            
            if(xPos<0 || xPos+20 >= this.getWidth()){
                balle.setDevX( balle.getDevX()*-1);
            }
            
            if(yPos<0 || yPos+20 >= this.getHeight()-60){
                balle.setDevY( balle.getDevY()*-1); 
            }
            if(xPos>=piqueX && xPos<=piqueX+30 && yPos>=piqueY && yPos<=piqueY+10 ){
                balle.setPolice(true);
                System.out.println("police ny kanety num : "+balle.getId());
                // balle.setDevY( balle.getDevY()*-1); 
            }
        }
    }

    public void mamono(Ball b1, Ball b2){
        if(b1.isPolice()==true){
            if(b1.getXBall()>=b2.getXBall()-5 && b1.getXBall()<=b2.getXBall()+10 && b1.getYBall()>=b2.getYBall()-5 && b1.getYBall()<=b2.getYBall()+10){
                b1.setVitesse(0);
                System.out.println("rip b2 eh");
                double xPos = Math.random()*(max-min+1)+min;
                double yPos = Math.random()*(max-min+1)+min;
                b2.setXBall(xPos);
                b2.setYBall(yPos);
                b2.setLocation((int)xPos, (int)yPos);
                score1++;
                System.out.println(score1);
                b1.setPolice(false);

            }
        }
        else if(b2.isPolice()==true){
            if(b2.getXBall()>=b1.getXBall()-5 && b2.getXBall()<=b1.getXBall()+10 && b2.getYBall()>=b1.getYBall()-5 && b2.getYBall()<=b1.getYBall()+10){
                b2.setVitesse(0);
                System.out.println("rip b2 eh");
                double xPos = Math.random()*(max-min+1)+min;
                double yPos = Math.random()*(max-min+1)+min;
                b1.setXBall(xPos);
                b1.setYBall(yPos);
                b1.setLocation((int)xPos, (int)yPos);
                score2++;
                b2.setPolice(false);
            }
        }
    }
    public void send_info(double xPos, double yPos, int piqueX, int piqueY, int score1, int score2){
        try {
            DataOutputStream send = new DataOutputStream(this.getFenetre().getSocket().getOutputStream());
            send.writeUTF(xPos+","+yPos+","+piqueX+","+piqueY+","+score1+","+score2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    // public void receive_info(){

    // }

    ///////GETTERS & SETTERS
    public int getMouseX() {
        return mouseX;
    }
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }
    public int getMouseY() {
        return mouseY;
    }
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }
    public Ball getBallS() {
        return ballS;
    }
    public void setBallS(Ball ball) {
        this.ballS = ball;
    }
    public Ball getBallC() {
        return ballC;
    }
    public void setBallC(Ball ball) {
        this.ballC = ball;
    }

    public int getScore1() {
        return score1;
    }
    public void setScore1(int score1) {
        this.score1 = score1;
    }
    public int getScore2() {
        return score2;
    }
    public void setScore2(int score2) {
        this.score2 = score2;
    }
    public Fenetre getFenetre() {
        return fenetre;
    }
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }
    public int getPiqueX() {
        return piqueX;
    }
    public void setPiqueX(int piqueX) {
        this.piqueX = piqueX;
    }
    public int getPiqueY() {
        return piqueY;
    }
    public void setPiqueY(int piqueY) {
        this.piqueY = piqueY;
    }
    
    
}
