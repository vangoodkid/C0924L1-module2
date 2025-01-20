package ss_read_write_file.service;

import ss_read_write_file.modern.Employee;
import java.util.List;

public interface IEmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployee();
    boolean deleteEmployeeById(String id);
    boolean updateEmployeeById(String id);
    Employee getEmployeeById(String id);
}
