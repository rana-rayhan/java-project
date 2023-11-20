package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] num = {7, 8, 3, 2, 1};

        for (int i = 0; i < num.length - 1; i++) {
            int selectIndex = i;

            for (int j = i + 1; j < num.length; j++) {
                if (num[selectIndex] > num[j]) {
                    selectIndex = j;
                }
                int temp = num[selectIndex];
                num[selectIndex] = num[i];
                num[i] = temp;
            }
        }
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
