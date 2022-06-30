package tester;

import model.Customer;

public class ModelTester {

    public static void main(String[] args) {
        customerTester();
    }

    public static void customerTester() {
        Customer customer = new Customer("first", "second", "email@d.com");

        System.out.println(customer);
    }
}
