package dynamicPrograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKElement {
    public static int[] helper(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        List<Integer>[] bucket = new List[arr.length + 1];
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] arrK = new int[k];
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            List<Integer> list = bucket[i];
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {
                    arrK[count++] = list.get(j);

                    if (count == k) {
                        return arrK;
                    }
                }
            }
        }
        return arrK;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3};

        int[] ans = helper(array, 3);
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }
}
