package hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HashMapQNA {
    public HashMapQNA() {
    }

    public static void majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap();
        int n = num.length;
        int[] var3 = num;
        int key = num.length;

        for(int var5 = 0; var5 < key; ++var5) {
            int j = var3[var5];
            if (map.containsKey(j)) {
                map.put(j, (Integer)map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        Iterator var7 = map.keySet().iterator();

        while(var7.hasNext()) {
            key = (Integer)var7.next();
            if (n / 3 < (Integer)map.get(key)) {
                System.out.print("" + key + ", ");
            }
        }

    }

    public static void unionElement(int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet();
        int[] var3 = num1;
        int var4 = num1.length;

        int var5;
        int n;
        for(var5 = 0; var5 < var4; ++var5) {
            n = var3[var5];
            set.add(n);
        }

        var3 = num2;
        var4 = num2.length;

        for(var5 = 0; var5 < var4; ++var5) {
            n = var3[var5];
            set.add(n);
        }

        System.out.println(set);
    }

    public static void intersection(int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet();
        int[] var3 = num1;
        int var4 = num1.length;

        int var5;
        int n;
        for(var5 = 0; var5 < var4; ++var5) {
            n = var3[var5];
            set.add(n);
        }

        var3 = num2;
        var4 = num2.length;

        for(var5 = 0; var5 < var4; ++var5) {
            n = var3[var5];
            if (set.contains(n)) {
                System.out.print("" + n + " ");
                set.remove(n);
            }
        }

    }

    public static String getStart(HashMap<String, String> from) {
        HashMap<String, String> to = new HashMap();
        Iterator var2 = from.keySet().iterator();

        String key;
        while(var2.hasNext()) {
            key = (String)var2.next();
            to.put((String)from.get(key), key);
        }

        var2 = from.keySet().iterator();

        do {
            if (!var2.hasNext()) {
                return null;
            }

            key = (String)var2.next();
        } while(to.containsKey(key));

        return key;
    }

    public static int subArrSum(int[] num, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        int[] var5 = num;
        int var6 = num.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            int j = var5[var7];
            sum += j;
            if (map.containsKey(sum - k)) {
                count += (Integer)map.get(sum - k);
            }

            if (map.containsKey(sum)) {
                map.put(sum, (Integer)map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
    }
}
