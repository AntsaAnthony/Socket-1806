package wind;

import game.*;

import java.awt.*;
import java.net.Socket;

import javax.swing.*;
public class Fenetre extends JFrame {
    Socket socket;
    boolean isServer ;
    public Fenetre(Socket socket,boolean status){
        super("game");
        this.isServer = status; 
        this.socket = socket;
        this.setSize(600,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // this.setLayout(null);
        Map map = new Map(this);
        this.add(map);
        this.setVisible(true);
    }

    public Socket getSocket(){
        return this.socket;
    }
    public void setSocket(Socket so){
        this.socket = so;
    }

    public boolean isServer(){
        return this.isServer;
    }
}
