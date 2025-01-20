package ss_read_write_file.service;

import ss_read_write_file.modern.Employee;
import ss_read_write_file.util.ReadAndWriteFile;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private final String EMPLOYEES_FILE = "/Users/phamvan/Documents/module2/module2/src/ss_read_write_file/data/employees.csv";
    private final boolean APPEND = true;
    private final boolean NOT_APPEND = false;

    @Override
    public List<Employee> getAllEmployee() {
        List<String> employeeStringList = ReadAndWriteFile.readFile(EMPLOYEES_FILE);
        List<Employee> employees = new ArrayList<>();
        for (String employeeString : employeeStringList) {
            String[] employeeArray = employeeString.split(",");
            employees.add(new Employee(
                    employeeArray[0], // id is now a String
                    employeeArray[1],
                    employeeArray[2],
                    Integer.parseInt(employeeArray[3])
            ));
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<String> employeeStringList = new ArrayList<>();
        employeeStringList.add(employee.getInfoEmployee());
        ReadAndWriteFile.writeFile(EMPLOYEES_FILE, employeeStringList, APPEND);
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        List<Employee> employees = getAllEmployee();
        boolean isExist = employees.removeIf(employee -> employee.getId().equals(id));
        if (isExist) {
            writeAllEmployees(employees);
        }
        return isExist;
    }

    @Override
    public boolean updateEmployeeById(String id) {
        List<Employee> employees = getAllEmployee();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                System.out.println("Nhân viên cần cập nhật: " + employees.get(i));
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập tên mới cho nhân viên: ");
                String newName = sc.nextLine();
                System.out.print("Nhập địa chỉ mới cho nhân viên: ");
                String newAddress = sc.nextLine();
                System.out.print("Nhập tuổi mới cho nhân viên: ");
                int newAge = Integer.parseInt(sc.nextLine());
                employees.set(i, new Employee(id, newName, newAddress, newAge));
                writeAllEmployees(employees);
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return getAllEmployee().stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void writeAllEmployees(List<Employee> employees) {
        List<String> employeeStringList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeStringList.add(employee.getInfoEmployee());
        }
        ReadAndWriteFile.writeFile(EMPLOYEES_FILE, employeeStringList, NOT_APPEND);
    }
}