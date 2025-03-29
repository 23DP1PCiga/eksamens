package lv.rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                if (parts.length == 5) {
                    Integer number = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String category = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    boolean inStock = Boolean.parseBoolean(parts[4].trim());
                    products.add(new Product(number, name, category, price, inStock));
                }
            }
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void showProducts() {
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %3s | %-23s | %-12s | %-6s | %-8s |\n", 
                "Nr.","Name", "Category", "Price", "In Stock");
        System.out.println("--------------------------------------------------------------------");

        for (Product product : products) { 
            System.out.printf("| %3d | %-23s | %-12s | %-6.2f | %-8s |\n",
                    product.getNumber(),product.getName(), product.getCategory(), 
                    product.getPrice(), product.inStock());
        }

        System.out.println("--------------------------------------------------------------------"); 
    }
}
