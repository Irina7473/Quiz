package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedWriter out;
    private static BufferedReader in;
    public void start() throws IOException, ClassNotFoundException {
        server = new ServerSocket(8080);
        System.out.println("Start server to port 8080");

        while (true) {
            ConnectToClient connect =new ConnectToClient(server.accept());
            new Thread(connect).start();
        }

    }
}
