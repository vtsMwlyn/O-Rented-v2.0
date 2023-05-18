package com.example.orented;

public class Vehicle{
    private String id, name, manufacturer, control;
    private int seat, door, rentPrice;
    private Lessor owner;
    private boolean isAvailable;

    public Vehicle(String id, String name, String manufacturer, int seat, int door, String control, Lessor owner, int rentPrice){
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.seat = seat;
        this.door = door;
        this.control = control;
        this.owner = owner;
        this.rentPrice = rentPrice;

        isAvailable = true;
    }

    public Lessor getOwner(){
        return owner;
    }

    public String getFullName(){
        return manufacturer + " " + name;
    }

    public int getRentPrice(){
        return rentPrice;
    }

    public int getSeat(){
        return seat;
    }

    public int getDoor(){
        return door;
    }

    public String getControl(){
        return control;
    }

    public int getPrice(){
        return rentPrice;
    }

    public void setAvailability(boolean available){
        if(available){
            isAvailable = true;
        } else {
            isAvailable = false;
        }
    }

    public int checkAvailability(){
        if(isAvailable){
            return 1;
        } else {
            return 0;
        }
    }
}
