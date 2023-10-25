package calculateArea;

public class Main {
    public static void main(String[] args) {
        CalculateArea circle = new CalculateArea(10);
        circle.displayArea();

        CalculateArea triangle = new CalculateArea(10,5);
        triangle.displayArea();
    }
}
