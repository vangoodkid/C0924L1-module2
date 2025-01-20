package ss_case_study_mvc.view;
import ss_case_study_mvc.controller.VehicleController;
public class Main {
    public static void main(String[] args) {
        VehicleController controller = new VehicleController();
        controller.showMenu();
    }
}
