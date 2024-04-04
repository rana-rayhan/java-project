package recursion;

public class moveX {
    public static void moveAllx(String str, String newStr, int idx, int count) {
        if (idx == str.length() - 1) {
            for (int i = 0; i < count; i++) {
                newStr += 'x';
            }
            System.out.println(newStr);
            return;
        }
        char currentChar = str.charAt(idx);
        if (currentChar == 'x') {
            count++;
        } else {
            newStr += currentChar;
        }
        moveAllx(str, newStr, idx + 1, count);

    }

    public static void main(String[] args) {
        String str = "abxdbaxsxxs";
        moveAllx(str, "", 0, 0);
    }
}
