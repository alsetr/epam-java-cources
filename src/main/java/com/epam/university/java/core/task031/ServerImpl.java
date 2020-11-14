package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServerImpl implements Server {
    private final Deque<String> messages = new ConcurrentLinkedDeque<>();
    private final int port;
    private volatile boolean isWork;
    ServerSocket serverSocket;

    public ServerImpl(int port) {
        this.port = port;
    }

    @Override
    public String readMessage() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (messages.isEmpty()) {
            return "";
        }
        String pop = messages.pop();
        return pop;
    }

    @Override
    public void start() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                this.serverSocket = serverSocket;
                while (!serverSocket.isClosed()) {
                    Socket client = null;
                    try {
                        client = serverSocket.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Socket finalClient = client;
                    Thread thread = new Thread(() -> {
                        isWork = true;
                        try (BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(finalClient.getInputStream()))) {
                            while (isWork) {
                                if (bufferedReader.ready()) {
                                    String s = bufferedReader.readLine();
                                    messages.push(s);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    thread.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

    @Override
    public void stop() {
        isWork = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
