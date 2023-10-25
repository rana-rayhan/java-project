package recursion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       try(Scanner input = new Scanner(System.in)){
           Recursion ob = new Recursion();
           System.out.print("Enter a integer: ");
           int result = ob.fact(input.nextInt());
           System.out.println("Factorial is: "+result);
       }
    }
}
