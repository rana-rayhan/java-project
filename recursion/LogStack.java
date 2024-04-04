package recursion;

public class LogStack {
    public static int powerOfx(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        // Normal stack, x^n
        //return x * powerOfx(x, n - 1);
        // LogN x^n
        if (n % 2 == 0) {
            return powerOfx(x, n / 2) * powerOfx(x, n / 2);
        } else {
            return powerOfx(x, n / 2) * powerOfx(x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerOfx(2, 5));
    }
}
