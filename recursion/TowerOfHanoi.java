package recursion;

public class TowerOfHanoi {
    public static void moveDisk(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from -> " + src + " to -> " + dest);
            return;
        }
        moveDisk(n-1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from -> " + src + " to -> " + dest);
        moveDisk(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        moveDisk(3,"Source","Helper", "Destination");
    }
}
