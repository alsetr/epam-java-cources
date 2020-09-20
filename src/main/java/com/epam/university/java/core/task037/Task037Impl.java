package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class Task037Impl implements Task037 {

    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        String status = "tacked";
        for (int i = 0; i < 10; i++) {
            try {
                if (status.equals("tacked")) {
                    result.add(ticker.call());
                    status = "ticked";
                } else {
                    result.add(tacker.call());
                    status = "tacked";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
