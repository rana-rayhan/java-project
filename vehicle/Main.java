package vehicle;

public class Main {
    public static void main(String[] args) {
        Car volvo = new Car("Black", 550.5, "Volvo xc-60", 5);
        volvo.displayInfo();

        Car yamaha = new Car("Dark-blue", 350.5, "Yamaha R-1", 6);
        yamaha.displayInfo();

    }
}
