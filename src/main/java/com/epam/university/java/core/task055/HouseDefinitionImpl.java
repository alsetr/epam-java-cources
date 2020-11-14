package com.epam.university.java.core.task055;

public class HouseDefinitionImpl implements HouseDefinition {
    String address;
    int year;
    double area;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "HouseDefinitionImpl{"
                + "address='" + address + '\''
                + ", year=" + year
                + ", area=" + area
                + '}';
    }
}
