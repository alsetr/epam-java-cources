package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    static final int PORT = 8000;
    @Override
    public Client createClient() {
        return new ClientImpl(PORT);
    }

    @Override
    public Server createServer() {
        return new ServerImpl(PORT);
    }
}
