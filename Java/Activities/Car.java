package activity1;

public class Car {
	
	public String color;
    public String transmission;
    public int make;
    public int tyres;
    public int doors;

    
    public Car(String color, String transmission, int make) {
        this.color = color;
        this.transmission = transmission;
        this.make = make;
        this.tyres = 4;
        this.doors = 4;
    }

    
    public void displayCharacteristics() {
        System.out.println(" Car Characteristics");
        System.out.println("Color: " + this.color);
        System.out.println("Transmission: " + this.transmission);
        System.out.println("Make Year: " + this.make);
        System.out.println("Number of Tyres: " + this.tyres);
        System.out.println("Number of Doors: " + this.doors);
        System.out.println("---------------------------");
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }

}
