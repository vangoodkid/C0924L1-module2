package ss9_mvc.view;

import ss9_mvc.controller.CustomerController;
import ss9_mvc.model.Customer;

public class Main {
    public static void main(String[] args) {
        CustomerController customerController =  new CustomerController();
        customerController.displayCustomerController();
    }
}
