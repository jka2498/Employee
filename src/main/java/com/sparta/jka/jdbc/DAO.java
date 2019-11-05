package com.sparta.jka.jdbc;

import com.sparta.jka.logic.Employee;

import javax.swing.text.html.HTMLDocument;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DAO {

    private final String QUERY = "INSERT INTO EmployeeDetails VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String URL = "jdbc:mysql://localhost/employees?user=root&password=password";


    public void insertIntoDB(Map<String, Employee> employees) {

        Employee[] arrayOfEmployees = employees.values().toArray(new Employee[employees.size()]); // converts Map to Array

        int employeesCount = arrayOfEmployees.length;
        Thread[] thread = new Thread[150];
        int threadCount = thread.length;
        int factor = employeesCount / threadCount;


        for (int i = 0; i < thread.length; i++) {
            final int j = i;
            Runnable run;
            if (factor * (i + 1) > employeesCount) {
                run = () -> insert(Arrays.copyOfRange(arrayOfEmployees, (employeesCount * j) / threadCount, arrayOfEmployees.length));

            } else {
                run = () -> insert(Arrays.copyOfRange(arrayOfEmployees, (employeesCount * j) / threadCount, (employeesCount * (j + 1) / threadCount)));
            }

            thread[i] = new Thread(run);
            thread[i].start();
        }
    }


    private void insert(Employee[] employees) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement statement = connection.prepareStatement(QUERY);

            final long startTime = System.currentTimeMillis();
            for (Employee employee : employees) {

                statement.setString(1, employee.getEmpID());
                statement.setString(2, employee.getPrefixName());
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getLastName());
                statement.setString(5, employee.getMiddleInit());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, Date.valueOf(employee.getDob()));
                statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                statement.setDouble(10, employee.getSalary());

                try {
                    statement.executeUpdate();
                } catch (SQLIntegrityConstraintViolationException exc) {
                    exc.printStackTrace();
                }

            }
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) / 1000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public void runToDB(Map<String, Employee> employees) {
//
//
//
//
//
//        try (Connection connection = DriverManager.getConnection(URL)) {
//            PreparedStatement statement = connection.prepareStatement(QUERY);
//
//            for (Employee employee : employees.values()) {
//                statement.setString(1, employee.getEmpID());
//                statement.setString(2, employee.getPrefixName());
//                statement.setString(3, employee.getFirstName());
//                statement.setString(4, employee.getLastName());
//                statement.setString(5, employee.getMiddleInit());
//                statement.setString(6, employee.getGender());
//                statement.setString(7, employee.getEmail());
//                statement.setDate(8, Date.valueOf(employee.getDob()));
//                statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
//                statement.setDouble(10, employee.getSalary());
//                statement.executeUpdate();
//
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        Map<String, Employee> employees = new HashMap<>();
//        runToDB(employees);
//        System.out.println("DAO Running");
//    }


}