package String;

public class Palindrome {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        StringBuilder revSb = new StringBuilder("Hello");

        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            revSb.setCharAt(front, backChar);
            revSb.setCharAt(back, frontChar);
        }


    }
}
