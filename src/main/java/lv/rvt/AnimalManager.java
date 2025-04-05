package lv.rvt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
                if (parts.length == 5) {
                    Integer number = Integer.parseInt(parts[0].trim());
                    String species = parts[1].trim();
                    String breed = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    boolean reserved = Boolean.parseBoolean(parts[4].trim());
                    animals.add(new Animal(number, species, breed, price, reserved));
                }
            }
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void showAnimals() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %3s | %-8s | %-18s | %-8s | %-8s |\n", 
                "Nr.","Species", "Breed", "Price", "Reserved");
        System.out.println("-------------------------------------------------------------");

        for (Animal animal : animals) { 
            System.out.printf("| %3d | %-8s | %-18s | %-8.2f | %-8s |\n",
                    animal.getNumber(), animal.getSpecies() , animal.getBreed(),
                    animal.getPrice(), animal.isReserved());
        }

        System.out.println("-------------------------------------------------------------");
    }

    
}
