package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Collection;

public class PersonImpl implements Person {
    private int id;
    private String firstName;
    private String lastName;
    Collection<PhoneNumber> phones;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phones;
    }

    @Override
    @JsonSetter("phones")
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phones = phoneNumbers;
    }
}
