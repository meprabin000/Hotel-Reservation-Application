package tester;

import view.AdminMenu;
import view.MainMenu;
import view.Menu;

public class ViewTester {
    public static void main(String[] args) {
        mainMenuTester();
        adminMenuTester();
    }

    public static void mainMenuTester() {
        MainMenu mainMenu = new MainMenu();
        Menu.display(mainMenu);
    }

    public static void adminMenuTester() {
        AdminMenu adminMenu = new AdminMenu();
        Menu.display(adminMenu);
    }
}
