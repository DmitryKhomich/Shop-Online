package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeesReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeesReadService {
    EmployeesReadRepository employeesReadRepository;

    public EmployeesReadService(EmployeesReadRepository employeesReadRepository) {
        this.employeesReadRepository = employeesReadRepository;
    }

    public String readEmployee(){
        List<Employee> list = employeesReadRepository.readEmployees();
        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((prop) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(prop.getId())
                                .append(", ")
                                .append(prop.getLastName())
                                .append(", ")
                                .append(prop.getFirstName())
                                .append(", ")
                                .append(prop.getBirthDate())
                                .append(", ")
                                .append(prop.getPositionId())
                                .append(", ")
                                .append(prop.getPhone())
                                .append(", ")
                                .append(prop.getSalary())
                                .append("\n")
                );
                return "\n_ Employees ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
