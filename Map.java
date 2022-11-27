package game;

import listener.*;
import wind.*;

import java.awt.*;
import javax.swing.*;

public class Map extends JPanel {
    Player p ;
    Fenetre fenetre;

    public Map(Fenetre fenetre){
        this.fenetre = fenetre;
        this.setSize(100,100);
        this.setBackground(Color.blue);
        this.setLayout(null);
        this.setBounds(0, 0, 100, 100);
        this.p = new Player(100, 100);
        this.add(this.p);
        if(this.fenetre.isServer())
        {
            System.out.println("Server");
            this.addMouseMotionListener(new MouseMove(this.p,this));
        }
        else
        {
            System.out.println("Client");
            Thread th = new Thread( new Clientlist(this));
            th.start();
        }
        this.setVisible(true);
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Fenetre getFenetre() {
        return fenetre;
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }
    
}
