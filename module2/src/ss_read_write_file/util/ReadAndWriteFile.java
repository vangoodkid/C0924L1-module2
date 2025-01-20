package ss_read_write_file.util;
import ss_read_write_file.modern.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    // Phương thức ghi vào file
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

    // Phương thức đọc từ file
    public static List<String> readFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        if (filePath == null) {
            System.out.println("Đường dẫn file không hợp lệ.");
            return stringList;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi đọc từ file: " + e.getMessage());
        }

        return stringList;
    }
}