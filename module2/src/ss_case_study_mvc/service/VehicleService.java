package ss_case_study_mvc.service;

import ss_case_study_mvc.modern.Car;
import ss_case_study_mvc.modern.Motorcycle;
import ss_case_study_mvc.modern.Truck;
import ss_case_study_mvc.modern.Vehicle;
import ss_case_study_mvc.until.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
public class VehicleService {

    private final String CAR_FILE = "/Users/phamvan/Documents/module2/module2/src/ss_case_study_mvc/data/car/car.csv";
    private final String TRUCK_FILE = "/Users/phamvan/Documents/module2/module2/src/ss_case_study_mvc/data/car/motorcycle.csv";
    private final String MOTORCYCLE_FILE = "/Users/phamvan/Documents/module2/module2/src/ss_case_study_mvc/data/car/truck.csv";

    public void addVehicle(Vehicle vehicle) {
        String fileName = getFileName(vehicle);
        ReadAndWrite.writeFile(fileName, List.of(vehicle.toCSV()), true);
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(readVehicles(CAR_FILE, Car.class));
        vehicles.addAll(readVehicles(TRUCK_FILE, Truck.class));
        vehicles.addAll(readVehicles(MOTORCYCLE_FILE, Motorcycle.class));
        return vehicles;
    }

    public boolean deleteVehicleByLicensePlate(String licensePlate) {
        return deleteFromFile(CAR_FILE, licensePlate) ||
                deleteFromFile(TRUCK_FILE, licensePlate) ||
                deleteFromFile(MOTORCYCLE_FILE, licensePlate);
    }

    private List<Vehicle> readVehicles(String fileName, Class<? extends Vehicle> vehicleClass) {
        List<Vehicle> vehicles = new ArrayList<>();
        List<String> lines = ReadAndWrite.readFile(fileName);

        for (String line : lines) {
            Vehicle vehicle = createVehicleFromCSV(line, vehicleClass);
            if (vehicle != null) {
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    private boolean deleteFromFile(String fileName, String licensePlate) {
        List<String> lines = ReadAndWrite.readFile(fileName);
        List<String> updatedList = new ArrayList<>();
        boolean found = false;

        for (String line : lines) {
            if (!line.contains(licensePlate)) {
                updatedList.add(line);
            } else {
                found = true;
            }
        }

        if (found) {
            ReadAndWrite.writeFile(fileName, updatedList, false);
        }
        return found;
    }

    private Vehicle createVehicleFromCSV(String csvLine, Class<? extends Vehicle> vehicleClass) {
        String[] data = csvLine.split(",");
        try {
            if (vehicleClass == Car.class) {
                return new Car(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Integer.parseInt(data[4]), data[5]);
            } else if (vehicleClass == Truck.class) {
                return new Truck(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Double.parseDouble(data[4]));
            } else if (vehicleClass == Motorcycle.class) {
                return new Motorcycle(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Double.parseDouble(data[4]));
            }
        } catch (Exception e) {
            System.out.println("Lỗi chuyển đổi dữ liệu từ CSV: " + e.getMessage());
        }
        return null;
    }

    private String getFileName(Vehicle vehicle) {
        if (vehicle instanceof Car) return CAR_FILE;
        if (vehicle instanceof Truck) return TRUCK_FILE;
        if (vehicle instanceof Motorcycle) return MOTORCYCLE_FILE;
        return null;
    }
}
