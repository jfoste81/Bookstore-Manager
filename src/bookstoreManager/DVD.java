/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Represents a dvd
 * @author jfoste81
 */
public class DVD{
    private String name;
    private String category;
    private double price;
    private int stock;

    /**             
     * Constructor for the DVD class
     *
     * @param name the name of the dvd
     * @param category the name of the dvd's genre/category
     * @param price the price of the dvd
     * @param stock the amount of that dvd that the store has in inventory 
     */
    public DVD(String name, String category, double price, int stock){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Getter for the name field 
     * 
     * @return the name of the dvd as a String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the category field 
     * 
     * @return the category of the dvd as a String
     */
    public String getCategory(){
        return category;
    }

    /**
     * Getter for the price field 
     * 
     * @return the price of the dvd as a double
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter for the stock field 
     * 
     * @return the stock of the dvd as an int
     */
    public int getStock(){
        return stock;
    }

    /** 
     * Setter for the name field 
     * 
     * @param name the new name for the dvd
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * Setter for the category field 
     * 
     * @param category the new category for the dvd
     */
    public void setCategory(String category){
        this.category = category;
    }

    /** 
     * Setter for the price field 
     * 
     * @param price the new price of the dvd
     */
    public void setPrice(double price){
        this.price = price;
    }

    /** 
     * Setter for the stock field 
     * 
     * @param stock the new amount of stock the store has for the dvd
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * A method to decrement the amount of inventory stock of a dvd
     *
     */
    public void decrementStock(){
        this.stock--;
    }
}
