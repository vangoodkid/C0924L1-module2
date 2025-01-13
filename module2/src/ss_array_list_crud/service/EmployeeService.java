package ss_array_list_crud.service;

import ss8_CRUD.modern.Customer;
import ss_array_list_crud.modern.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeService implements IEmployeeService  {
    Scanner scanner = new Scanner(System.in);
     static ArrayList<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("EMP1001","Lê Văn vũ","Hà nội",20));
        employees.add(new Employee("EMP1002","Lê Văn tình","Huế",21));
        employees.add(new Employee("EMP1003","Lê Văn nam","Đà Nẵng",22));
    }
    public List<Employee> findAll() {
        return employees;
    }
        public void addEmployee() {
            var employee = createEmployee();
            if (employee != null){
                employees.add(employee);
                System.out.println("Thêm khách hàng thành công");
            }else {
                System.out.println("Lỗi nhập sai mã nhân viên");
            }
        }
        public void deleteEmployee(){
            System.out.println("Nhập mã nhân viên cần xóa: ");
            String id = scanner.nextLine();
            var employee = findEmployeeById(id);
            if (employee != null){
                employees.remove(employee);
                System.out.println("Xóa nhân viên thành công");
            }else {
                System.out.println("Không tìm thấy nhân viên.");
            }
        }
        public void updateEmployee(){
            System.out.println("Nhập mã nhân viên để cập nhật: ");
            String id =scanner.nextLine();
            var employee = findEmployeeById(id);
            if (employee != null){
                System.out.println("Nhập Id mới cho nhân viên: ");
                employee.empId = scanner.nextLine();
                System.out.println("Nhập Họ và tên mới cho nhân viên: ");
                employee.fullName = scanner.nextLine();
                System.out.println("Nhập địa chỉ mới cho nhân viên: ");
                employee.address = scanner.nextLine();
                System.out.println("Nhập tuổi mới cho nhân viên: ");
                employee.age = Integer.parseInt(scanner.nextLine());
                System.out.println("Cập nhật nhân viên thành công.");
            }else {
                System.out.println("Không tìm thấy nhân viên trong ds");
            }
        }
        public Employee findEmployeeById(String id){
        for(var employee: employees){
            if (employee.empId.compareToIgnoreCase(id) == 0){
                return employee;
            }
        }
        return null;
        }
        public Employee createEmployee() {
            System.out.println("Nhập mã khách hàng");
            String id = scanner.nextLine().trim().toUpperCase();
            if (id.startsWith("EMP") && id.length() == 7) {
                System.out.println("Nhập tên khách hàng");
                String name = scanner.nextLine();
                System.out.println("Nhập địa chỉ khách hàng");
                String address  = scanner.nextLine();
                System.out.println("Nhập số tuổi khách hàng");
                int age = Integer.parseInt(scanner.nextLine());
                return new Employee(id,name, address,age);
            }
            return null;
        }
    }


