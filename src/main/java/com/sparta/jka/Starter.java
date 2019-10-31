package com.sparta.jka;

import com.sparta.jka.logic.Employee;
import com.sparta.jka.logic.EmployeeManager;
import com.sparta.jka.readers.ReaderFile;

import java.io.File;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.addEmployeeDetails();

    }
}
