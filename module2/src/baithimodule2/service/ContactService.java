package baithimodule2.service;

import baithimodule2.model.Contact;
import baithimodule2.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService implements IContactService {
    private final String CONTACTS_FILE = "/Users/phamvan/Documents/module2/module2/src/baithimodule2/data/contact.csv"; // Đường dẫn đến file danh bạ
    private final boolean APPEND = true;
    private final boolean NOT_APPEND = false;

    public void readContactsFromFile() {
        List<Contact> contacts = ReadAndWriteFile.readContactsFromFile(CONTACTS_FILE);
        if (!contacts.isEmpty()) {
            System.out.println("Đã đọc danh bạ từ file.");
        } else {
            System.out.println("Không có danh bạ nào trong file.");
        }
        writeAllContacts(contacts);
    }

    public void writeAllContactsToFile() {
        List<Contact> contacts = getAllContacts();
        ReadAndWriteFile.writeContactsToFile(CONTACTS_FILE, contacts, NOT_APPEND);
    }
    @Override
    public List<Contact> getAllContacts() {
        List<String> contactStringList = ReadAndWriteFile.readFile(CONTACTS_FILE);
        List<Contact> contacts = new ArrayList<>();
        for (String contactString : contactStringList) {
            String[] contactArray = contactString.split(",");
            contacts.add(new Contact(
                    contactArray[0], // name
                    contactArray[1], // phone
                    contactArray[2], // address
                    contactArray[3], // email
                    contactArray[4]  // facebook
            ));
        }
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        List<String> contactStringList = new ArrayList<>();
        contactStringList.add(contact.getInfoContact());
        ReadAndWriteFile.writeFile(CONTACTS_FILE, contactStringList, APPEND);
    }

    @Override
    public boolean deleteContactById(String id) {
        List<Contact> contacts = getAllContacts();
        boolean isExist = contacts.removeIf(contact -> contact.getFullName().equals(id)); // Giả sử dùng tên làm id
        if (isExist) {
            writeAllContacts(contacts);
        }
        return isExist;
    }

    @Override
    public boolean updateContactById(String id) {
        List<Contact> contacts = getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFullName().equals(id)) {
                System.out.println("Danh bạ cần cập nhật: " + contacts.get(i));
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập số điện thoại mới: ");
                String newPhone = sc.nextLine();
                System.out.print("Nhập địa chỉ mới: ");
                String newAddress = sc.nextLine();
                System.out.print("Nhập email mới: ");
                String newEmail = sc.nextLine();
                System.out.print("Nhập facebook mới: ");
                String newFacebook = sc.nextLine();
                contacts.set(i, new Contact(id, newPhone, newAddress, newEmail, newFacebook));
                writeAllContacts(contacts);
                return true;
            }
        }
        return false;
    }


    @Override
    public Contact getContactById(String id) {
        return getAllContacts().stream()
                .filter(contact -> contact.getFullName().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void writeAllContacts(List<Contact> contacts) {
        List<String> contactStringList = new ArrayList<>();
        for (Contact contact : contacts) {
            contactStringList.add(contact.getInfoContact());
        }
        ReadAndWriteFile.writeFile(CONTACTS_FILE, contactStringList, NOT_APPEND);
    }
}