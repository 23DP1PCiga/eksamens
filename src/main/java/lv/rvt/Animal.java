package lv.rvt;

public class Animal {
    private int number;
    private String species;
    private String breed;
    private double price;
    protected boolean reserved;

    public Animal(int number,String species, String breed, double price, boolean reserved) {
        this.number = number;
        this.species = species;
        this.breed = breed;
        this.price = price;
        this.reserved = reserved;
    }

    public int getNumber(){
        return this.number;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getBreed() {
        return this.breed;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String toCSV() {
        return number +','+species + ", " + breed + ", " + price + ", " + reserved;
    }

    public void animalInfo() {
        String animalStatus = reserved ? "reserved" : "available";
        System.out.println("Nr." + number +"Species: " + species + ", Breed: " + breed + ", Price: " + price + ", Status: " + animalStatus);
    }

    
}
