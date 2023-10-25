package vehicle;

public class Car extends Vehicle {
    String name;
    int gear;

     public Car(String c, double w, String n, int g) {
        super(c, w);
        name = n;
        gear = g;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name of vehicle: "+name);
        System.out.println("Gears of vehicle: "+gear);
        super.displayInfo();
        System.out.println();
    }
}
