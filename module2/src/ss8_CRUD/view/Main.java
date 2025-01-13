package ss8_CRUD.view;

import ss8_CRUD.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.displayMenu();
    }
}
