package lv.rvt;

public class Product {
private int number;
private String name;
private String category;
private double price;


public Product(int number,String name ,String category , double price ){
    this.number = number;
    this.name = name;
    this.category = category;
    this.price = price;
}

public int getNumber(){
    return this.number;
}
public String getName(){
    return this.name;
}

public String getCategory(){
    return this.category;
}

public double getPrice(){
    return this.price;
}


public String toCSV(){
    return this.number+ ',' +this.name +','+ this.category +','+ this.price ;
}

public void productInfo(){
    System.out.println("Nr." + this.number+" , product name: " + this.name + " , category: " + this.category + " , price: " + this.price );
}


}
