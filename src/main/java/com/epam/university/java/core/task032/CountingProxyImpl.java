package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CountingProxyImpl implements CountingProxy, SomeActionExecutor {
    private HashMap<String, Integer> count = new HashMap<>();


    @Override
    public int getInvocationsCount(String methodName) {
        return count.getOrDefault(methodName, 0);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(o);
    }

    @Override
    public void doAction() {
        addCount(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Override
    public void doAnotherAction() {
        addCount(new Object(){}.getClass().getEnclosingMethod().getName());
    }

    private void addCount(String methodName) {
        if (count.containsKey(methodName)) {
            count.put(methodName, count.get(methodName) + 1);
        } else {
            count.put(methodName, 1);
        }
    }
}
