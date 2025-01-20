package ss_read_write_file.view;

import ss_read_write_file.controller.EmployeeController;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.displayEmployeeMenu();
    }
}
