package org.example.app.controllers.employees;
import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeesCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeesCreateView;

public class EmployeesCreateController {
    EmployeesCreateView view;
    EmployeesCreateService service;

    public EmployeesCreateController(EmployeesCreateView view, EmployeesCreateService service) {
        this.view = view;
        this.service = service;
    }

    public void createEmployee(){
        String[] data = view.getData();
        Employee employee = new Employee();
        employee.setLastName(data[0]);
        employee.setFirstName(data[1]);
        employee.setBirthDate(data[2]);
        employee.setPositionId(Integer.parseInt(data[3]));
        employee.setPhone(data[4]);
        employee.setSalary(Double.parseDouble(data[5]));
        String s = service.createEmployee(employee);
        view.getOutput(s);
        AppStarter.startApp();
    }
}
