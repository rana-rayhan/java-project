package recursion;
public class removeDuplicate {
    public static boolean[] map = new boolean[26];
    public static void removeDuplicates(String str, String newStr, int idx) {
        if (str.length() == idx) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a']) {
            removeDuplicates(str, newStr, idx + 1);
        } else {
            newStr += currChar;
            map[currChar - 'a'] = true;
            removeDuplicates(str, newStr, idx + 1);
        }
    }
    public static void main(String[] args) {
        removeDuplicates("abbczzcdda", "", 0);
    }
}
