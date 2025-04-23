package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayrollCalculator {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employees.csv"; // Path to your CSV file
        List<Employee> employees = new ArrayList<>();

        // Read the file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            line = br.readLine();//read header dont try to parse id -- it gives error as "id" is string not integer
            while ((line = br.readLine()) != null) {
                // Split the line by the pipe (|) delimiter
                String[] data = line.split("\\|");

                // Parse the data
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double hoursWorked = Double.parseDouble(data[2]);
                double payRate = Double.parseDouble(data[3]);

                // Create an Employee object and add it to the list
                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Display payroll information for each employee
        System.out.println("Payroll Information:");
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Gross Pay: $" + employee.getGrossPay());
            System.out.println("-----------------------------");
        }
    }
}

    private static void writeCsv(List<Employee> employees, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("id|name|gross pay");
            for (Employee e : employees) {
                writer.printf("%d|%s|%.2f%n", e.getEmployeeId(), e.getName(), e.getGrossPay());
            }
        }
    }
// JSON file write
    private static void writeJson(List<Employee> employees, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("[");
            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);
                writer.printf("  { \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }",
                        e.getEmployeeId(), e.getName(), e.getGrossPay());
                if (i < employees.size() - 1) writer.println(",");
                else writer.println();
            }
            writer.println("]");
        }
    }
}