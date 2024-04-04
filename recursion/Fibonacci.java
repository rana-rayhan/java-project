package recursion;
public class Fibonacci {
    public static void printResult(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.print(c + " ");
        printResult(b, c, n - 1);
    }
    public static void main(String[] args) {
        int a = 0, b = 1, n = 7;
        System.out.print(a + " " + b + " ");
        printResult(a, b, n - 2);

    }
}
