package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesReadRepository {
    List<Employee> list;

    public List<Employee> readEmployees() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Employee(rs.getInt("id"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("birthDate"),
                        rs.getInt("positionId"),
                        rs.getString("phone"),
                        rs.getDouble("salary")));

            }
            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
