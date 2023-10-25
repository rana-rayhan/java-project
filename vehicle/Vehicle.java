package vehicle;

public class Vehicle {
    String color;
    double weight;

    Vehicle(String c, double w) {
        color = c;
        weight = w;
    }

    void displayInfo() {
        System.out.println("Color of vehicle: " + color);
        System.out.println("Weight of vehicle: " + weight);
    }
}
