package ss_case_study_mvc.service;

import ss_case_study_mvc.modern.Vehicle;

import java.util.List;

public interface IVehicleService {
        void addVehicle(Vehicle vehicle);
        void displayAllVehicles();
        boolean deleteVehicleByPlate(String plateNumber);
        List<Vehicle> loadVehiclesFromFile(String fileName);
}
