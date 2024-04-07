import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(str);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            set.add(String.valueOf(c));
        }

        System.out.println(set);
        System.out.println(set.size());

    }
}
