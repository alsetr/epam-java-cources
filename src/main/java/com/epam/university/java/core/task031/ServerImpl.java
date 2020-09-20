package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ServerImpl implements Server {
    Deque<String> messages = new ArrayDeque<>();
    boolean isRunning;

    @Override
    public String readMessage() {
        DataInputStream in = new DataInputStream(System.in);
        String s = "";
        try {
            s = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        while (scanner.hasNextLine()) {
//            sb.append(scanner.nextLine());
//        }
        return s;
    }

    @Override
    public void start() {
        isRunning = true;

    }

    @Override
    public void stop() {
        isRunning = false;

    }
}
