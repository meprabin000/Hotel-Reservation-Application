package view;

import java.util.List;

public class AdminMenu extends Menu {

    public AdminMenu() {
        super("Admin");
        addMenuItems();
    }
    @Override
    public void start() {
        int option;
        do {
            option = getMenuOption("Please select a number for the admin menu option");
        } while(executeOption(option));
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    @Override
    public boolean executeOption(int option) {

        return false;
    }

    public void addMenuItems() {
        menuItems.add(new MenuItem("See all Customers"));
        menuItems.add(new MenuItem("See all Rooms"));
        menuItems.add(new MenuItem("See all Reservations"));
        menuItems.add(new MenuItem("Add a Room"));
        menuItems.add(new MenuItem("Back to Main Menu"));
    }
}
