package ss5_accessmodifier.xaydunglop;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
        System.out.println(student.getClassees());

        student.setName("pham van");
        student.setClassees("C03");

        System.out.println("sau khi thay doi");
        System.out.println(student.getName());
        System.out.println(student.getClassees());

    }
}
