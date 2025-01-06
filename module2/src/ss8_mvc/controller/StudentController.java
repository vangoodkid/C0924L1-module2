package ss8_mvc.controller;

import ss8_mvc.modern.Student;
import ss8_mvc.service.StudentService;

import java.util.Scanner;

public class StudentController {
    public StudentService studentService = new StudentService();
    public void displayStudentMenu(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("chon chuc nang: ");
            System.out.println("1. xem danh sach: ");
            System.out.println("2. them moi: ");
            System.out.println("3. xoa: ");
            System.out.println("4. thoat");
            int chose = Integer.parseInt(input.nextLine());
            switch (chose){
                case 1:
                    Student[] students = studentService.findAll();
                    for(Student student: students){
                        if(student != null){
                            System.out.println(student);
                        }
                    }
                    break;
                case 2:
                    System.out.println("nhap id: ");
                    int id = Integer.parseInt(input.nextLine());
                    System.out.println("nhap ten: ");
                    String name = input.nextLine();

                    Student student = new Student(id,name);
                    studentService.addStudent(student);
                    break;
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
