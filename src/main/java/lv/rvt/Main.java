package lv.rvt;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("------------------------------------------------------------------------------------------------------------------");
       System.out.println();
       System.out.println();
       System.out.println("               _                            _                      _                 _       _                 ");
       System.out.println("              | |                          | |                    (_)               | |     | |                ");
       System.out.println(" __      _____| | ___ ___  _ __ ___   ___  | |_ ___     __ _ _ __  _ _ __ ___   __ _| |  ___| |__   ___  _ __  ");
       System.out.println(" \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\   / _` | '_ \\| | '_ ` _ \\ / _` | | / __| '_ \\ / _ \\| '_ \\ ");
       System.out.println("  \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | (_| | | | | | | | | | | (_| | | \\__ \\ | | | (_) | |_) |");
       System.out.println("   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__,_|_| |_|_|_| |_| |_|\\__,_|_| |___/_| |_|\\___/| .__/ ");
       System.out.println("                                                                                                        | |    ");
       System.out.println("                                                                                                        |_|    ");
       System.out.println();
       System.out.println("------------------------------------------------------------------------------------------------------------------");
       System.out.println();
       Scanner scan = new Scanner(System.in);
       System.out.println("Welome to Animal shop!\n Enter 'animal' to see list of all animal or enter 'product' to see list of products.");
       String choice = scan.nextLine();
       scan.nextLine();
       if(choice.equals("animal")){
        AnimalManager animal = new AnimalManager();
        animal.showAnimals();
       }else if (choice.equals("product")){
        ProductManager product = new ProductManager();
        product.showProducts();
       }else{
        System.out.println("Error! Try again!");
       }
       //ProductManager product = new ProductManager();
       //product.showProducts(); 
       //AnimalManager animal = new AnimalManager();
       //animal.showAnimals(); 
    }
}

