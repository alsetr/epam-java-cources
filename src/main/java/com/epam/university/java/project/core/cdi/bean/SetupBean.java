package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetupBean {
    private final Object bean;
    private final BeanDefinition beanDefinition;
    private final ApplicationContext context;


    /**
     * Constructor.
     * @param bean - bean to setup.
     * @param beanDefinition - bean definition according which bean will be setup.
     * @param context - which context calls this method.
     */
    public SetupBean(Object bean, BeanDefinition beanDefinition, ApplicationContext context) {
        this.bean = bean;
        this.beanDefinition = beanDefinition;
        this.context = context;
    }


    /**
     * This method initialize bean fields.
     */
    @SuppressWarnings("unchecked")
    public void setupBean() {
        Class<?> beanClass = bean.getClass();
        Field field;
        try {
            for (BeanPropertyDefinition bpd : beanDefinition.getProperties()) {
                field = beanClass.getDeclaredField(bpd.getName());
                field.setAccessible(true);
                if (bpd.getValue() != null) {
                    Object v = bpd.getValue();
                    boolean isInt = true;
                    try {
                        field.getInt(bean);
                    } catch (IllegalArgumentException ignored) {
                        isInt = false;
                    }
                    if (isInt) {
                        field.set(bean, Integer.parseInt(bpd.getValue()));
                    } else {
                        field.set(bean, bpd.getValue());
                    }
                } else if (bpd.getData() != null) {
                    StructureDefinition sd = bpd.getData();
                    if (sd instanceof ListDefinition) {
                        List<String> list = new ArrayList<>();
                        for (ListDefinition.ListItemDefinition lid
                                : ((ListDefinition) sd).getItems()) {
                            list.add(lid.getValue());
                        }
                        field.set(bean, list);
                    } else if (sd instanceof MapDefinition) {
                        Map map = null;
                        boolean isValue = false;
                        for (MapDefinition.MapEntryDefinition med
                                : ((MapDefinition) sd).getValues()) {
                            if (med.getValue() != null && med.getRef() != null) {
                                throw new IllegalArgumentException();
                            } else if (med.getValue() != null) {
                                map = new HashMap<String, String>();
                                isValue = true;
                            } else if (med.getRef() != null) {
                                map = new HashMap<String, Object>();
                                isValue = false;
                            }
                        }
                        if (isValue) {
                            for (MapDefinition.MapEntryDefinition med
                                    : ((MapDefinition) sd).getValues()) {
                                map.put(med.getKey(), med.getValue());
                            }
                        } else {
                            for (MapDefinition.MapEntryDefinition med
                                    : ((MapDefinition) sd).getValues()) {
                                Object ref = context.getBean(med.getRef());
                                map.put(med.getKey(), ref.getClass().cast(ref));
                            }
                        }
                        field.set(bean, map);
                    }
                } else if (bpd.getRef() != null) {
                    Object ref = context.getBean(bpd.getRef());
                    field.set(bean, ref);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (Throwable e) {
            try {
                throw e;
            } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }
        }
    }
}
