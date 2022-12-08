package listener;

import game.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class LinkC implements Runnable{

    Terrain terrain ;
    DataInputStream dataIn = null;
    DataOutputStream dataOut = null;

    public LinkC(Terrain terrain)
    {
        this.terrain = terrain ;
    }
    @Override
    public void run() {
        try {
            receive();
            send(terrain.getBallS().getXBall(), terrain.getBallS().getYBall());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
        public void receive(){
            try {
                dataIn = new DataInputStream(terrain.getFenetre().getSocket().getInputStream());
                while(true){
                    String coordonne = dataIn.readUTF();   
                    // System.out.println("Miandry reponse");
                    // System.out.println(coordonne);
                    String[] tabCoordonne = coordonne.split(",");
                    double cosX = Double.valueOf(tabCoordonne[0]);
                    double sinY = Double.valueOf(tabCoordonne[1]);
    
                    int piqueX = Integer.valueOf(tabCoordonne[2]);
                    int piqueY = Integer.valueOf(tabCoordonne[3]);

                    int score1 = Integer.valueOf(tabCoordonne[4]);
                    int score2 = Integer.valueOf(tabCoordonne[5]);
                    terrain.setScore1(score1);
                    terrain.setScore2(score2);

                    terrain.setPiqueX(piqueX);
                    terrain.setPiqueY(piqueY);
    
                    terrain.getBallC().setXBall(cosX);
                    terrain.getBallC().setYBall(sinY);
                    terrain.getBallC().setLocation((int)cosX,(int) sinY);
                    terrain.getBallC().repaint();

                    // terrain.getBallS().setXBall(cosX);
                    // terrain.getBallS().setYBall(sinY);
                    // terrain.getBallS().setLocation((int)cosX,(int) sinY);
                    // terrain.getBallS().repaint();

                    terrain.repaint();
                    Thread.sleep(2);
                    //terrain.moveBall(terrain.getBallC());
                    System.out.println("iny ny sin"+terrain.getBallC().getXBall());
                    System.out.println("iny ny sin"+terrain.getBallC().getYBall());
                    //terrain.getBallC().setBouge(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
    }
    public void send(double xPos, double yPos){
        try {
             dataOut = new DataOutputStream(terrain.getFenetre().getSocket().getOutputStream());
             dataOut.writeUTF(xPos+","+yPos);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
}
}
