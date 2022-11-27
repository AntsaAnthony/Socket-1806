package socket;

import wind.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Socket socket;
    public Server(int port){
        connect(port);
    }
    public void connect(int port){
        
        
        try {
            ServerSocket SSocket = new ServerSocket(port);
            this.socket = SSocket.accept();
            new Fenetre(this.socket,true);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
