package baithimodule2.view;

import baithimodule2.controller.ContactController;

public class ContactView {
    public static void main(String[] args) {
        ContactController contactController = new ContactController();
        contactController.displayContactMenu();
    }
}