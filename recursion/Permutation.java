package recursion;

public class Permutation {
    public static void printPrem(String str, String permutation) {

        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            String str1 = str.substring(0, i);
            String str2 = str.substring(i + 1);

            String newStr = str1 + str2;
            printPrem(newStr, permutation + currentChar);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPrem(str, "");
    }
}
