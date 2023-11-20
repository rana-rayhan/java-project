package arrays;

import java.util.Scanner;

public class Spiral {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        // Input for matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("The Spiral Order Matrix is : ");
        int rowStart = 0;
        int rowEnd = r - 1;
        int colStart = 0;
        int colEnd = c - 1;


        //To print spiral order matrix
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //1
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(matrix[rowStart][col] + " ");
            }
            rowStart++;


            //2
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(matrix[row][colEnd] + " ");
            }
            colEnd--;


            //3
            for (int col = colEnd; col >= colStart; col--) {

                System.out.print(matrix[rowEnd][col] + " ");
            }
            rowEnd--;


            //4
            for (int row = rowEnd; row >= rowStart; row--) {
                System.out.print(matrix[row][colStart] + " ");
            }
            colStart++;

        }
    }
}
