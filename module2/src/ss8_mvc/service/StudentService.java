package ss8_mvc.service;

import ss8_mvc.modern.Student;

public class StudentService implements  IStudentService {
    public static Student[] students = new Student[10];
    static {
        students[0] = new Student(1,"van");
        students[1] = new Student(2,"tuan");
        students[2] = new Student(3,"minh");
    }

    @Override
    public Student[] findAll() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (student != null){
                students[i] = student;
                break;
            }
        }
    }
}
