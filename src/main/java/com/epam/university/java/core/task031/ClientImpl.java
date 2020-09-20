package com.epam.university.java.core.task031;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClientImpl implements Client {


    @Override
    public void sendMessage(String message) {
//        String preParedMessage = message.replace(" ", "$");
//        InputStream is = new ByteArrayInputStream(preParedMessage.getBytes());
        InputStream is = new ByteArrayInputStream(Charset.defaultCharset().encode(message).array());
        new ByteArrayOutputStream();
        System.setIn(is);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
