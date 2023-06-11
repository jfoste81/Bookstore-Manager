/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookstoreManager;

import java.util.*;

/**
 * Driver file that contains the main function that runs the Bookstore
 * @author jfoste81
 */
public class BookstoreDriver {

    public static void main(String[] args) {
        //Starting a Bookstore instance and Scanner
        Bookstore store = new Bookstore();
        Scanner scan = new Scanner(System.in);
        boolean run = true; //boolean value that will be the condition for the while loop
        
        //the loop that runs the store
        while(run){
            System.out.println("Welcome to the Bookstore System!");
            System.out.println("Select one of the options below:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Register as a new member");
            System.out.println("\t3. Check membership status");
            System.out.println("\t4. Exit");

            int choice = scan.nextInt();
            
            //switch statement that decides what the program will do based on user input
            switch(choice){
                case 1:
                    System.out.println("------------------------------");
                    purchase(store, scan, new ArrayList<String>(), new ArrayList<Double>());
                    break;
                case 2:
                    System.out.println("------------------------------");
                    registerNewMember(store, scan, 0);
                    break;
                case 3:
                    System.out.println("------------------------------");
                    checkMembership(store, scan);
                    break;
                case 4:
                    run = false;
                    System.out.println("Thanks for shopping at our store! We hope to see you soon!");
                    break;
                default:
                    System.out.println("------------------------------");
                    System.out.println("Invalid input, please try again");
            }
        }

    }

    /**
     * a method that allows the user to add items to a cart and gives the user the option to checkout 
     * 
     * @param store the Bookstore instance we establish at the beginning of main
     * @param scan the Scanner we establish at the beginning of main
     * @param purchases ArrayList of Strings that contain the names of items the user adds to their cart
     * @param cart ArrayList of doubles that contain the price of items the user adds to their cart 
     */
    private static void purchase(Bookstore store, Scanner scan, ArrayList<String> purchases, ArrayList<Double> cart){
        
        //Variable Declarations
        int itemNum = 1;
        double total = 0;
        int choice;

        //Giving user a visual to select what they want to add to their cart
        System.out.println("What would you like to purchase?");
        ArrayList<Book> bookInventory = store.getBooks();
        ArrayList<CD> cdInventory = store.getCDs();
        ArrayList<DVD> dvdInventory = store.getDVDs();

        for(Book item : bookInventory){
            System.out.print("\t" + itemNum + ". " + item.getName());
            System.out.println(" by " + item.getAuthor() + " - $" + item.getPrice() + " (Book)");
            itemNum++;
        }
        for(CD item : cdInventory){
            System.out.print("\t" + itemNum + ". " + item.getName());
            System.out.println(" by " + item.getArtist() + " - $" + item.getPrice() + " (CD)");
            itemNum++;
        }
        for(DVD item : dvdInventory){
            System.out.print("\t" + itemNum + ". " + item.getName());
            System.out.println(" (" + item.getCategory() + ") - $" + item.getPrice() + " (DVD)");
            itemNum++;
        }
        
        choice = scan.nextInt();
        //Calling methods that add items to the purchases and cart ArrayLists. Calls decrementIventory() that decreases stock value of each item added
        if(choice < itemNum){
            purchases.add(store.getCartItem(choice));
            cart.add(store.getItemPrice(choice));
            store.decrementInventory(choice);
            
            System.out.println("You have " + purchases.size() + " items in your cart. Do you want to keep shopping?");
            System.out.println("\t1. Yes\t2. No");
            
            int doneShopping = scan.nextInt();
            boolean invalid = true;
            
            while(invalid){
                if(doneShopping == 1){
                    purchase(store, scan, purchases, cart); //Recursively call purchase()
                    invalid = false;
                }
                else if(doneShopping == 2){
                    checkout(store, scan, purchases, cart); //Calls checkout() so the user can progress
                    invalid = false;
                }
                else{
                    System.out.println("Please input 1 or 2"); //Error message
                    doneShopping = scan.nextInt();
                }
            }
        }
    }
    
    /**
     * a method that allows the user to checkout the items they have in their carts
     * 
     * @param store the Bookstore instance we establish at the beginning of main
     * @param scan the Scanner we establish at the beginning of main
     * @param purchases ArrayList of Strings that contain the names of items the user adds to their cart
     * @param cart ArrayList of doubles that contain the price of items the user adds to their cart 
     */
    private static void checkout(Bookstore store, Scanner scan, ArrayList<String> purchases, ArrayList<Double> cart){
        boolean runLoop = true;
        double total = 0.0;

        //Calculating total cost of the items
        for(double d : cart){
            total += d;
        }

        //Start of the actual Checkout process. While loop ensures valid user input
        System.out.println("Welcome to Checkout! If you did not mean to checkout, press 2 to go back to purchase more items.");
        while(runLoop){
            System.out.println("\t1. Complete Checkout\t2.Go back to Purchase");
            int choice = scan.nextInt();
            if(choice == 2){
                purchase(store, scan, purchases, cart); //Sends user back to Purchase in case they want to add more items to cart / Did not mean to come to checkout()
            }
            else if(choice == 1){
                System.out.println("---------- CART ----------");
                for(String item : purchases){
                    int num = 1;
                    System.out.println("\t" + num + ". " + item);
                }
                System.out.println("Your total for your " + purchases.size() + " item(s) is: $" + total);
                runLoop = false;
            }
            else{
                System.out.println("Invalid input. Please input 1 or 2.");
            }
        }

        //Printing out members so that user can assign the purchase to their member account
        System.out.println("Please enter your corresponding Member ID from the list below");
        int num = 1;
        for(Member member : store.getMembers()){
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        for(PremiumMember member : store.getPremiumMembers()){
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        int id = scan.nextInt();
        if (id < 1 || id > store.getMembers().size() + store.getPremiumMembers().size()){
            System.out.println("Invalid ID");
            return;
        }

        //If statements to figure out who the member is and increment their amount of items purchased and total spent at the store
        if(id <= store.getMembers().size()){
            id--;
            store.getMembers().get(id).incrementPurchase(purchases.size());
            store.getMembers().get(id).incrementAmountSpent(total);
            System.out.println("Thank you " + store.getMembers().get(id).getName() + 
                                " for spending $" + store.getMembers().get(id).getAmountSpent()
                                + " at our store!\nWe appreciate your patronage");
        }
        else{
            id -= (store.getMembers().size() + 1);
            store.getPremiumMembers().get(id).incrementPurchase(purchases.size()); 
            store.getPremiumMembers().get(id).incrementAmountSpent(total);
            System.out.println("Thank you " + store.getPremiumMembers().get(id).getName() + 
                                " for spending $" + store.getPremiumMembers().get(id).getAmountSpent()
                                + " at our store!\nWe appreciate your patronage");
        }
    }

    /**
     * a method that allows for the creation of new members
     * 
     * @param store the Bookstore instance we establish at the beginning of main
     * @param scan the Scanner we establish at the beginning of main
     * @param numOfItems the amount of items the new member has purchased (if any) 
     */
    private static boolean registerNewMember(Bookstore store, Scanner scan, int numOfItems){        
        boolean runLoop = true; 
        boolean bool = false; //boolean variable that will be returned at the end of the method

        System.out.println("Let's start the registration so you can be a Member!");
        System.out.println("Would you like to register as a free Member or a Premium Member?");
        
        //while loop ensures valid user input
        while(runLoop){
            System.out.println("\t1. Free-tier\t2.Premium");
            int choice = scan.nextInt();
            scan.nextLine();//Clearing the nextLine() method
            
            //Choosing free-tier
            if(choice == 1){
                System.out.println("What is your name?");
                String name = scan.nextLine();
                store.addNewMember(name, false, numOfItems);
                runLoop = false;
                bool = false;
            }
            //Choosing premium tier
            else if(choice == 2){
                System.out.println("What is your name?");
                String name = scan.nextLine();
                store.addNewMember(name, true, numOfItems);
                runLoop = false;
                bool = true;
            }
            else{
                System.out.println("Invalid Input. Please input 1 or 2.");
            }
        }
        return bool;
    }

    /**
     * a method that allows the user to check the status of someone's membership
     * 
     * @param store the Bookstore instance we establish at the beginning of main
     * @param scan the Scanner we establish at the beginning of main
     */
    private static void checkMembership(Bookstore store, Scanner scan){
        System.out.println("Please enter your corresponding Member ID from the list below");
        int num = 1;

        //Listing out all of the members/premium members
        for(Member member : store.getMembers()){
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        for(PremiumMember member : store.getPremiumMembers()){
            System.out.println("\t" + num + ". " + member.getName());
            num++;
        }
        int choice = scan.nextInt();
        if (choice < 1 || choice > store.getMembers().size() + store.getPremiumMembers().size()){
            System.out.println("Invalid ID");
            return;
        }

        //valid input - print out member details 
        store.displayMemberStatus(choice);
    }

}

