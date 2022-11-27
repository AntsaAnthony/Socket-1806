package socket;

import wind.*;

import java.net.Socket;


public class Client 
{
    Socket socket;
    public Client(String IP, int port){
        connect(IP, port);
    }
    public void connect(String IP,int port){
        try {
            this.socket = new Socket(IP,port);
            new Fenetre(this.socket,false);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
