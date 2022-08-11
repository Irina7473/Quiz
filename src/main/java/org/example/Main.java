package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello server");
        Server server = new Server();
        try {  server.start();  }
        catch (IOException e){ System.out.println(e);  } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");

    }
}