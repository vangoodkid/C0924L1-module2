package ss4_object_class;

public class Student {
    int id;
    String name;
    float score;
    public Student(int id, String name,float score){
        this(id,name);
        this.score = score;
    }
    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }
    public Student(){

    }
}
