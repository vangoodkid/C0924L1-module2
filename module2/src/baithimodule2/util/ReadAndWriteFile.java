package baithimodule2.util;

import baithimodule2.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static void writeFile(String filePath, List<String> stringList, boolean append) {
        if (filePath == null || stringList == null) {
            System.out.println("Đường dẫn file hoặc danh sách chuỗi không hợp lệ.");
            return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, append))) {
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi vào file: " + e.getMessage());
        }
    }

    // Phương thức đọc từ file cho danh bạ
    public static List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        if (filePath == null) {
            System.out.println("Đường dẫn file không hợp lệ.");
            return stringList;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Kiểm tra xem dòng không trống trước khi thêm vào danh sách
                if (!line.trim().isEmpty()) {
                    stringList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi đọc từ file: " + e.getMessage());
        }

        return stringList;
    }

    // Phương thức ghi danh bạ vào file
    public static void writeContactsToFile(String filePath, List<Contact> contacts, boolean append) {
        List<String> contactStringList = new ArrayList<>();
        for (Contact contact : contacts) {
            contactStringList.add(contact.getInfoContact()); // Giả sử có phương thức getInfoContact trong Contact
        }
        writeFile(filePath, contactStringList, append);
    }

    // Phương thức đọc danh bạ từ file
    public static List<Contact> readContactsFromFile(String filePath) {
        List<String> stringList = readFile(filePath);
        List<Contact> contacts = new ArrayList<>();
        for (String contactString : stringList) {
            String[] contactArray = contactString.split(",");
            // Kiểm tra độ dài của mảng để tránh lỗi ArrayIndexOutOfBoundsException
            if (contactArray.length == 5) {
                contacts.add(new Contact(
                        contactArray[0], // name
                        contactArray[1], // phone
                        contactArray[2], // address
                        contactArray[3], // email
                        contactArray[4]  // facebook
                ));
            } else {
                System.out.println("Dòng không hợp lệ: " + contactString);
            }
        }
        return contacts;
    }
}