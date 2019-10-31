package com.sparta.jka.jdbc;


import com.sparta.jka.logic.Employee;
import com.sparta.jka.logic.EmployeeManager;
import com.sparta.jka.readers.ReaderFile;

import javax.management.Query;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DAO {

    private final String QUERY = "INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?)";
    private final String URL ="jdbc:mysql://localhost/employees?user=root&password=password";

    public void runToDB(Map<String, Employee> employees){

        try(Connection connection = DriverManager.getConnection(URL)){
            PreparedStatement statement = connection.prepareStatement(QUERY);

            for (Employee employee: employees) {
                statement.setString(1, employee.getEmpID() );
                statement.setString(2, employee.getPrefixName() );
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getLastName());
                statement.setString(5, employee.getGender());
                statement.setString(6, employee.getEmail());
                statement.setString(7, Date.valueOf(employee.getDob()));
                statement.setString(8, Date.valueOf(employee.getEmail()));
                statement.setString(9, Double.toString(employee.getSalary()));
                statement.executeUpdate();
            }

        }catch (SQLException e ){
        }
    }
}