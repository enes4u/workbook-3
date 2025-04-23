package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input and output file names
        System.out.print("Enter the name and path of the employee file to process: "); // if user dont enter path it does not work

        String inputFile = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        List<Employee> employees = new ArrayList<>();

        // Read employee data from input CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double hoursWorked = Double.parseDouble(data[2]);
                double payRate = Double.parseDouble(data[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Write payroll information to output file
        try {
            if (outputFile.endsWith(".json")) {
                writeJson(employees, outputFile);
            } else {
                writeCsv(employees, outputFile);
            }
            System.out.println("Payroll file created successfully: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
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