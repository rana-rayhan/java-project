package abstraction;

public class Rectangle extends Shape {

    Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    void area() {
        double result = dim1 * dim2;
        System.out.println("Area of Rectangle: " + result);
    }
}
