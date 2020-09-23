package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }
        if (sourceMessage.isEmpty()) {
            return 0;
        }
        if (!sourceMessage.startsWith("S")) {
            throw new IllegalArgumentException();
        }
        String expected = "SOS";
        int altered = 0;
        String sos;
        for (int i = 0; i <= sourceMessage.length(); i = i + 3) {
            if (i + 3 <= sourceMessage.length()) {
                sos = sourceMessage.substring(i, i + 3);
                for (int j = 0; j < sos.length(); j++) {
                    if (expected.charAt(j) != sos.charAt(j)) {
                        altered++;
                    }

                }
            } else {
                sos = sourceMessage.substring(i);
                for (int j = 0; j < sos.length(); j++) {
                    if (expected.charAt(j) != sos.charAt(j)) {
                        altered++;
                    }
                }
            }
        }
        return altered;
    }
}
