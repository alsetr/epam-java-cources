package com.epam.university.java.core.task031;

public class Task031Impl implements Task031 {
    String message = "";

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Client createClient() {
        return new ClientImpl();
    }

    @Override
    public Server createServer() {
        return new ServerImpl();
    }
}
