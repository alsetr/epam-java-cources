package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) {
        if (first > second) {
            throw new GreaterExceptionImpl(new BaseExceptionImpl());
        } else if (first < second) {
            throw new LessExceptionImpl(new BaseExceptionImpl());
        } else {
            int a = first / second;
        }
    }
}
