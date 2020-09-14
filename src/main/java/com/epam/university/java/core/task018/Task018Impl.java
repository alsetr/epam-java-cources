package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        @SuppressWarnings("unchecked")
        Class<? extends Annotation> find = (Class<? extends Annotation>) annotationToFind;
        Class<?> cls = toCheck.getClass();
        if (cls.getPackage().isAnnotationPresent(find)) {
            return true;
        }
        if (cls.isAnnotationPresent(find)) {
            return true;
        }
        for (Field f: cls.getDeclaredFields()) {
            if (f.isAnnotationPresent(find)) {
                return true;
            }
        }
        for (Method m : cls.getMethods()) {
            if (m.isAnnotationPresent(find)) {
                return true;
            }
            for (Parameter p : m.getParameters()) {
                if (p.isAnnotationPresent(find)) {
                    return true;
                }
            }
        }
        for (Constructor c : cls.getConstructors()) {
            if (c.isAnnotationPresent(find)) {
                return true;
            }
        }

        return false;
    }
}
