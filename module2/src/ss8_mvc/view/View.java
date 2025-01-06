package ss8_mvc.view;

import ss8_mvc.controller.StudentController;
import ss8_mvc.controller.TeacherController;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        int chose;
        do {
            System.out.println("chon chuc nang: ");
            System.out.println("0 thoat chuong trinh: ");
            System.out.println("1 quan ly sinh vien: ");
            System.out.println("2 quan ly giao vien: ");
            chose = Integer.parseInt(input.nextLine());
            switch (chose){
                case 0 :
                    System.exit(0);
                case 1:
                    studentController.displayStudentMenu();
                    break;
                case 2:
                    teacherController.displayTeacherMenu();
                    break;
            }
        }while (chose!= 0);
    }
}
