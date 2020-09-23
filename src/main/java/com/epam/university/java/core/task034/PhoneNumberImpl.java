package com.epam.university.java.core.task034;

public class PhoneNumberImpl implements PhoneNumber {
    String phoneNumber;

    public PhoneNumberImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberImpl() {
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
