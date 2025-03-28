package lv.rvt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lv.rvt.tools.Helper;
public class AnimalManager {
    private List<Animal> animals;

    public AnimalManager() {
        animals = new ArrayList<>();
        loadAnimals();
    }

    public void loadAnimals() {
        animals.clear();
        try (BufferedReader reader = Helper.getReader("animals.csv")) {
            reader.readLine(); 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length == 4) {
                    String spicies = parts[0].trim();
                    String breed = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    boolean status = Boolean.parseBoolean(parts[3].trim());
                    animals.add(new Animal(spicies, breed, price, status));
                }
            }
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void showAnimals() {
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-8s | %-18s | %-8s | %-6s |\n", 
                "Spicies", "Breed", "Price", "Status");
        System.out.println("-----------------------------------------------------");

        for (Animal animal: animals) { 
            System.out.printf("| %-8s | %-18s | %-8.2f | %-6s |\n",
                    animal.getSpecies(), animal.getBreed(), 
                    animal.getPrice(), animal.isReserved());
        }

        System.out.println("-----------------------------------------------------");
    }
}
