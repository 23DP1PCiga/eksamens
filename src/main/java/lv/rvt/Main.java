package lv.rvt;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AnimalManager animal = new AnimalManager();
    private static ProductManager product = new ProductManager();
    private static User user = new User(20);
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
            case "3":
                balanceMenu();
                waitForEnter();
                break; 
            case "4":
                user.showCartSummary();
                System.out.println("Confirm purchase? (yes/no): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (confirm.equals("yes")) {
                    user.checkout();
                }
                waitForEnter();
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
        System.out.println("\u001B[37mChoose an option:");
        System.out.println("1. Manage animals");
        System.out.println("2. Manage products");
        System.out.println("3. View / Add balance");
        System.out.println("4. View cart and checkout");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Your choice: ");    
    }
    
    private static void animalMenu(){
        while (true) {
            clearConsole();
            printBanner();
            System.out.println("\u001B[37mAnimal menu:");
            System.out.println("1. Show all animals");
            System.out.println("2. Sort animals by price");
            System.out.println("3. Filter available animals");
            System.out.println("4. Reserve an animal");
            System.out.println("0. Back to main menu");
            System.out.println();
            System.out.print("Your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    animal.showAnimals();
                    waitForEnter();
                    break;
                case "2":
                    System.out.println(" *Enter 'c' to sort from cheapest to most expensive");
                    System.out.println(" *Enter 'e' to sort from most expensive to cheapest");
                    String ans = scanner.nextLine();
                    animal.sortByPrice(ans);
                    waitForEnter();
                    break;
                case "3":
                    animal.filterAvailable();
                    waitForEnter();
                    break;
                case "4":
                     animal.reserveAnimalToCart(scanner, user);
                     waitForEnter();
                     break;
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
            System.out.println("\u001B[37mProduct menu: ");
            System.out.println("1. Show all products");
            System.out.println("2. Filter products by category");
            System.out.println("3. Sort products by price");
            System.out.println("4. Search by name");
            System.out.println("5. Add products to cart");
            System.out.println("0. Back to main menu");
            System.out.println();
            System.out.print("Your choice: ");   
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                product.showProducts();
                waitForEnter();
                break;
                case "2":
                    System.out.println("Categories: \n  *Care \n  *Accessories \n  *Feed");
                    System.out.println();
                    System.out.print("Enter category to filter: ");
                    String choice = scanner.nextLine();
                    product.sortByCategory(choice);
                    waitForEnter();
                    break;
                case "3":
                    System.out.println(" *Enter 'c' to sort from cheapest to most expensive");
                    System.out.println(" *Enter 'e' to sort from most expensive to cheapest ");
                    String ans = scanner.nextLine();
                    product.sortByPrice(ans);
                    waitForEnter();
                    break;
                case "4":
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    product.searchByName(name);
                    waitForEnter();
                    break;
                case "5":
                    product.addProductToCart(scanner, user);
                    waitForEnter();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }    

    public static void printBanner(){
        System.out.println("\u001B[96m                __          __  _                              _                        _                 _         _                              ");
        System.out.println("                \\ \\        / / | |                            | |                      (_)               | |       | |                           ");
        System.out.println("                 \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___    | |_ ___       __ _ _ __  _ _ __ ___   __ _| |    ___| |__   ___  _ __            ");
        System.out.println("                  \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | __/ _ \\     / _` | '_ \\| | '_ ` _ \\ / _` | |   / __| '_ \\ / _ \\| '_ \\ ");
        System.out.println("                   \\  /\\  /  __/ | (_| (_) | | | | | |  __/   | || (_) |   | (_| | | | | | | | | | | (_| | |   \\__ \\ | | | (_) | |_) |         ");
        System.out.println("                    \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|    \\__\\___/     \\__,_|_| |_|_|_| |_| |_|\\__,_|_|   |___/_| |_|\\___/| .__/   ");
        System.out.println("                                                                                                                               | |                 ");
        System.out.println("                                                                                                                               |_|                 ");
        System.out.println();
        }
    
    private static void balanceMenu(){
        System.out.printf("Your current balance: %.2f\n", user.getBalance());
        System.out.print("Would you like to add funds? (yes/no): ");
        String ans = scanner.nextLine().trim().toLowerCase();
        if(ans.equals("yes")){
            System.out.print("Enter amount to add: ");
            try{
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if(amount>0){
                    user.addFunds(amount);
                }
                else{
                    System.out.println("\u001B[91mAmount must be positive!");
                }
            }
            catch(NullPointerException e){
                System.out.println("Invalid amount");
            }
        }
    }
        
}

   
