package lv.rvt;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AnimalManager animal = new AnimalManager();
    private static ProductManager product = new ProductManager();
    public static void main(String[] args) {
      
       while (true) {
        printMainMenu();
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "1":
                animalMenu();
                break;
            case "2":
                productMenu();
                break;
            case "0":
                System.out.println("Bye bye!");
                return;
            default:
                System.out.println("Invalid input.");
         }
       }
    }


    private static void printMainMenu() {
        clearConsole();
        printBanner();
        System.out.println("Choose an option:");
        System.out.println("1. Manage animals");
        System.out.println("2. Manage products");
        System.out.println("0. Exit");
        System.out.println("Your choice: ");    
    }
    

    private static void animalMenu(){
        while (true) {
            clearConsole();
            printBanner();
            System.out.println("Animal menu:");
            System.out.println("1. Show all animals");
            System.out.println("2. Sort animals by price");
            System.out.println("3. Filter available animals");
            System.out.println("4. Reserve an animal");
            System.out.println("0. Back to main menu");
            System.out.println("Your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    animal.showAnimals();
                    waitFor();
                    break;
                case "2":
                    animal.sortByPrice();
                    animal.showAnimals();
                    waitFor();
                    break;
                case "3":
                    animal.filterAvailable();
                    waitFor();
                    break;
                case "4":
                     //reserveAnimal()
                     //waitFor();
                     //break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static void productMenu(){
        while (true) {
            clearConsole();
            printBanner();
            System.out.println("Product menu: ");
            System.out.println("1. Show all products");
            System.out.println("2. Sort products by price");
            System.out.println("3. Search by name");
            System.out.println("4. Buy products");
            System.out.println("0. Back to main menu");
            System.out.println("Your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    product.showProducts();
                    waitFor();
                    break;
                case "2":
                    product.sortByPrice();
                    product.showProducts();
                    waitFor();
                    break;
                case "3":
                    System.out.println("Enter name to search: ");
                    String name = scanner.nextLine();
                    product.searchByName(name);
                    waitFor();
                    break;
                case "4":
                    //buyProduct();
                    //waitFor();
                    //break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear the console.");
        }
    }

    public static void printBanner(){
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("                     __          __  _                            _           ");
        System.out.println("                     \\ \\        / / | |                          | |          ");
        System.out.println("                      \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___     ");
        System.out.println("                       \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    ");
        System.out.println("                        \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |   ");
        System.out.println("                         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/    ");
        System.out.println("                                 (_)               | |     | |                ");
        System.out.println("                       __ _ _ __  _ _ __ ___   __ _| |  ___| |__   ___  _ __  ");
        System.out.println("                      / _` | '_ \\| | '_ ` _ \\ / _` | | / __| '_ \\ / _ \\| '_ \\ ");
        System.out.println("                     | (_| | | | | | | | | | | (_| | | \\__ \\ | | | (_) | |_) |");
        System.out.println("                      \\__,_|_| |_|_|_| |_| |_|\\__,_|_| |___/_| |_|\\___/| .__/ ");
        System.out.println("                                                                       | |    ");
        System.out.println("                                                                       |_|    ");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        }

        private static void waitFor(){
            System.out.println("Press enter to continue...");
            scanner.nextLine();
        }
}

   