package lv.rvt;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import lv.rvt.tools.Helper;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        loadProducts();
    }

    public void loadProducts() {
        products.clear();
        try (BufferedReader reader = Helper.getReader("products.csv")) {
            reader.readLine(); 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length == 4) {
                    Integer number = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String category = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    products.add(new Product(number, name, category, price));
                }
            }
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    //1
    public void showProducts() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %3s | %-23s | %-12s | %-6s |\n", 
                "Nr.","Name", "Category", "Price");
        System.out.println("---------------------------------------------------------");

        for (Product product : products) { 
            System.out.printf("| %3d | %-23s | %-12s | %-6.2f |\n",
                    product.getNumber(),product.getName(), product.getCategory(), 
                    product.getPrice());
        }

        System.out.println("---------------------------------------------------------"); 
    }

      //2
      public void sortByCategory(String category){
        System.out.println("Products in " + category + " category: ");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %3s | %-23s | %-12s | %-6s |\n", 
                "Nr.","Name", "Category", "Price");
        System.out.println("---------------------------------------------------------");

        boolean found = false;
        for(Product p : products){
            if(p.getCategory().toLowerCase().equalsIgnoreCase(category)){
                System.out.printf("| %3d | %-23s | %-12s | %-6.2f |\n",
                    p.getNumber(),p.getName(), p.getCategory(), p.getPrice());
                    found = true;
            }
        }
        if(!found){
            System.out.println("|                 No results found                      |");
        }
        System.out.println("---------------------------------------------------------"); 
    }

    //3
    public void sortByPrice(String word){
        word = word.trim().toLowerCase();
        switch (word) {
            case "c":
                products.sort(Comparator.comparing(Product::getPrice));
                showProducts();
                break;
            case "e":
                products.sort(Comparator.comparing(Product::getPrice).reversed());
                showProducts();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    

    //4
    public void searchByName(String keyword){
        System.out.println("Results:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %3s | %-23s | %-12s | %-6s |\n", 
                "Nr.","Name", "Category", "Price");
        System.out.println("---------------------------------------------------------");

        boolean found = false;
        for(Product p : products){
            if(p.getName().toLowerCase() .contains(keyword.toLowerCase())){
                System.out.printf("| %3d | %-23s | %-12s | %-6.2f |\n",
                    p.getNumber(),p.getName(), p.getCategory(), p.getPrice());
                    found = true;
            }
        }
        if(!found){
            System.out.println("|                 No results found                      |");
        }
        System.out.println("---------------------------------------------------------"); 
    }

    //5
    public void addProductToCart(Scanner scanner, User user){
        while (true) {
            showProducts();
            System.out.println();
            System.out.print("Enter product number to add to cart (or 0 to finish): ");
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number == 0) {
                    System.out.println("Finished adding products to cart. ");
                    break;
                }
                boolean found = false;
                for (Product p : products) {
                    if (p.getNumber() == number) {
                        user.addToCart(p);
                        System.out.printf("Product '%s' added to cart.\n", p.getName());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(" Product with that number not found.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input.");
            }
        }
    }
    
}
