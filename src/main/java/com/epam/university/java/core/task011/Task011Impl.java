package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.length == 1) {
            return collection[0];
        }
        int i = 0;
        ArrayList<String> leave = new ArrayList<>();
        int inCircle = collection.length;
        while (true) {
            if (i >= collection.length) {
                i = i - collection.length;
            }
            if (collection[i] == null) {
              i = i + 2;
              continue;
            }
            leave.add(collection[i]);
            System.out.println(collection[i]);
            collection[i] = null;
            i = i + 2;
            inCircle--;
            if (inCircle == 0) {
                break;
            }
        }
        return leave.get(leave.size() - 1);
    }


    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        int size = collection.size();
        if (size == 1) {
            return collection.get(0);
        }
        while (true) {
            collection.remove(null);
            break;
        }
        return null;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return null;
    }
}
