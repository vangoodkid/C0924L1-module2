package ss8_CRUD.controller;

import ss8_CRUD.modern.Customer;
import ss8_CRUD.service.CustomerService;

import java.util.Scanner;

public class CustomerController {
    CustomerService customerService = new CustomerService();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Hiển thị danh sách khách hàng");
            System.out.println("2.Thêm khách hàng:");
            System.out.println("3.Xóa khách hàng:");
            System.out.println("4.Cập nhật khách hàng:");
            System.out.println("5. Thoát chương trình");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> {
                    Customer[] customers = customerService.findAll();
                    for (Customer customer : customers){
                        if (customer == null){
                            break;
                        }
                        System.out.println(customer);
                    }
                }
                case 2 -> customerService.addCustomer();
                case 3 -> customerService.deleteCustomer();
                case 4 -> customerService.updateCustomer();
                case 5 -> System.out.println("Kết thúc chương trình");
            }
        }while (choice != 5);
    }
}
