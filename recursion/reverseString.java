package recursion;
public class reverseString {
    public static void reverse(String x, int n) {
        if (n == 0) {
            System.out.print(x.charAt(n));
            return;
        }
        System.out.print(x.charAt(n));
        reverse(x, n - 1);
    }
    public static void main(String[] args) {
        String a = "abcd";
        reverse(a, a.length() - 1);
    }
}
