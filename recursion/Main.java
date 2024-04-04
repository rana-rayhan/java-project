package recursion;

public class Main {
    public static int callPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        // int callF = callPower(x, n - 1);
        // return x * callF;
        if (n % 2 == 0) {
            return callPower(x, n / 2) * callPower(x, n / 2);
        } else {
            return callPower(x, n / 2) * callPower(x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(callPower(2, 10));

    }
}
