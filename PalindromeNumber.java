import java.util.Scanner;

// List of palindrome number
public class PalindromeNumber {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int start, end, count = 0;

            System.out.print("Enter start number: ");
            start = input.nextInt();
            System.out.print("Enter end number: ");
            end = input.nextInt();

            for (int i = start; i <= end; i++) {
                int temp, result = 0, remainder;
                temp = i;

                while (temp != 0) {
                    remainder = temp % 10;
                    result = result * 10 + remainder;
                    temp = temp / 10;
                }
                if (result == i) {
                    System.out.print(result + " ");
                    count++;
                }
            }
            System.out.println("\n" + count);
        }

    }
}