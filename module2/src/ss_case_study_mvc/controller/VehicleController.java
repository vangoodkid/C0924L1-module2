package ss_case_study_mvc.controller;
import ss_case_study_mvc.modern.Car;
import ss_case_study_mvc.modern.Motorcycle;
import ss_case_study_mvc.modern.Truck;
import ss_case_study_mvc.modern.Vehicle;
import ss_case_study_mvc.service.VehicleService;


import java.util.List;
import java.util.Scanner;

public class VehicleController {
    private VehicleService vehicleService;
    private Scanner scanner;

    public VehicleController() {
        vehicleService = new VehicleService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("----- Quản lý phương tiện giao thông -----");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện.");
            System.out.println("3. Xóa phương tiện.");
            System.out.println("4. Thoát.");
            System.out.print("Chọn một chức năng: ");

            choice = getValidInteger();
            switch (choice) {
                case 1: addNewVehicle(); break;
                case 2: displayVehicles(); break;
                case 3: deleteVehicle(); break;
                case 4: System.out.println("Thoát chương trình."); break;
                default: System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private void addNewVehicle() {
        System.out.println("Chọn loại phương tiện:");
        System.out.println("1. Thêm xe tải");
        System.out.println("2. Thêm ôtô");
        System.out.println("3. Thêm xe máy");

        int choice = getValidInteger();
        switch (choice) {
            case 1: addTruck(); break;
            case 2: addCar(); break;
            case 3: addMotorcycle(); break;
            default: System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void addTruck() {
        Vehicle truck = createVehicle("Truck");
        if (truck != null) vehicleService.addVehicle(truck);
    }

    private void addCar() {
        Vehicle car = createVehicle("Car");
        if (car != null) vehicleService.addVehicle(car);
    }

    private void addMotorcycle() {
        Vehicle motorcycle = createVehicle("Motorcycle");
        if (motorcycle != null) vehicleService.addVehicle(motorcycle);
    }

    private Vehicle createVehicle(String type) {
        System.out.print("Nhập biển số: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = getValidInteger();
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        switch (type) {
            case "Truck":
                System.out.print("Nhập tải trọng (tấn): ");
                double loadCapacity = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return new Truck(licensePlate, manufacturer, year, owner, loadCapacity);
            case "Car":
                System.out.print("Nhập số ghế: ");
                int seatCount = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Nhập loại xe: ");
                String carType = scanner.nextLine();
                return new Car(licensePlate, manufacturer, year, owner, seatCount, carType);
            case "Motorcycle":
                System.out.print("Nhập công suất động cơ (mã lực): ");
                double enginePower = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return new Motorcycle(licensePlate, manufacturer, year, owner, enginePower);
            default:
                System.out.println("Loại phương tiện không hợp lệ.");
                return null;
        }
    }

    private void displayVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        vehicles.forEach(System.out::println);
    }

    private void deleteVehicle() {
        System.out.print("Nhập biển số phương tiện cần xóa: ");
        String licensePlate = scanner.nextLine();
        boolean deleted = vehicleService.deleteVehicleByLicensePlate(licensePlate);
        System.out.println(deleted ? "Đã xóa phương tiện." : "Không tìm thấy phương tiện với biển số đã nhập.");
    }

    private int getValidInteger() {
        while (!scanner.hasNextInt()) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }
}