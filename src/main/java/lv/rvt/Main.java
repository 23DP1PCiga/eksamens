package lv.rvt;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("-------------------------------------------------------------------------------------------------------");
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
       System.out.println("-------------------------------------------------------------------------------------------------------");
       System.out.println();
      
       AnimalManager animal = new AnimalManager();
       animal.filterAvailable();
     
       //ProductManager product = new ProductManager();
      // product.showProducts();
    }
}

