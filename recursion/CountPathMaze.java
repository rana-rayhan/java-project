package recursion;

public class CountPathMaze {
    public static int countMaze(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && i == m - 1) {
            return 1;
        }
        int downPath = countMaze(i + 1, j, n, m);
        int rightPath = countMaze(i, j + 1, n, m);
        return downPath + rightPath;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countMaze(0, 0, n, m));
    }
}
