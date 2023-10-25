import java.util.Scanner;

public class UserAuth {
    public static void main(String[] args) {
        try (Scanner input = new Scanner((System.in))) {
            String userName = "ryan";
            String password = "1234";

            while (true) {
                System.out.print("Enter username: ");
                String uName = input.nextLine();

                System.out.print("Enter password: ");
                String uPassword = input.nextLine();

                if (uName.equals(userName) && uPassword.equals(password)) {
                    System.out.println("Welcome " + uName);
                    break;
                } else {
                    System.out.println("Incorrect username & password. Please try again.\n");
                }
            }
        }
    }
}
