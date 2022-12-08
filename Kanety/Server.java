package socket;

import frame.*;

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
            System.out.println("miandry kil");
            this.socket = SSocket.accept();
            System.out.println("tafiditra ny kil");
            new Fenetre(this.socket,true,"kanety Server");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
