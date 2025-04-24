import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class SearchInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> inventory = Product.getInventory();

        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Product.listAllProducts(inventory);
                    break;
                case 2:
                    Product.lookupProductById(inventory, scanner);
                    break;
                case 3:
                    Product.findProductsByPriceRange(inventory, scanner);
                    break;
                case 4:
                    Product.addNewProduct(inventory, scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }



}