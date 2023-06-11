/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Represents a bookstore 
 * @author jfoste81
 */
public class Bookstore{
    ArrayList<Book> books = new ArrayList();
    ArrayList<CD> cds = new ArrayList();
    ArrayList<DVD> dvds = new ArrayList();
    ArrayList<Member> members = new ArrayList();
    ArrayList<PremiumMember> premiumMembers = new ArrayList();
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor for the Bookstore class
     * Calls helper methods that generate lists for 
     * the different products and members of the store
     */
    public Bookstore(){
        generateInventory();
        generateMembers();
    }

    // helper method that generates inventory of products
    private void generateInventory(){
        Book book1 = new Book("To Kill A Mockingbird", "Harper Lee", 12.99, 5);
        Book book2 = new Book("Turtles All the Way Down", "John Green", 15.99, 5);
        CD cd1 = new CD("IGOR", "Tyler the Creator", 8.99, 3);
        CD cd2 = new CD("4 Your Eyez Only", "J. Cole", 6.99, 2);
        DVD dvd1 = new DVD("Good Will Hunting", "Drama Movie", 8.99, 2);
        DVD dvd2 = new DVD("The Dark Knight", "Action Movie", 12.99, 3);

        books.add(book1);
        books.add(book2);
        cds.add(cd1);
        cds.add(cd2);
        dvds.add(dvd1);
        dvds.add(dvd2);
    }

    // helper method that generates lists of members 
    private void generateMembers(){
        Member member1 = new Member("Josh", 3, 28.97);
        PremiumMember member2 = new PremiumMember("Jennifer", 1, 12.99, false);
        PremiumMember member3 = new PremiumMember("Brian", 1, 12.99, true);
        Member member4 = new Member("Rita", 2, 15.98);

        members.add(member1);
        premiumMembers.add(member2);
        premiumMembers.add(member3);
        members.add(member4);
    }

    /**
     * Getter for the books ArrayList field 
     * 
     * @return the books ArrayList of Book objects
     */
    public ArrayList<Book> getBooks(){
        return books;
    }

    /**
     * Getter for the cds ArrayList field 
     * 
     * @return the cds ArrayList of CD objects
     */
    public ArrayList<CD> getCDs(){
        return cds;
    }

    /**
     * Getter for the dvds ArrayList field 
     * 
     * @return the dvds ArrayList of DVD objects
     */
    public ArrayList<DVD> getDVDs(){
        return dvds;
    }

    /**
     * Getter for the members ArrayList field 
     * 
     * @return the members ArrayList of Member objects
     */
    public ArrayList<Member> getMembers(){
        return members;
    }

    /**
     * Getter for the premiumMembers ArrayList field 
     * 
     * @return the premiumMembers ArrayList of PremiumMember objects
     */
    public ArrayList<PremiumMember> getPremiumMembers(){
        return premiumMembers;
    }
    
    /**
     * Getter for an object in one of the book, cd, or dvd ArrayLists
     * 
     * @return the corresponding book/cd/dvd object's name as a String
     * @param i a user inputted int that corresponds to an index of a book/cd/dvd object
     */
    public String getCartItem(int i){
        
        int num = i - 1;
        if(num >= 0 && num < books.size()){
            return books.get(num).getName();
        }
        else if(num >= books.size() && num < cds.size() + books.size()){
            return cds.get(num - books.size()).getName();
        }
        else if(num >= cds.size() && num < dvds.size() + cds.size() + books.size()){
            return dvds.get(num - (cds.size() + books.size())).getName();
        }
        else{
            return "";
        }
        
    }

    /**
     * Getter for an object in one of the book, cd, or dvd ArrayLists
     * 
     * @return the corresponding book/cd/dvd object's price as a double
     * @param i a user inputted int that corresponds to an index of a book/cd/dvd object
     */
    public double getItemPrice(int i){
        int num = i - 1;
        if(num >= 0 && num < books.size()){
            return books.get(num).getPrice();
        }
        else if(num >= books.size() && num < cds.size() + books.size()){
            return cds.get(num - books.size()).getPrice();
        }
        else if(num >= cds.size() && num < dvds.size() + cds.size() + books.size()){
            return dvds.get(num - (cds.size() + books.size())).getPrice();
        }
        else{
            return 0.0;
        }
    }

    /**
     * A method to decrement the amount of inventory stock of an item
     *
     * @param i a user inputted int that corresponds to a book/cd/dvd object whose stock will be decremented
     */
    public void decrementInventory(int i){
        int num = i - 1;
        if(num >= 0 && num < books.size()){
            books.get(num).decrementStock();
        }
        else if(num >= books.size() && num < cds.size() + books.size()){
            cds.get(num - books.size()).decrementStock();
        }
        else if(num >= cds.size() && num < dvds.size() + cds.size() + books.size()){
            dvds.get(num - (cds.size() + books.size())).decrementStock();
        }
    }

    /**
     * A method that interprets if a new member will be free tier or premium
     * and then puts them into the correct corresponding ArrayList based on Object type
     *
     * @param name the name for the new member as a String
     * @param premium the premium status of the new member as a boolean 
     * @param numOfItems the number of items the new member has purchased
     */
    public void addNewMember(String name, boolean premium, int numOfItems){
        if(premium){
            if(numOfItems == 0){
                // registration only
                premiumMembers.add(new PremiumMember(name, numOfItems, 0, false));
            } 
            else{
                // registration with checkout
                premiumMembers.add(new PremiumMember(name, numOfItems, 0, true));
            }
        }
        else{
            members.add(new Member(name, numOfItems, 0));
        }
    }

    /**
     * A method that interprets a member's premium status and then prints out their statistics
     *
     * @param id a user inputted int that corresponds to a Member/PremiumMember object's index
     */
    public void displayMemberStatus(int id){
        System.out.println("Member details:");
        //time to determine what type of member it is:
        if(id <= members.size()){
            id--;
            System.out.println("\tName: " + members.get(id).getName());
            System.out.println("\tNumber of items purchased: " + members.get(id).getNumPurchases());
            System.out.println("\tTotal amount spent: $" + members.get(id).getAmountSpent());
            System.out.println("\tStatus: Free Tier");
        }
        else{
            id -= (members.size() + 1);
            System.out.println("\tName: " + premiumMembers.get(id).getName());
            System.out.println("\tNumber of items purchased: " + premiumMembers.get(id).getNumPurchases());
            System.out.println("\tTotal amount spent: $" + premiumMembers.get(id).getAmountSpent());
            System.out.println("\tStatus: Premium");
            System.out.println("\tMembership dues paid: " + premiumMembers.get(id).hasPaidDues());
        }
    }

}
