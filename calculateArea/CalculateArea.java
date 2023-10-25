package calculateArea;

public class CalculateArea {
    double area;

    public CalculateArea() {
        System.out.println("No value given");
    }

    public CalculateArea(double r) {
        area = Math.PI * (r * r);
    }

    CalculateArea(double b, double h) {
        area = 0.5 * b * h;
    }

    public void displayArea() {
        System.out.println("Area is: " + area);
    }
}
