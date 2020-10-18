package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    List<BeanDefinition> definitions = new ArrayList<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        definitions.add(definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        for (BeanDefinition bd : definitions) {
            if (bd.getId().equals(beanId)) {
                return bd;
            }
        }
        return null;
    }
}
