package lv.rvt;

import java.util.ArrayList;
import java.util.List;

public class User {
private double balance;
private List<Product> cart;
private Animal reservedAnimal;

public User(double balance){
    this.balance = balance;
    this.cart = new ArrayList<>();
}

public double getBalance(){
    return balance;
}

public void addToCart(Product product){
    cart.add(product);
    System.out.println("'" + product.getName() + "' added to cart.");
}

public void reserveAnimal(Animal animal){
    reservedAnimal = animal;
}

public void showCartSummary(){
    double total = 0;
    System.out.println("\n------ Purchase Summary ------");
    for (Product p : cart){
        System.out.printf("Product: %-20s Price: %.2f\n" , p.getName() , p.getPrice());
        total += p.getPrice();
    }
    if (reservedAnimal != null){
        System.out.printf("Reserved animal: %-15s %-15s Price: %.2f\n" ,
        reservedAnimal.getSpecies() , reservedAnimal.getBreed() , 50.00);
        total += 50.0;
    }
    System.out.printf("TOTAL: %.2f\n" , total);
}

public void checkout(){
    double total = 0;
    for (Product p : cart) total += p.getPrice();
    if(reservedAnimal != null) total += 50.0;
    if (total> balance){
        System.out.println("Not enough balance! Needed: " + total + ", you have: " + balance);
    }
    else{
        balance -= total;
        System.out.printf("Purchase complete! Remaining balance: %.2f\n" , balance);
        cart.clear();
        reservedAnimal = null;
    }
}
/* 
public void addFunds(double amount){
    this.balance += amount;
    System.out.printf("Funds added! New balanc: %.2f\n" , balance);
}
*/
 
}
