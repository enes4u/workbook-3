package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class LiteratureApp {
    public static void main(String[] args) {
        // Array of quotes
        String[] quotes = {
                "The best way to predict the future is to create it.",
                "First I went left, he did too. Then I went right, and he did too. Then I went left again, and he went to buy a hot dog. \"Zlatan Ibrahimovic\"",
                "Messi does not need his right foot, though. He only uses the left and he's still the best in the world! Imagine if he also used his right foot... Then we would have serious problems! \"Zlatan Ibrahimovic\" ",
                "In the middle of every difficulty lies opportunity.",
                "Messi scores a goal and celebrates. Cristiano scores a goal and poses like he's in a shampoo commercial.\"Diego Maradona\"",
                "Believe you can and you're halfway there.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Happiness is not something ready-made. It comes from your own actions.",
                "If you want to live a happy life, tie it to a goal, not to people or things.",
                "The purpose of life is to believe, to hope, and to strive."
        };
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            try {
                System.out.println("\nOptions:");
                System.out.println("1 - Select a quote by number (1-10)");
                System.out.println("2 - Get a random quote");
                System.out.println("0 - Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                } else if (choice == 1) {
                    System.out.print("Enter a number between 1 and 10: ");
                    int quoteNumber = scanner.nextInt();
                    System.out.println("Quote: " + quotes[quoteNumber - 1]);
                } else if (choice == 2) {
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println("Random Quote: " + quotes[randomIndex]);
                } else {
                    System.out.println("Invalid option! Please try again.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid choice! Please select a number between 1 and 10.");
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }
}