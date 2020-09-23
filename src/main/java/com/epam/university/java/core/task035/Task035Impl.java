package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


import java.io.IOException;
import java.lang.reflect.Type;

public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        PersonImpl person = new PersonImpl();
        try {
            person = mapper.readValue(jsonString, PersonImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        builder.registerTypeAdapter(PhoneNumber.class, new PhoneNumberDeserializer());
        Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, PersonImpl.class);
        return person;
    }

    private class PhoneNumberDeserializer implements JsonDeserializer{

        @Override
        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            PhoneNumber phoneNumber = new PhoneNumberImpl();
            String data = json.getAsString();
            phoneNumber.setPhoneNumber(data);
            return phoneNumber;
        }
    }
}
