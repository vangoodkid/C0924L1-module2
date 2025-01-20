package ss_read_write_file.modern;

public class Employee {
    private String id;
    private String name;
    private String address;
    private int age;

    public Employee(String id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getInfoEmployee() {
        return id + "," + name + "," + address + "," + age;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', address='" + address + "', age=" + age + "}";
    }
}