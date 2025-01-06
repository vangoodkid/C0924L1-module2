package ss8_mvc.service;

import ss8_mvc.modern.Student;

public interface IStudentService {
    Student[] findAll();
    void addStudent(Student student);
}
