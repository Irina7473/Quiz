package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class ConnectToClient implements  Runnable{
    private Socket clientSocket;
    private static BufferedWriter out;
    private static BufferedReader in;
    public ConnectToClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("������ ��������� - " + clientSocket.isConnected());
        } catch (IOException E) {
            System.out.println(E);
        }
    }

        @Override
    public void run() {
            try {
                Guiz guiz = new Guiz();
                int number = guiz.number;
                String msg="";
                int right =0, wrong=0;
                boolean cont=true;

                while (clientSocket.isConnected() && cont) {

                    for (Map<String, List<String>> q : guiz.vic.keySet()) {
                        if (cont) {
                            for (Map.Entry<String, List<String>> pair : q.entrySet()) {
                                msg = "1";
                                out.write(msg + "\n");
                                out.flush();
                                msg = "������:  " + pair.getKey();
                                int i = 1;
                                for (String opt : pair.getValue()) {
                                    msg += i + " - " + opt;
                                    i++;
                                }
                                msg += "��� �����: ";
                                out.write(msg + "\n");
                                out.flush();
                                System.out.println("������ ���������");
                            }
                            msg = in.readLine();
                            System.out.println("������� �����: " + msg);
                            String ans = guiz.vic.get(q).toString();
                            System.out.println(ans);
                            if (msg.equals(guiz.vic.get(q).toString())) {
                                out.write("true\n");
                                out.flush();
                                right++;
                            } else {
                                out.write("false\n");
                                out.flush();
                                wrong++;
                            }
                            number--;
                            msg = in.readLine();
                            System.out.println(msg);
                            if (msg.equals("stop") || number ==0) {
                                cont = false;
                            }
                        }
                    }
                }

                msg = "��� ���������: " + right + " ����������, " + wrong + " ������������ �������  ";
                if (number==0) msg += "��� ������� ��������� ��������";
                out.write( msg + "\n" );
                out.flush();
                clientSocket.close();
                System.out.println("������ ��������");
            }
            catch (IOException E){ System.out.println("Error: "+E);  }
    }
}
