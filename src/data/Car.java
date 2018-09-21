package data;

public class Car {

    public int year;
    public String brand;
    public String model;
    public String color;

    public String Info;

    public Car(int year, String brand, String model, String color) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Car(int year, String brand, String model) {
        this.year = year;
        this.brand = brand;
        this.model = model;
    }


    public Car(String brand) {
        this.brand = brand;
    }



    public int getYear() { return year; }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return year+" "+model+" "+color;
    }

}

