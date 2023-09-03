package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesCreateRepository {
    public String createEmployee(Employee employee) {
        String sql = "INSERT INTO " + Constants.TABLE_EMPLOYEES + "(lastName, firstName, birthDate, positionId, phone, salary) \n" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getBirthDate());
            pstmt.setString(4, String.valueOf(employee.getPositionId()));
            pstmt.setString(5, employee.getPhone());
            pstmt.setString(6, String.valueOf(employee.getSalary()));
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
