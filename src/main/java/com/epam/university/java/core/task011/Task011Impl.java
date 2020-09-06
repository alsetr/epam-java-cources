package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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
        int len = collection.length;
        while (true) {
            i = index(i, len);
            leave.add(collection[i]);
            collection[i] = null;
            if (inCircle == 1) {
                break;
            }
            if (collection[index(i + 1, len)] != null
                    && collection[index(i + 2, len)] != null) {
                i = i + 2;
            } else {
                i++;
                while (collection[index(i, len)] == null) {
                    i++;
                }
                if (collection[index(i + 1, len)] == null) {
                    i++;
                    while (collection[index(i, len)] == null) {
                        i++;
                    }
                }
            }
            inCircle--;
        }
        return leave.get(leave.size() - 1);
    }


    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        String[] array = new String[collection.size()];
        collection.toArray(array);
        return getLastName(array);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        String[] array = new String[collection.size()];
        collection.toArray(array);
        return getLastName(array);
    }

    /**
     * This method checks if index inside array bounds.
     * @param i index for array in while loop.
     * @param length length of array.
     * @return index inside array bounds.
     */
    public int index(int i, int length) {
        int j;
        if (i >= length) {
            j = i % length;
        } else {
            j = i;
        }
        return j;
    }

}
