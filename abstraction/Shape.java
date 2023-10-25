package abstraction;

public abstract class Shape {
    double dim1, dim2;

    Shape(double d1, double d2) {
        this.dim1 = d1;
        this.dim2 = d2;
    }

    abstract void area();
}
