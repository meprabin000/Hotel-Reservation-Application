package service;

import model.Customer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {

    static Collection<Customer> customers = new ArrayList<>();


    public static void addCustomer(String email, String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail) {
        for(Customer customer: customers) {
            if(customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public static Collection<Customer> getAllCustomers() {
        return customers;
    }
}
