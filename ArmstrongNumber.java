import java.util.Scanner;

// List of ArmstrongNumber number
public class ArmstrongNumber {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int start, end, count = 0;

            System.out.println("Enter start number: ");
            start = input.nextInt();
            System.out.println("Enter end number: ");
            end = input.nextInt();

            for (int i = start; i <= end; i++) {
                int temp, r, result = 0;
                temp = i;

                while (temp != 0) {
                    r = temp % 10;
                    result = result + r * r * r;
                    temp = temp / 10;
                }
                if (i == result) {
                    System.out.print(result + " ");
                    count++;
                }
            }
            System.out.println("\n" + count);
        }
    }
}