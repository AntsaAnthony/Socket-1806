package frame;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;


public class Fenetre extends JFrame {
    Socket socket;
    boolean server;
    String titre;

    public Fenetre(Socket socket, boolean status,String titre){
        super(""+titre);
        this.socket = socket;
        this.server = status; 
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,450);
        Terrain terrain = new Terrain(this);
        this.add(terrain);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isServer() {
        return server;
    }

    public void setServer(boolean server) {
        this.server = server;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
}
