package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private boolean isRunning;
    private BufferedReader br;
    private List<String> message = new ArrayList<>();
    Thread s;



    public ServerImpl(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    synchronized public String readMessage() {
        if (message.size() == 0) {
            return "";
        }
        return message.get(message.size() - 1);
    }

    @Override
    synchronized public void start(){
        new Thread(() -> {
//                new Thread(() ->{
                    while (!serverSocket.isClosed()) {
                        try {
                            clientSocket = serverSocket.accept();
                            System.out.println("accept");
                            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            String m = br.readLine().strip();
                            System.out.println(m);
                            message.add(m);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                }).start();

        }).start();
    }


    @Override
    public void stop() {
        try {
            serverSocket.close();
            clientSocket.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
