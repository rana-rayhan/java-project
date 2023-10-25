package abstraction;

public class Circle extends Shape {

    Circle(double radius) {
        super(radius,radius);
    }

    @Override
    void area() {
        double result =Math.PI* dim1 * dim2;
        System.out.println("Area of Rectangle: " + result);
    }
}
