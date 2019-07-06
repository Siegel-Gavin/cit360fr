package code.Hibernate;

import java.util.LinkedList;
import java.util.Scanner;

public class main{

    public employeeView(){
    }

    public void employeeMenu() {
        // print menu

        System.out.println("Please Select an option\n");
        System.out.println("1 - Add a new employee");
        System.out.println("2 - Delete a employee");
        System.out.println("3 -  See a list of employees");
        System.out.println("0 -  Quit");
    }

    public void addNewView(){
        System.out.println("**********************");
        System.out.println("Add a new employee");
    }

    public void deleteCustomerView(LinkedList<Employee> employees) {
        System.out.println("**********************");
        System.out.println("Deletes the last employee you added: ");
        System.out.println(employees);
    }

    public void listCustomerView(Employee employee) {
        System.out.println("First Name: " + employee.getFirstName() + " Last Name: " + employee.getLastName());
    }

    public void exitMessage() {
        System.out.println("See you later!");
    }

    public void invalidMessage() {
        System.out.println("Invalid choice.");
    }
}