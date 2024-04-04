package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insertNode(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        } else {
            if (root.data > val) {
                root.left = insertNode(root.left, val);
            } else {
                root.right = insertNode(root.right, val);
            }

            return root;
        }
    }

    public static void inorderNode(Node root) {
        if (root != null) {
            inorderNode(root.left);
            System.out.print(root.data + " ");
            inorderNode(root.right);
        }
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        } else if (root.data == key) {
            return true;
        } else {
            return root.data > key ? search(root.left, key) : search(root.right, key);
        }
    }

    public static Node deleteNode(Node root, int target) {
        if (root.data > target) {
            root.left = deleteNode(root.left, target);
        } else if (root.data < target) {
            root.right = deleteNode(root.right, target);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node child = inorderSuccessor(root.right);
            root.data = child.data;
            root.right = deleteNode(root.right, child.data);
        }

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void printRange(Node root, int x, int y) {
        if (root != null) {
            if (root.data >= x && root.data <= y) {
                printRange(root.left, x, y);
                System.out.print(root.data + " ");
                printRange(root.right, x, y);
            } else if (root.data >= y) {
                printRange(root.left, x, y);
            } else {
                printRange(root.right, x, y);
            }

        }
    }

    public static void printLeafNode(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                System.out.print(root.data + " ");
            } else {
                printLeafNode(root.left);
                printLeafNode(root.right);
            }
        }
    }

    public static void printLeafToPath(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.data);
            if (root.left == null && root.right == null) {
                Iterator var2 = list.iterator();

                while (var2.hasNext()) {
                    int i = (Integer) var2.next();
                    System.out.print("" + i + " -> ");
                }

                System.out.println();
            }

            printLeafToPath(root.left, list);
            printLeafToPath(root.right, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{8, 5, 3, 6, 10, 11, 14};
        Node root = null;
        int[] var3 = values;
        int var4 = values.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            int i = var3[var5];
            root = insertNode(root, i);
        }

        System.out.println();
        printLeafToPath(root, new ArrayList());
    }
}
