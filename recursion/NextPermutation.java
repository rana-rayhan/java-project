package recursion;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    public static void nextPrp(List<List<Integer>> list, boolean[] vis, int[] arr, ArrayList<Integer> temp) {

        if (arr.length == temp.size()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                temp.add(arr[i]);
                nextPrp(list, vis, arr, temp);
                vis[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] vis = new boolean[arr.length];
        List<List<Integer>> list = new ArrayList<>();
        nextPrp(list, vis, arr, new ArrayList<>());
        System.out.println(list);
    }
}
