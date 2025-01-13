package ss_array_list_crud.modern;

public class Employee {
    public String empId;
    public String fullName;
    public String address;
    public int age;


    public Employee() {
    }

    public Employee(String empId, String fullName, String address, int age) {
        this.empId = empId;
        this.fullName = fullName;
        this.address = address;
        this.age = age;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void doWork() {
        System.out.println(fullName + " đang làm việc");
    }

    public void rest(int minute) {
        System.out.println(fullName + " nghỉ nghơi " + minute);
    }

    public void vacation(String someWhere) {
        System.out.println(fullName + " đang đi du lich ở " + someWhere);
    }

    public void receiveSalary(float amount) {
        System.out.println(fullName + " nhận lương " + amount + "vnd");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

