package ss8_mvc.controller;

import ss8_mvc.modern.Student;
import ss8_mvc.modern.Teacher;
import ss8_mvc.service.ITeacherService;
import ss8_mvc.service.TeacherService;
import java.util.Scanner;

public class TeacherController {
    public ITeacherService teacherService = new TeacherService();

    public void displayTeacherMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn chức năng \n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3.  Xoá \n" +
                    "4. Thoát");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    Teacher[] teachers = teacherService.findAll();
                    for(Teacher teacher: teachers){
                        if(teacher != null){
                            System.out.println(teacher);
                        }
                    }                case 2:
                    System.out.println("nhap id: ");
                    int id = Integer.parseInt(input.nextLine());
                    System.out.println("nhap ten: ");
                    String name = input.nextLine();

                    Teacher teacher = new Teacher(id,name);
                    teacherService.addTeacher(teacher);
                case 3:
                    System.out.println("------------- xoá ----------------------");
                    break;
                case 4:
                    System.out.println("-------- Kết thúc----------------------");
                    flag = false;
            }
        }
    }
}
