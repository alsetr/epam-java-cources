package com.epam.university.java.core.task031;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientImpl implements Client {
    private int port;
    private Socket socket;
    private PrintWriter writer;

    public ClientImpl(int port) {
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {
        writer.print(message);
        writer.flush();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start() {
        try {
            socket = new Socket("localhost", port);
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        try {
            socket.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
