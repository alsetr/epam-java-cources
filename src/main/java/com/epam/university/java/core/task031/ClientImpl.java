package com.epam.university.java.core.task031;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {
    private int port;
    OutputStream outputStream;
    Socket socket;

    public ClientImpl(int port) {
        this.port = port;
    }

    @Override
    public void sendMessage(String message) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(message);
        printWriter.flush();
    }

    @Override
    public void start() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), port);
            outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
