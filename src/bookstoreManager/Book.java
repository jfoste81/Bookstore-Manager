/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Represents a book
 * @author jfoste81
 */
public class Book{
    private String name;
    private String author;
    private double price; 
    private int stock;

    /**
     * Constructor for the Book class
     *
     * @param name the name of the book
     * @param author the name of the book's author
     * @param price the price of the book
     * @param stock the amount of that book that the store has in inventory 
     */
    public Book(String name, String author, double price, int stock){
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Getter for the name field 
     * 
     * @return the name of the book as a String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the author field 
     * 
     * @return the author of the book as a String
     */
    public String getAuthor(){
        return author;
    }

    /**
     * Getter for the price field 
     * 
     * @return the price of the book as a double
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter for the stock field 
     * 
     * @return the stock of the book as an int
     */
    public int getStock(){
        return stock;
    }

    /** 
     * Setter for the name field 
     * 
     * @param name the new name for the book
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * Setter for the author field 
     * 
     * @param author the new name for the book's author 
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /** 
     * Setter for the price field 
     * 
     * @param price the new price of the book
     */
    public void setPrice(double price){
        this.price = price;
    }

    /** 
     * Setter for the stock field 
     * 
     * @param stock the new amount of stock the store has for the book
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * A method to decrement the amount of inventory stock of a book
     *
     */
    public void decrementStock(){
        this.stock--;
    }
}
