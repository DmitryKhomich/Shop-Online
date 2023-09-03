package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.exceptions.PositionCreateException;
import org.example.app.repositories.employees.EmployeesCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EmployeesCreateService {
    EmployeesCreateRepository employeesCreateRepository;

    public EmployeesCreateService(EmployeesCreateRepository employeesCreateRepository) {
        this.employeesCreateRepository = employeesCreateRepository;
    }

    public String createEmployee (Employee employee){
        Map<String, String> errors = new HashMap<>();
        if (employee.getLastName().isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);
        if (employee.getFirstName().isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);
        if (employee.getBirthDate().isEmpty())
            errors.put("birth date", Constants.INPUT_REQ_MSG);
        if (employee.getPositionId() == 0)
            errors.put("positionId", Constants.INPUT_REQ_MSG);
        if (employee.getPhone().isEmpty())
            errors.put("phone", Constants.INPUT_REQ_MSG);
        if (employee.getSalary() == 0)
            errors.put("salary", Constants.INPUT_REQ_MSG);

        if (!errors.isEmpty()) {
            try {
                throw new PositionCreateException("Check inputs", errors);
            } catch (PositionCreateException e) {
                return e.getErrors(errors);
            }
        }
        return employeesCreateRepository.createEmployee(employee);
    }
}
