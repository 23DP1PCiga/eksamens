public class Animals {
    private String species;
    private String breed;
    private double price;
    protected boolean reserved;
    
    public Animals(String species , String breed , double price , boolean status ){
    this.species = species;
    this.breed = breed;
    this.price = price;
    this.reserved = reserved;
    }
    
    public String getSpecies(){
        return this.species;
    }
    
    public String getBreed(){
        return this.breed;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public boolean isReserved(){
        return this.reserved;
    }
    
    public void setReserved(boolean reserved){
        this.reserved = reserved;
    }
    
    public String toCSV(){
    return species + breed + price + reserved;
    }
    
    public void animalInfo(){
        String status = reserved? "reserved" : "aviable";
        System.out.println("Species: " + this.species + " , breed: "+ this.breed+ " , price: " + this.price + " , status: " + status );
    }
    }
    