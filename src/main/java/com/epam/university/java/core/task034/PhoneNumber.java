package com.epam.university.java.core.task034;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Phone number model.
 */
@JsonDeserialize(as = PhoneNumberImpl.class)
public interface PhoneNumber {
    /**
     * Get phone number value.
     * @return number value
     */
    String getPhoneNumber();

    /**
     * Set phone number value.
     * @param phoneNumber number value
     */
    void setPhoneNumber(String phoneNumber);
}
