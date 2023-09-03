package org.example.app.services.employees;

import org.example.app.controllers.employees.EmployeesCreateController;
import org.example.app.controllers.employees.EmployeesReadController;
import org.example.app.controllers.positions.PositionCreateController;
import org.example.app.controllers.positions.PositionReadController;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.employees.EmployeesCreateRepository;
import org.example.app.repositories.employees.EmployeesReadRepository;
import org.example.app.repositories.positions.PositionCreateRepository;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.services.positions.PositionCreateService;
import org.example.app.services.positions.PositionReadService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeesCreateView;
import org.example.app.views.employees.EmployeesReadView;
import org.example.app.views.positions.PositionCreateView;
import org.example.app.views.positions.PositionReadView;

public class EmployeesService {

    public void createEmployee() {
        EmployeesCreateRepository repository = new EmployeesCreateRepository();
        EmployeesCreateService service = new EmployeesCreateService(repository);
        EmployeesCreateView view = new EmployeesCreateView();
        EmployeesCreateController controller = new EmployeesCreateController(view, service);
        controller.createEmployee();
    }

    public void readEmployees() {
        EmployeesReadRepository repository = new EmployeesReadRepository();
        EmployeesReadService service = new EmployeesReadService(repository);
        EmployeesReadView view = new EmployeesReadView();
        EmployeesReadController controller = new EmployeesReadController(service, view);
        controller.readEmployees();
    }
    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }

}
