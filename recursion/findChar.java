package recursion;

public class findChar {
    public static int first = -1;
    public static int last = -1;

    public static void findCharPos(String str, char c, int idx) {
        if (str.length() == idx) {
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == c) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        findCharPos(str, c, idx + 1);
    }

    public static void main(String[] args) {
        findCharPos("bdaadjaadjakk", 'a', 0);

    }

}
