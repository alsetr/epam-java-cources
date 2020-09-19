package com.epam.university.java.core.task043;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task043Impl implements Task043 {
    private final HashMap<Character, String> encoder = new HashMap<>();
    private final HashMap<String, Character> decoder = new HashMap<>();

    @Override
    public String encode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        hashMapInitialization();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            sb.append(encoder.get(sourceString.charAt(i)));
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }

    @Override
    public String decode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        decodeMapInitialization();
        StringBuilder sb = new StringBuilder();
        List<String> toDecode = new ArrayList<>(Arrays
                .asList(sourceString.replace("   ", " $ ").split(" ")));
        for (String s : toDecode) {
            sb.append(decoder.get(s));
        }
        return sb.toString();
    }

    private void hashMapInitialization() {
        encoder.put('A', ".- ");
        encoder.put('B', "-... ");
        encoder.put('C', "-.-. ");
        encoder.put('D', "-.. ");
        encoder.put('E', ". ");
        encoder.put('F', "..-. ");
        encoder.put('G', "--. ");
        encoder.put('H', ".... ");
        encoder.put('I', ".. ");
        encoder.put('J', ".--- ");
        encoder.put('K', "-.- ");
        encoder.put('L', ".-.. ");
        encoder.put('M', "-- ");
        encoder.put('N', "-. ");
        encoder.put('O', "--- ");
        encoder.put('P', ".--. ");
        encoder.put('Q', "--.- ");
        encoder.put('R', ".-. ");
        encoder.put('S', "... ");
        encoder.put('T', "- ");
        encoder.put('U', "..- ");
        encoder.put('V', "...- ");
        encoder.put('W', ".-- ");
        encoder.put('X', "-..- ");
        encoder.put('Y', "-.-- ");
        encoder.put('Z', "--.. ");
        encoder.put(',', "--..-- ");
        encoder.put(' ', "  ");
    }

    private void decodeMapInitialization() {
        for (Map.Entry<Character, String> entry : encoder.entrySet()) {
            decoder.put(entry.getValue().trim(), entry.getKey());
        }
        decoder.remove("  ");
        decoder.put("$", ' ');
    }
}
