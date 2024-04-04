package recursion;

public class Factorial {

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int f1 = fact(n - 1);
        return n * f1;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
