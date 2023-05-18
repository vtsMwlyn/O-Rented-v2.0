package com.example.orented;

import java.util.ArrayList;

public class Lessor extends User{
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public Lessor(String id, String password, String name, String birthDate, String address, String phone, String email){
        super(id, password, name, birthDate, address, phone, email);
    }
}
