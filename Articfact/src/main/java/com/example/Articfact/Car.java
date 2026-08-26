package com.example.Articfact;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Car {
    static List<Car> all_cars = new ArrayList<>();
    private String plateNumber;
    boolean isRented;
    private LocalDate returnDate;
    Car(String plateNumber, boolean isRented){
        this.plateNumber = plateNumber;
        all_cars.add(this);
        this.isRented = isRented;
    }
    public String getPlateNumber(){
        return plateNumber;
    }
    public boolean getIsRented(){
        return isRented;
    }
    public void setIsRented(boolean isRented){
        this.isRented = isRented;
    }
    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate){
        this.returnDate = returnDate;
    }
    static List<Car> getList(){
        return all_cars;
    }
    @Override
    public String toString(){
        return plateNumber + "is rented:"+ isRented;
    }

}
