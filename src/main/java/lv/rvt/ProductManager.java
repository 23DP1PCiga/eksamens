package lv.rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
private List<Product> products;
private static final String FILE_NAME = "products.csv";

public ProductManager(){
    products = new ArrayList<>();
    loadFromCSV();
}

public void showAnimals(){
    
}

public void loadFromCSV() {
    products.clear(); 
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        reader.readLine(); 
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 4) {
                String name = data[0];
                String category = data[1];
                double price = Double.parseDouble(data[2]);
                boolean inStock = Boolean.parseBoolean(data[3]);
                products.add(new Product(name, category, price, inStock));
            }
        }
    } catch (IOException e) {
        System.out.println("");
    }
}

       
}   
