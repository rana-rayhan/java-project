
public class Main {
    public static void main(String[] args) {
        try {
            double x = 54.13336;
            int y = 54;
            String name = "ryan";

            System.out.printf("x = %.2f", x);
            System.out.printf("x = %f", y);

        } catch (Exception e) {
            System.out.println("\n\nException error: " + e);
        }

    }
}