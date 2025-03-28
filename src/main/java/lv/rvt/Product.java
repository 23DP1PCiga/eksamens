package lv.rvt;

public class Product {
private String name;
private String category;
private double price;
protected boolean inStock;

public Product(String name ,String category , double price, boolean inStock ){
    this.name = name;
    this.category = category;
    this.price = price;
    this.inStock = inStock;
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

public boolean inStock(){
    return this.inStock;
}

public String toCSV(){
    return this.name +','+ this.category +','+ this.price +','+ this.inStock;
}

public void productInfo(){
    String productStatus = inStock? "in stock" : "out of stock";
    System.out.println("Product name: " + this.name + " , category: " + this.category + " , price: " + this.price  + " , status: " + productStatus);
}


}
