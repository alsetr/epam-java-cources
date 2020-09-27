package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class SaxHandlerImpl extends SaxHandler {
    public Person person;
    private Collection<PhoneNumber> phoneNumbers;
    private String elementValue;
    private PhoneNumber phone;


    @Override
    public void startDocument() throws SAXException {
        person = new PersonImpl();
    }


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(attributes.getValue(0)));
        } else if (qName.equals("person-phones")) {
            phoneNumbers = new LinkedList<>();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "first-name":
                person.setFirstName(elementValue);
                break;
            case "last-name":
                person.setLastName(elementValue);
                break;
            case "person-phone":
                phone = new PhoneNumberImpl(elementValue);
                phoneNumbers.add(phone);
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        person.setPhoneNumbers(phoneNumbers);
    }

    public Person getPerson() {
        return person;
    }

}
