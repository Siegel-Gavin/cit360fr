package code.MVC;

import java.util.LinkedList;
import java.util.Scanner;

public class main{

    public customerView(){
    }

    public void customerMenu() {
        // print menu

        System.out.println("Please Select an option\n");
        System.out.println("1 - Add a new customer");
        System.out.println("2 - Delete a customer");
        System.out.println("3 -  See a list of customers");
        System.out.println("0 -  Quit");
    }

    public void addNewView(){
        System.out.println("**********************");
        System.out.println("Add a new customer");
    }

    public void deleteCustomerView(LinkedList<Customer> customers) {
        System.out.println("**********************");
        System.out.println("Deletes the last customer you added: ");
        System.out.println(customers);
    }

    public void listCustomerView(Customer customer) {
        System.out.println("First Name: " + customer.getFirstName() + " Last Name: " + customer.getLastName());
    }

    public void exitMessage() {
        System.out.println("See you later!");
    }

    public void invalidMessage() {
        System.out.println("Invalid choice.");
    }
}