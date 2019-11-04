package com.sparta.jka.readers;

import com.sparta.jka.jdbc.DAO;
import com.sparta.jka.logic.Employee;
import com.sparta.jka.logic.EmployeeManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ReaderFile {

    public Map<String, Employee> readFile() {
        Map<String, Employee> employeeHashMap = new HashMap<>();
        Map<String, Employee> duplicates = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");

                if (!employeeHashMap.containsKey(details[0])) {
                    employeeHashMap.put(details[0], new Employee(details[0], details[1], details[2], details[3], details[4],
                            details[5], details[6], formatDate(details[7]),
                            formatDate(details[8]), Integer.parseInt(details[9])));
                } else if (!duplicates.containsKey(details[0])) {
                    duplicates.put(details[0], new Employee(details[0], details[1], details[2], details[3], details[4],
                            details[5], details[6], formatDate(details[7]),
                            formatDate(details[8]), Integer.parseInt(details[9])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Not Found");
        }
        return employeeHashMap;
    }


    private LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public File getFile() {
        File file = new File("resources/EmployeeRecords.csv");
        return file;
    }

}


