import java.util.Scanner;

public class MaxMinNumber {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int[] numbers = new int[5];

            for (int i = 0; i < numbers.length; i++) {
                int n = input.nextInt();
                numbers[i] = n;
            }

            int max = numbers[0];
            int min = numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                if (max < numbers[i]) {
                    max = numbers[i];
                } else if (min > numbers[i]) {
                    min = numbers[i];
                }
            }
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
        }
    }
}
