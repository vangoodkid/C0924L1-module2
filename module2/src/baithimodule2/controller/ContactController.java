package baithimodule2.controller;

import baithimodule2.model.Contact;
import baithimodule2.service.ContactService;

import java.util.List;
import java.util.Scanner;

public class ContactController {
    private ContactService contactService = new ContactService();

    public void displayContactMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = getChoice(scanner);
            handleChoice(choice, scanner);
        }
    }

    private void showMenu() {
        System.out.println("Chọn chức năng: \n" +
                "1. Xem toàn bộ danh bạ\n" +
                "2. Thêm danh bạ mới\n" +
                "3. Xóa danh bạ\n" +
                "4. Chỉnh sửa thông tin danh bạ\n" +
                "5. Tìm kiếm danh bạ\n" +
                "6. Đọc danh bạ từ file\n" +
                "7. Ghi danh bạ vào file\n" +
                "8. Thoát.");
    }

    private int getChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 8) {
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
                displayAllContacts();
                break;
            case 2:
                addContact(scanner);
                break;
            case 3:
                deleteContact(scanner);
                break;
            case 4:
                updateContact(scanner);
                break;
            case 5:
                searchContact(scanner);
                break;
            case 6:
                readContactsFromFile(scanner);
                break;
            case 7:
                writeContactsToFile(scanner);
                break;
            case 8:
                System.exit(0);
                break;
        }
    }
    private void readContactsFromFile(Scanner scanner) {
        System.out.print("Bạn có chắc chắn muốn cập nhật danh bạ từ file? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            contactService.readContactsFromFile();
            System.out.println("Danh bạ đã được cập nhật từ file.");
        } else {
            System.out.println("Cập nhật danh bạ đã bị hủy.");
        }
    }

    private void writeContactsToFile(Scanner scanner) {
        System.out.print("Bạn có chắc chắn muốn lưu danh bạ vào file? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            contactService.writeAllContactsToFile();
            System.out.println("Danh bạ đã được lưu vào file thành công.");
        } else {
            System.out.println("Lưu danh bạ đã bị hủy.");
        }
    }

    private void displayAllContacts() {
        System.out.println("Danh sách các danh bạ:");
        List<Contact> contacts = contactService.getAllContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private void addContact(Scanner scanner) {
        System.out.print("Nhập họ tên danh bạ mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập số điện thoại danh bạ mới: ");
        String newPhone = scanner.nextLine();
        System.out.print("Nhập địa chỉ danh bạ mới: ");
        String newAddress = scanner.nextLine();
        System.out.print("Nhập email danh bạ mới: ");
        String newEmail = scanner.nextLine();
        System.out.print("Nhập facebook danh bạ mới: ");
        String newFacebook = scanner.nextLine();

        contactService.addContact(new Contact(newName, newPhone, newAddress, newEmail, newFacebook));
        System.out.println("Đã thêm danh bạ mới.");
    }

    private void deleteContact(Scanner scanner) {
        System.out.print("Nhập họ tên danh bạ cần xóa: ");
        String deleteName = scanner.nextLine();
        boolean isDeleted = contactService.deleteContactById(deleteName);
        if (isDeleted) {
            System.out.println("Xóa danh bạ có họ tên: " + deleteName + " thành công");
        } else {
            System.out.println("Không tìm thấy danh bạ có họ tên: " + deleteName);
        }
    }

    private void updateContact(Scanner scanner) {
        System.out.print("Nhập họ tên danh bạ cần chỉnh sửa: ");
        String nameToUpdate = scanner.nextLine(); // Sử dụng tên làm id
        boolean isUpdated = contactService.updateContactById(nameToUpdate);
        if (isUpdated) {
            System.out.println("Cập nhật danh bạ có họ tên: " + nameToUpdate + " thành công");
        } else {
            System.out.println("Không tìm thấy danh bạ có họ tên: " + nameToUpdate);
        }
    }


    private void searchContact(Scanner scanner) {
        System.out.print("Nhập họ tên danh bạ cần tìm: ");
        String searchName = scanner.nextLine();
        Contact contact = contactService.getContactById(searchName);
        if (contact != null) {
            System.out.println("Tìm thấy danh bạ: " + contact);
        } else {
            System.out.println("Không tìm thấy danh bạ có họ tên: " + searchName);
        }
    }
}
