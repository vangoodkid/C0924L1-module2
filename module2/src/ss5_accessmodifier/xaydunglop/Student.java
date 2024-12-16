package ss5_accessmodifier.xaydunglop;

public class Student {
    private String name = "John";
    private String classees = "C02";

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getClassees() {
        return classees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassees(String classees) {
        this.classees = classees;
    }
}
