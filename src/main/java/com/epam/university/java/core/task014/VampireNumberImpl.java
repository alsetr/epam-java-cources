package com.epam.university.java.core.task014;

public class VampireNumberImpl implements VampireNumber {
    private int mult;
    private int first;
    private int second;

    @Override
    public int getMultiplication() {
        return mult;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VampireNumber)) {
            return false;
        }
        VampireNumber o = (VampireNumber) obj;
        if (this.mult != o.getMultiplication()) {
            return false;
        }
        if ((this.first == o.getFirst() && this.second == o.getSecond())
                || (this.second == o.getFirst() && this.first == o.getSecond())) {
            return true;
        }
        return false;
    }
}
