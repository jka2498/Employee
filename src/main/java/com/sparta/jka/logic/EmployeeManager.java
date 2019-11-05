package com.sparta.jka.logic;

import com.sparta.jka.jdbc.DAO;
import com.sparta.jka.readers.ReaderFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManager {

    public void addEmployeeDetails() {

        ReaderFile readerFile = new ReaderFile();
        Map<String, Employee> employees = readerFile.readFile();
        DAO dao = new DAO();
        dao.insertIntoDB(employees);
        System.out.println(employees.size());

    }
}
