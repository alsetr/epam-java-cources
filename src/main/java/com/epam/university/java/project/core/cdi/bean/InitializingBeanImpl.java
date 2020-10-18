package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitializingBeanImpl implements InitializingBean {
    private final Object bean;
    private final String postConstruct;

    public InitializingBeanImpl(Object bean, String postConstruct) {
        this.bean = bean;
        this.postConstruct = postConstruct;
    }

    @Override
    public void afterPropertiesSet() {
        try {
            Method method = bean.getClass().getDeclaredMethod(postConstruct);
            method.invoke(bean);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
