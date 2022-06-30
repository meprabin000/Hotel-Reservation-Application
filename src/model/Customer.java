package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public static boolean validateEmail(String email) {
        String validPattern = "^(.+)@(.+).(.+)";
        Pattern pattern = Pattern.compile(validPattern);
        return pattern.matcher(email).matches();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(validateEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException("Invalid Email Format. Use the format as name@domain.com");
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customer.getEmail().equals(this.email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
