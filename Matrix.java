import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int[][] MatrixValue = new int[3][3];
            int diagonalSum = 0, upperSum = 0, lowerSum = 0;

            // Getting input from user for matrix
            for (int row = 0; row < MatrixValue.length; row++) {
                for (int col = 0; col < MatrixValue.length; col++) {
                    MatrixValue[row][col] = input.nextInt();
                }
                System.out.println();
            }

            // Sum of diagonal, upper and lower Matrix
            for (int row = 0; row < MatrixValue.length; row++) {
                for (int col = 0; col < MatrixValue.length; col++) {
                    if (row == col) {
                        diagonalSum += MatrixValue[row][col];
                    }
                    if (row < col) {
                        upperSum += MatrixValue[row][col];
                    }
                    if (row > col) {
                        lowerSum += MatrixValue[row][col];
                    }
                    System.out.print(MatrixValue[row][col] + " ");
                }
                System.out.println();
            }
            System.out.println("Sum of diagonal: " + diagonalSum);
            System.out.println("Sum of upper: " + upperSum);
            System.out.println("Sum of lower: " + lowerSum);
        }
    }
}