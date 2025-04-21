package lv.rvt;

public class User {
private double balance;

public User(double balance){
    this.balance = balance;
}

public double getBalance(){
    return balance;
}

public void addFunds(double amount){
    this.balance += amount;
    System.out.printf("Funds added! New balanc: %.2f\n" , balance);
}

 public boolean makePurchase(double cost){
    if (balance >= cost){
        balance -= cost;
        return true;
    }
    else{
        return false;
        }
   }
}
