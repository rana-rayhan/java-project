package recursion;

public class SubsequencesStr {
    public static void subsequences(String str, String newStr, int idx) {
        if(str.length()== idx){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        subsequences(str, newStr + currChar, idx + 1);
        subsequences(str, newStr, idx + 1);
    }

    public static void main(String[] args) {
        subsequences("abc", "", 0);
    }
}
