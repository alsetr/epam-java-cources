package com.epam.university.java.core.task055;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessingContextImpl implements ProcessingContext {
    String fullPath;
    NodeList houses;
    static final int CURRENT_YEAR = 2020;

    public ProcessingContextImpl(String fullPath) {
        this.fullPath = fullPath;
        openXmlFile();
    }

    @Override
    public Collection<HouseDefinition> oldestHouses() {
        Collection<HouseDefinition> collection = new ArrayList<>();
        Element current;
        Element oldest;
        int oldestAge = 3000;
        int currentAge = 3000;
        HouseDefinition hd;
        for (int i = 0; i < houses.getLength(); i++) {
            current = (Element) houses.item(i);
            String buildingDateParse = current.getElementsByTagName("data_buildingdate")
                    .item(0).getTextContent();
            Pattern pattern = Pattern.compile("\\d{4}");
            Matcher matcher = pattern.matcher(buildingDateParse);
            while (matcher.find()) {
                currentAge = Integer.parseInt(matcher.group());
            }
            if (oldestAge >= currentAge) {
                oldestAge = currentAge;
                oldest = current;
                hd = new HouseDefinitionImpl();
                hd.setAddress(oldest.getElementsByTagName("address").item(0).getTextContent());
                hd.setYear(oldestAge);
                hd.setArea(Double.parseDouble(oldest
                        .getElementsByTagName("data_buildingarea").item(0).getTextContent()));
                collection.add(hd);
            }
        }
        int min = Collections.min(collection,
                Comparator.comparingInt(HouseDefinition::getYear)).getYear();
        collection.removeIf(houseDefinition -> houseDefinition.getYear() > min);
        return collection;
    }

    @Override
    public int averageAge(String district) {
        Element current;
        int sumOfAge = 0;
        int count = 0;
        int currentAge = 2020;
        for (int i = 0; i < houses.getLength(); i++) {
            current = (Element) houses.item(i);
            if (district.equals(current.getElementsByTagName("addr_district")
                    .item(0).getTextContent()) || district.equals("Город")) {
                String buildingDateParse = current.getElementsByTagName("data_buildingdate")
                        .item(0).getTextContent();
                Pattern pattern = Pattern.compile("\\d{4}");
                Matcher matcher = pattern.matcher(buildingDateParse);
                while (matcher.find()) {
                    currentAge = Integer.parseInt(matcher.group());
                }
                sumOfAge += CURRENT_YEAR - currentAge;
                count++;
            }
        }
        return sumOfAge / count;
    }

    @Override
    public HouseDefinition biggestTotalFloorSpace() {
        Element current;
        double biggestArea = 0;
        double currentArea = 0;
        HouseDefinition hd = null;
        int currentAge = 0;
        for (int i = 0; i < houses.getLength(); i++) {
            current = (Element) houses.item(i);
            try {
                currentArea = Double.parseDouble(current
                        .getElementsByTagName("data_buildingarea").item(0).getTextContent());
            } catch (NumberFormatException e) {
                continue;
            }
            if (currentArea > biggestArea) {
                biggestArea = currentArea;
                hd = new HouseDefinitionImpl();
                hd.setAddress(current.getElementsByTagName("address").item(0).getTextContent());
                String buildingDateParse = current.getElementsByTagName("data_buildingdate")
                        .item(0).getTextContent();
                Pattern pattern = Pattern.compile("\\d{4}");
                Matcher matcher = pattern.matcher(buildingDateParse);
                while (matcher.find()) {
                    currentAge = Integer.parseInt(matcher.group());
                }
                hd.setYear(currentAge);
                hd.setArea(currentArea);
            }
        }
        return hd;
    }

    @Override
    public HouseDefinition smallestTotalFloorSpace() {
        Element current;
        double smallestArea = 20000;
        double currentArea = 0;
        HouseDefinition hd = null;
        int currentAge = 0;
        for (int i = 0; i < houses.getLength(); i++) {
            current = (Element) houses.item(i);
            try {
                currentArea = Double.parseDouble(current
                        .getElementsByTagName("data_buildingarea").item(0).getTextContent());
                if (currentArea == 0) {
                    continue;
                }
            } catch (NumberFormatException e) {
                continue;
            }
            if (currentArea < smallestArea) {
                smallestArea = currentArea;
                hd = new HouseDefinitionImpl();
                hd.setAddress(current.getElementsByTagName("address").item(0).getTextContent());
                String buildingDateParse = current.getElementsByTagName("data_buildingdate")
                        .item(0).getTextContent();
                Pattern pattern = Pattern.compile("\\d{4}");
                Matcher matcher = pattern.matcher(buildingDateParse);
                while (matcher.find()) {
                    currentAge = Integer.parseInt(matcher.group());
                }
                hd.setYear(currentAge);
                hd.setArea(currentArea);
            }
        }
        return hd;
    }

    @Override
    public int totalCountHouses() {
        return houses.getLength();
    }

    @Override
    public int totalCountHousesWithCommunalFlats() {
        Element current;
        int count = 0;
        for (int i = 0; i < houses.getLength(); i++) {
            current = (Element) houses.item(i);
            if (!current.getElementsByTagName("comm_room_num").item(0).getTextContent().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private void openXmlFile() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(fullPath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        houses = document.getElementsByTagName("passports_houses");
    }
}
