package com.example.demojpa3.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

//Q1-Create a class Address for Author with instance variables streetNumber, location,
//State.
    //By creating Addess class it will annotaed to @Embeddable as it is Head class and its instance is declared as @Embedded which is author

    private int streetNumber;
    private String location;
    private String state;

    //Created Setter and Setter

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
