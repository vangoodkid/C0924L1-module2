package ss8_mvc.service;

import ss8_mvc.modern.Teacher;

public class TeacherService implements ITeacherService{
    public static Teacher[] teachers = new Teacher[10];
    static {
        teachers[0] = new Teacher(1,"binh");
        teachers[1] = new Teacher(2,"phuoc");
        teachers[2] = new Teacher(3,"khoi");
    }

    @Override
    public Teacher[] findAll() {
        return teachers;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teacher != null){
                teachers[i] = teacher;
                break;
            }
        }
    }
}
