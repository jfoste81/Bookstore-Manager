/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Represents a regular member customer
 * @author jfoste81
 */
public class Member{
    private String name;
    private int numPurchases;
    private double amountSpent;

    /**
     * Constructor for the Member class
     *
     * @param name the name of the member
     * @param numPurchases the number of purchases this member has made
     * @param amountSpent the total amount of money this member has spent at the shop
     */
    public Member(String name, int numPurchases, double amountSpent){
        this.name = name;
        this.numPurchases = numPurchases;
        this.amountSpent = amountSpent;
    }

    /**
     * Getter for the name field 
     * 
     * @return the name as a String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Getter for numPurchases field
     *
     * @return the amount of purchases as a int
     */
    public int getNumPurchases(){
        return numPurchases;
    }

    /**
     * Getter for the amountSpent field
     *
     * @return the total amount of money the member has spent as a double
     */
    public double getAmountSpent(){
        return amountSpent;
    }

    /** 
     * Setter for the name field 
     * 
     * @param name the new name for the member
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter for the numPurchases field
     *
     * @param numPurchases the new amount of purchases made by the member
     */
    public void setNumPuchases(int numPurchases){
        this.numPurchases = numPurchases;
    }

    /** 
     * Setter for the amountSpent field 
     *
     * @param amountSpent the new amount of money spent by the member
     */
    public void setAmountSpent(double amountSpent){
        this.amountSpent = amountSpent;
    }

    /**
     * A method to increment the amount of purchases made by a member at each checkout
     *
     * @param numItems the number of items that the member is purchasing
     */
    public void incrementPurchase(int numItems){
        this.numPurchases += numItems;
    }

    /** 
     * A method to add to the total amount of money the member has spent at the store
     * 
     * @param amountSpent the amount of money the member just spent in a purchase
     */
    public void incrementAmountSpent(double amountSpent){
        this.amountSpent += amountSpent;
    }
}
