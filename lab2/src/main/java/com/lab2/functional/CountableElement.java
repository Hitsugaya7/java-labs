package com.lab2.functional;

public class CountableElement {
    private Integer counter;

    public void count() {
        counter++;
    }

    public Integer getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }

}
