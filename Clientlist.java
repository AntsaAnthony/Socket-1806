package listener;

import game.*;
import java.io.DataInputStream;

public class Clientlist implements Runnable{

    Map map ;
    public Clientlist(Map map){
        this.map = map;
    }
    @Override
    public void run() {
        DataInputStream dataIn = null;
        try {
            dataIn = new DataInputStream(map.getFenetre().getSocket().getInputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        while(true){
            try {
                
                System.out.println("Miandry reponse");
                String coordonne = dataIn.readUTF();
                System.out.println(coordonne);
                String[] tabCoordonne = coordonne.split(",");
                int Xpos = Integer.valueOf(tabCoordonne[0]);
                int Ypos = Integer.valueOf(tabCoordonne[1]);

               // map.getP().setPX(Xpos);
               // map.getP().setPY(Ypos);
                map.getP().setLocation(Xpos, Ypos);
            
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }

    }


    
}
