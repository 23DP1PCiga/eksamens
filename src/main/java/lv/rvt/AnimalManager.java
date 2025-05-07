package lv.rvt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
                    boolean reserved = parts[4].trim().equalsIgnoreCase("reserved");
                    animals.add(new Animal(number, species, breed, price, reserved));
                }
            }
        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
    }


    public void showAnimals() {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %3s | %-8s | %-18s | %-8s | %-9s |\n", 
                "Nr.","Species", "Breed", "Price", "Status");
        System.out.println("--------------------------------------------------------------");

        for (Animal animal : animals) { 
            System.out.printf("| %3d | %-8s | %-18s | %-8.2f | %-9s |\n",
                    animal.getNumber(), animal.getSpecies() , animal.getBreed(),
                    animal.getPrice(), animal.isReserved()? "reserved" : "available");
        }
        System.out.println("--------------------------------------------------------------");
    }

   //2
   public void sortByPrice(String word){
    word = word.trim().toLowerCase();
    switch (word) {
        case "c":
            animals.sort(Comparator.comparing(Animal::getPrice));
            showAnimals();
            break;
        case "e":
            animals.sort(Comparator.comparing(Animal::getPrice).reversed());
            showAnimals();
            break;
        default:
            System.out.println("Invalid input!");
    }
}
//3
    public void filterAvailable(){
        System.out.println("Available animals:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %3s | %-8s | %-18s | %-8s | %-9s |\n", 
                "Nr", "Species", "Breed", "Price", "Status");
        System.out.println("--------------------------------------------------------------");
        for (Animal a : animals){
            if(!a.isReserved()){
                System.out.printf("| %3d | %-8s | %-18s | %-8.2f | %-9s |\n",
                a.getNumber(), a.getSpecies() , a.getBreed(),
                a.getPrice(), "available");
            }
        }
        System.out.println("--------------------------------------------------------------");
    }

//4
    public void saveAnimals(){
        try (PrintWriter writer = new PrintWriter("animals.csv")){
            writer.println("Number,Species,Breed,Price,Reserved");
            for(Animal a:animals){
                writer.printf("%d,%s,%s,%.2f,%s\n",
                a.getNumber(),a.getSpecies(),a.getBreed(),a.getPrice(),a.isReserved()? "reserved": "available");
            }
        }
        catch(IOException e){
            System.out.println("Failed to save changes: " + e.getMessage());
        }
    }
//4
public void reserveAnimalToCart(Scanner scanner, User user){
    filterAvailable();
    System.out.println("\u001B[33mEach animal reservation costs 50.0");
    System.out.println();
    while (true) {
        System.out.print("\u001B[37mEnter animal number to add to cart (or 0 to finish): ");
        try {
            int number = Integer.parseInt(scanner.nextLine().trim());
            if (number == 0) {
                System.out.println("Finished reserving animals.");
                break;
            }
            boolean found = false;
            for (Animal a : animals  ) {
                if (a.getNumber() == number && !a.isReserved()) {
                    user.reserveAnimal(a);
                    System.out.printf("Animal '%s - %s' added to cart for reservation.\n",
                            a.getSpecies(), a.getBreed());
                    System.out.println();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(" \u001B[91mAnimal with that number is already reserved! ");
            }
        } catch (NumberFormatException e) {
            System.out.println(" Invalid input.");
        }
    }
}    }
