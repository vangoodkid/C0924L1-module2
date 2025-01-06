package ss8_mvc.service;

import ss8_mvc.modern.Teacher;

public interface ITeacherService {
    Teacher[] findAll();
    void addTeacher(Teacher teacher);
}
