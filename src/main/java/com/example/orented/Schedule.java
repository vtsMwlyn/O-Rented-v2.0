package com.example.orented;

public class Schedule{
    private String id, date, payment;
    private int duration;
    private Renter borrower;
    private Lessor owner;
    private Vehicle car;

    public Schedule(Renter r, String date, int duration, String payment){
        this.date = date;
        this.duration = duration;
        this.payment = payment;
        this.borrower = r;
        this.id = r.getName() + duration + "_" + date;
    }

    public Schedule(Renter r, Vehicle v, String date, int duration, String payment){
        this.date = date;
        this.duration = duration;
        this.payment = payment;
        this.borrower = r;
        this.car = v;
        this.owner = v.getOwner();
        this.id = r.getName() + duration + "_" + date;
    }

    public Vehicle getVehicle(){
        return car;
    }

    public String getDate(){
        return date;
    }

    public int getDuration(){
        return duration;
    }

    public String getPayment(){
        return payment;
    }

    public Vehicle getVehicleObj(){
        return car;
    }

    public void setVehicle(Vehicle v){
        this.car = v;
        this.owner = v.getOwner();
    }
}
