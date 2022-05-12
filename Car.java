// Car will have stats: Origin, Brand, Model, Year, Type, HP, Price, Quantity

import java.util.HashMap;

public class Car {

    private final String type;
    private final String origin;
    private final String brand;
    private final String model;
    private final int year;
    private int hp;
    private double price;
    private int quantity;

    public Car(String type, String origin, String brand, String model, int year, int hp, double price, int quantity){
        this.type = type;
        this.origin = origin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.hp = hp;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString(){
        return "Type: " + type + "\nOrigin: " + origin + "\nBrand: " + brand + "\nModel: " + model + "\nYear: " + year + "\nHorse Power: " + hp + "\nPrice: $" + price + "\nStock: " + quantity;
//        System.out.println("Type: " + type);
//        System.out.println("Origin: " + origin);
//        System.out.println("Brand: " + brand);
//        System.out.println("Model: " + model);
//        System.out.println("Year: " + year);
//        System.out.println("Horse Power: " + hp);
//        System.out.println("Price: $" + price);
//        System.out.println("Stock: " + quantity);
    }

    public void getName(){
        System.out.println(brand + " " + model);
        //return "Brand: " + brand + "\nModel: " + model;
        return;
    }

    public int getStock(){
        return this.quantity;
    }

    public void setStock(int num){
        this.quantity -= num;
        return;
    }

    public double getPrice(){
        return this.price;
    }
}
