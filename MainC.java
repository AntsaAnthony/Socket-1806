package main;

import wind.*;
import socket.*;

public class MainC{
    public static void main(String[] args) {
        //new Server(5555);
        new Client("localhost",5555);
    }
}