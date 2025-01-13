package ss_array_list_crud.controller;

import ss_array_list_crud.modern.Employee;
import ss_array_list_crud.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    Scanner scanner = new Scanner(System.in);

    public void disPlayMenu() {
        int choice;
        do {
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Cập nhât nhân viên");
            System.out.println("Mời chọn chức năng");
            choice = scanner.nextInt();
            switch (choice) {
                case 0 -> System.out.println("Thoát chương trình.");
                case 1 -> {
                    List<Employee> employees = employeeService.findAll();
                    for (var employee : employees) {
                        System.out.println(employee);
                    }
                }
                case 2 -> employeeService.addEmployee();
                case 3 -> employeeService.deleteEmployee();
                case 4 -> employeeService.updateEmployee();
                default -> System.out.println("vui lòng nhập 1-4.");
            }
        } while (choice != 0);
    }
}
