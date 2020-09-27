package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PersonImpl implements Person {

    private int id;


    private String firstName;


    private String lastName;


    private Collection<PhoneNumber> phones;



    @Override
    public int getId() {
        return id;
    }


    @Override
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String getFirstName() {
        return firstName;
    }


    @Override
    @XmlElement(name = "first-name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    @XmlElement(name = "last-name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return this.phones;
    }

    @Override
    @JsonSetter("phones")
    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phones = phoneNumbers;
    }
}
