package com.epam.university.java.core.task033;

public class BaseExceptionImpl extends RuntimeException implements BaseException {
    public BaseExceptionImpl() {
        super("Base Exception");
    }
}
