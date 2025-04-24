import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: $" + price;
    }

    // Method to load inventory
    //  bonus1
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        String fileName = "src/main/resources/inventory.csv " ; // Replace with actual path if necessary "inventory.csv"

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);
                inventory.add(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return inventory;
    }

    // Method to list all products
    public static void listAllProducts(ArrayList<Product> inventory) {
        Collections.sort(inventory, Comparator.comparing(Product::getName)); // Sort by name
        System.out.println("\nProduct Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Method to lookup product by ID
    public static void lookupProductById(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter product ID to search: ");
        int id = scanner.nextInt();
        for (Product product : inventory) {
            if (product.getProductId() == id) {
                System.out.println("Product found: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    // Method to find products within a price range
    public static void findProductsByPriceRange(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        System.out.println("Products in price range $" + minPrice + " to $" + maxPrice + ":");
        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
            }
        }
    }

    // Method to add a new product
    public static void addNewProduct(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product newProduct = new Product(id, name, price);
        inventory.add(newProduct);
        System.out.println("Product added successfully!");
    }

}

