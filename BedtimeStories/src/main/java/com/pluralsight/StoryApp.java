package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;


public class StoryApp {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        String storyHansel = "src/main/resources/hansel_and_gretel.txt";
        String storyMary = "src/main/resources/hansel_and_gretel.txt";

        System.out.println("Choose a file to read:");
        System.out.println("1 - File 1");
        System.out.println("2 - File 2");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();

        // Determine which file to read
        String selectedFile;
        if (choice == 1) {
            selectedFile = storyHansel;
        } else if (choice == 2) {
            selectedFile = storyMary;
        } else {
            System.out.println("Invalid choice! Exiting.");
            scanner.close();
            return;
        }
        try (FileInputStream fis = new FileInputStream(selectedFile);
             Scanner readFile = new Scanner(fis)) {

            int lineNumber = 1;
            while (readFile.hasNextLine()) {
                System.out.println(lineNumber + ": " + readFile.nextLine());
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        scanner.close();
    }
}
