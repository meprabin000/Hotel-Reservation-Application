package view;

import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu() {
        super("Main");
        addMenuItems();
    }

    @Override
    public void start() {
        int option = 0;
        do {
            display(this);
            option = getMenuOption("Please select a number for the menu option");

        } while(executeOption(option));
    }
    @Override
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    @Override
    public boolean executeOption(int option) {
        switch(option) {
            case 1:
                option1();
                break;
            case 2:
                // call the appropriate resource to view the reservation
                break;
            case 3:
                // get the information for user account
                // create an account
                break;
            case 4:
                // open the admin menu
                break;
            case 5:
                return false;
        }
        return true;
    }



    public void addMenuItems() {
        menuItems.add(new MenuItem("Find and reserve a room"));
        menuItems.add(new MenuItem("See my reservations"));
        menuItems.add(new MenuItem("Create an account"));
        menuItems.add(new MenuItem("Admin"));
        menuItems.add(new MenuItem("Exit"));
    }

    public void option1() {
        Date checkInDate, checkOutDate;
        String email, roomNumber;
        Customer customer;
        IRoom room;

        checkInDate = Menu.getDate("Enter CheckIn Date mm/dd/yyyy example 02/12/2020");
        checkOutDate = Menu.getDate("Enter CheckOut Date mm/dd/yyyy example 02/12/2020");
        Collection<IRoom> rooms = HotelResource.findARoom(checkInDate, checkOutDate);
        if(rooms == null) {
            log("No room available for the given dates");
            return;
        }
        Menu.displayCollection(rooms);
        if (getBooleanInput("Would you like to book a room?")) {
            if (getBooleanInput("Do you have an account with us?")) {
                email = getEmail("Enter Email format: name@domain.com");
                do {
                    customer = HotelResource.getCustomer(email);
                    if (customer == null)
                        log("404 NOT FOUND.");
                } while (customer == null);
                do {
                    roomNumber = getString("What room number would you like to reserve?");
                    room = HotelResource.getRoom(roomNumber);
                    if (room == null)
                        log("The given room number doesn't exist.");
                    else if (!rooms.contains(room)) {
                        log("The given room is not free for the given checkIn and checkOut Date.");
                        room = null;
                    }
                } while (room == null);
            }
        }
    }


}
