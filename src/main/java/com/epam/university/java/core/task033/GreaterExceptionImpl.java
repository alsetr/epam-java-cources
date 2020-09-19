package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends RuntimeException implements GreaterException {
    public GreaterExceptionImpl(BaseExceptionImpl e) {
        super("First > Second", e);
    }
}
