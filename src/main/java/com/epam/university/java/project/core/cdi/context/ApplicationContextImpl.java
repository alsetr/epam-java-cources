package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionsList;
import com.epam.university.java.project.core.cdi.bean.InitializingBean;
import com.epam.university.java.project.core.cdi.bean.InitializingBeanImpl;
import com.epam.university.java.project.core.cdi.bean.SetupBean;
import com.epam.university.java.project.core.cdi.io.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContextImpl implements ApplicationContext {
    BeanDefinitionRegistry registry = new BeanDefinitionRegistryImpl();
    /**
     * Entry of this map contains id of bean and bean itself.
     */
    Map<String, Object> context = new HashMap<>();
    BeanDefinitionsList beanDefinitionsList;
    InitializingBean initializingBean;
    SetupBean setupBean;

    @Override
    public int loadBeanDefinitions(Resource resource) {
        File file = resource.getFile();
        beanDefinitionsList = null;
        try {
            JAXBContext context = JAXBContext.newInstance(BeanDefinitionsList.class);
            beanDefinitionsList = (BeanDefinitionsList) context
                    .createUnmarshaller().unmarshal(new FileReader(file));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        for (BeanDefinition bd : beanDefinitionsList.getDefinitions()) {
            registry.addBeanDefinition(bd);
        }
        return beanDefinitionsList.getDefinitions().size();
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int count = 0;
        for (Resource r : resources) {
            count += loadBeanDefinitions(r);
        }
        return count;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        for (BeanDefinition bd : beanDefinitionsList.getDefinitions()) {
            if (bd.getClassName().equals(beanClass.getCanonicalName())) {
                return beanClass.cast(getBean(bd.getId()));
            } else {
                try {
                    for (Class<?> clazz : Class.forName(bd.getClassName()).getInterfaces()) {
                        if (clazz.equals(beanClass)) {
                            return beanClass.cast(getBean(bd.getId()));
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        Object bean = null;
        if (beanDefinition.getScope() == null || !beanDefinition.getScope().equals("singleton")) {
            bean = createBean(beanDefinition, beanName);
        } else if (beanDefinition.getScope().equals("singleton")) {
            if (context.get(beanName) != null) {
                return context.get(beanName);
            } else {
                bean = createBean(beanDefinition, beanName);
            }
        }
        if (beanDefinition.getProperties() != null) {
            setupBean = new SetupBean(bean, beanDefinition, this);
            setupBean.setupBean();
        }
        if (beanDefinition.getPostConstruct() != null) {
            initializingBean = new InitializingBeanImpl(bean, beanDefinition.getPostConstruct());
            initializingBean.afterPropertiesSet();
        }
        return bean;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return beanClass.cast(getBean(beanName));
    }


    private Object createBean(BeanDefinition beanDefinition, String beanName) {
        Object bean = null;
        try {
            bean = Class.forName(beanDefinition.getClassName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        context.put(beanName, bean);
        return bean;
    }
}
