package lv.rvt;

import java.util.ArrayList;
import java.util.List;
import lv.rvt.tools.Helper;

public class User {
private double balance;
private List<Product> cart;
private List<Animal> reservedAnimals;

public User(double balance){
    this.balance = balance;
    this.cart = new ArrayList<>();
    this.reservedAnimals = new ArrayList<>();
}
public double getBalance(){
    return balance;
}

public void addToCart(Product product){
    cart.add(product);
    System.out.println("'" + product.getName() + "' added to cart.");
}

public void reserveAnimal(Animal animal){
    reservedAnimals.add(animal);
    animal.setReserved(true); 
    System.out.println("Reserved animal: " + animal.getSpecies() + " - " + animal.getBreed());
}

public void showCartSummary() {
    double total = 0;
    System.out.println("\n================== Purchase Summary =======================");
    System.out.printf("| %-32s | %-20s |\n", "Item", "Price");
    System.out.println("-----------------------------------------------------------");

for (Product p : cart) {
    System.out.printf("| %-32s | %20.2f |\n", p.getName(), p.getPrice());
    total += p.getPrice();
}
for (Animal animal : reservedAnimals) {
String animalName = animal.getSpecies() + " - " + animal.getBreed();
System.out.printf("| %-32s | %20.2f |\n", "Animal: " + animalName, 50.00);
total += 50.00;
}
System.out.println("-----------------------------------------------------------");
System.out.printf("| %-32s | %20.2f |\n", "TOTAL", total);
System.out.println("===========================================================");
}

public void checkout(){
    double total = 0;
    for (Product p : cart) total += p.getPrice();
    total += reservedAnimals.size() * 50.0;

    if (total > balance){
        System.out.printf("\u001B[91mNot enough balance! Needed: " + total + ", you have: %.2f\n\u001B[97m" , balance);
    } 
    else {
    balance -= total;
    System.out.printf("\u001B[92mPurchase complete! Remaining balance: %.2f\n\u001B[97m" , balance);
    cart.clear();
    reservedAnimals.clear();
    }
}

public void addFunds(double amount){
    this.balance += amount;
    System.out.printf("\u001B[97mFunds added! New balance: %.2f\n" , balance);
    }
}
