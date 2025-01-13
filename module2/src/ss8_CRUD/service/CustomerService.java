package ss8_CRUD.service;

import ss8_CRUD.modern.Customer;

import java.util.Scanner;

public class CustomerService {
    Scanner scanner = new Scanner(System.in);
    static Customer[] customers = new Customer[10];

    static {
        customers[0] = new Customer("CUS1001", "Lê tuấn cường", "20/2/2001", "hà nội");
        customers[1] = new Customer("CUS1002", "Lê tuấn mạnh", "20/2/2003", "đà nẵng");
        customers[2] = new Customer("CUS1003", "Lê tuấn minh", "20/2/2004", "huế");
    }
    int count = 3;
    public Customer[] findAll(){
        return customers;
    }
    public void addCustomer() {
       var customer = createCustomer();
       if (customer != null){
           customers[count++] = customer;
           System.out.println("Thêm khách hàng thành công");
       }else {
           System.out.println("Lỗi nhập sai mã nhân viên");
       }

    }
    public Customer createCustomer() {
        System.out.println("Nhập mã khách hàng");
        String id = scanner.nextLine().trim().toUpperCase();
        if (id.startsWith("CUS") && id.length() == 7) {
            System.out.println("Nhập tên khách hàng");
            String name = scanner.nextLine();
            System.out.println("Nhập ngày sinh khách hàng");
            String birthDay = scanner.nextLine();
            System.out.println("Nhập địa chỉ khách hàng");
            String address = scanner.nextLine();
            return new Customer(id, name, birthDay, address);
        }
        return null;
    }
    public void deleteCustomer(){
        System.out.println("Nhập id cần xóa: ");
        String id = scanner.nextLine();
        int index = findCustomerById(id);
        if (index != 1){
            for (int i = index ; i < customers.length ; i++) {
                customers[index] = customers[index + 1];
            }
            System.out.println("Xóa thành công");
        }else {
            System.out.println("Mã khách hàng không tồn tại");
        }
    }
    public void updateCustomer(){
        System.out.println("Nhập id cần sửa: ");
        String id = scanner.nextLine();
        int index = findCustomerById(id);
        if (index != -1){
            System.out.println("Nhập id mới: ");
            customers[index].id = scanner.nextLine();
            System.out.println("Nhập họ và tên mới: ");
            customers[index].name = scanner.nextLine();
            System.out.println("Nhập ngày sinh mới: ");
            customers[index].birthday = scanner.nextLine();
            System.out.println("Nhập địa chỉ mới");
            customers[index].address = scanner.nextLine();
            System.out.println("Cập nhật thành công");
        }else {
            System.out.println("Không tìm thấy mã khách hàng tồn tại");
        }

    }
    public int findCustomerById(String id){
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null){
                break;
            }
            if (customers[i].getId().compareToIgnoreCase(id) == 0){
                return i;
            }
        }
        return -1;
    }


}
