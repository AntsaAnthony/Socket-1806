package socket;

import frame.*;

import java.net.Socket;
import javax.swing.JOptionPane;



public class Client 
{
    Socket socket;
    public Client(){
        String ip = JOptionPane.showInputDialog("Entrer adresse IP");
        String t = JOptionPane.showInputDialog("Entrer le port de l'Host");
        int port = Integer.valueOf(t);
        connect(ip, port);
    }
    public void connect(String IP,int port){
        try {
            this.socket = new Socket(IP,port);
            new Fenetre(this.socket,false,"kanety Client");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
