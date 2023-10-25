package shapePolymorphism;

public class Main {
    public static void main(String[] args) {
        Shape[] s = new Shape[3];

        s[0] = new Shape();
        s[1] = new Triangle(10, 15);
        s[2] = new Rectangle(10, 15);

        for (int i = 0; i < 3; i++) {
            System.out.println(s[i].area());

        }

    }
}
