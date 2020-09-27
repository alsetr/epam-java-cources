package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        String absolutePath = getClass().getResource(filepath).getPath();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        SaxHandlerImpl saxHandler = new SaxHandlerImpl();
        Person person = null;
        try {
            parser.parse(new File(absolutePath), saxHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(saxHandler.getPerson());
        return saxHandler.getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        String absolutePath = getClass().getResource(filepath).getPath();
        Person person = null;
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class);
            person = (Person) context.createUnmarshaller().unmarshal(new FileReader(absolutePath));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        StartElement startElement = null;
        Person person = new PersonImpl();
        Collection<PhoneNumber> phones = new LinkedList<>();
        try {
            reader = factory.createXMLEventReader(streamReader);
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "person":
                            Attribute id = startElement.getAttributeByName(new QName("id"));
                            person.setId(Integer.parseInt(id.getValue()));
                            break;
                        case "first-name":
                            nextEvent = reader.nextEvent();
                            person.setFirstName(nextEvent.asCharacters().getData());
                            break;
                        case "last-name":
                            nextEvent = reader.nextEvent();
                            person.setLastName(nextEvent.asCharacters().getData());
                            break;
                        case "person-phone":
                            nextEvent = reader.nextEvent();
                            PhoneNumber phoneNumber =
                                    new PhoneNumberImpl(nextEvent.asCharacters().getData());
                            phones.add(phoneNumber);
                            break;
                        default:
                            break;
                    }
                } else if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("person-phones")) {
                        person.setPhoneNumbers(phones);
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return person;
    }

}
