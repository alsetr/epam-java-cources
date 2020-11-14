package com.epam.university.java.project.core.cdi.structure;

import com.epam.university.java.core.task034.PhoneNumberImpl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    Collection<MapEntryDefinition> values;


    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }
}