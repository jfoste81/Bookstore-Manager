/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Represents a cd
 * @author jfoste81
 */
public class CD{
    private String name;
    private String artist;
    private double price;
    private int stock;

    /**
     * Constructor for the CD class
     *
     * @param name the name of the cd
     * @param artist the name of the cd's artist
     * @param price the price of the cd
     * @param stock the amount of that cd that the store has in inventory 
     */
    public CD(String name, String artist, double price, int stock){
        this.name = name;
        this.artist = artist;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Getter for the name field 
     * 
     * @return the name of the cd as a String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the artist field 
     * 
     * @return the artist of the cd as a String
     */
    public String getArtist(){
        return artist;
    }

    /**
     * Getter for the price field 
     * 
     * @return the price of the cd as a double
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter for the stock field 
     * 
     * @return the stock of the cd as an int
     */
    public int getStock(){
        return stock;
    }

    /** 
     * Setter for the name field 
     * 
     * @param name the new name for the cd
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * Setter for the artist field 
     * 
     * @param artist the new name for the cd's artist
     */
    public void setArtist(String artist){
        this.artist = artist;
    }

    /** 
     * Setter for the price field 
     * 
     * @param price the new price of the cd
     */
    public void setPrice(double price){
        this.price = price;
    }

    /** 
     * Setter for the stock field 
     * 
     * @param stock the new amount of stock the store has for the cd
     */
    public void setStock(int stock){
        this.stock = stock;
    }

    /**
     * A method to decrement the amount of inventory stock of a cd
     *
     */
    public void decrementStock(){
        this.stock--;
    }
}
