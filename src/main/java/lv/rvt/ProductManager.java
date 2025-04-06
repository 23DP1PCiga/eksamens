package lv.rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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

    public void sortByPrice(){
        products.sort(Comparator.comparing(Product::getPrice));
    }

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
}
