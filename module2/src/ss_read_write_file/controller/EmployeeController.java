package ss_read_write_file.controller;

import ss_read_write_file.modern.Employee;
import ss_read_write_file.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    public void displayEmployeeMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = getChoice(scanner);
            handleChoice(choice, scanner);
        }
    }

    private void showMenu() {
        System.out.println("Chọn chức năng: \n" +
                "1. Xem toàn bộ nhân viên\n" +
                "2. Thêm nhân viên mới\n" +
                "3. Xóa nhân viên\n" +
                "4. Chỉnh sửa thông tin nhân viên\n" +
                "5. Thoát.");
    }

    private int getChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
        return choice;
    }

    private void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                displayAllEmployees();
                break;
            case 2:
                addEmployee(scanner);
                break;
            case 3:
                deleteEmployee(scanner);
                break;
            case 4:
                updateEmployee(scanner);
                break;
            case 5:
                System.exit(0);
                break;
        }
    }

    private void displayAllEmployees() {
        System.out.println("Danh sách các nhân viên:");
        List<Employee> employees = employeeService.getAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Nhập id nhân viên mới: ");
        String newId = scanner.nextLine(); // id là kiểu String
        System.out.print("Nhập tên nhân viên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập địa chỉ nhân viên mới: ");
        String newAddress = scanner.nextLine();
        System.out.print("Nhập tuổi nhân viên mới: ");
        int newAge = Integer.parseInt(scanner.nextLine());
        employeeService.addEmployee(new Employee(newId, newName, newAddress, newAge));
    }

    private void deleteEmployee(Scanner scanner) {
        System.out.print("Nhập id nhân viên cần xóa: ");
        String deleteId = scanner.nextLine(); // id là kiểu String
        boolean isDeleted = employeeService.deleteEmployeeById(deleteId);
        if (isDeleted) {
            System.out.println(" Xóa nhân viên có id: " + deleteId + " thành công");
        } else {
            System.out.println(" Không tìm thấy nhân viên có id: " + deleteId);
        }
    }

    private void updateEmployee(Scanner scanner) {
        System.out.print("Nhập id nhân viên cần chỉnh sửa: ");
        String idToUpdate = scanner.nextLine(); // id là kiểu String
        boolean isUpdated = employeeService.updateEmployeeById(idToUpdate);
        if (isUpdated) {
            System.out.println("Cập nhật nhân viên có id: " + idToUpdate + " thành công");
        } else {
            System.out.println(" Không tìm thấy nhân viên có id: " + idToUpdate);
        }
    }
}