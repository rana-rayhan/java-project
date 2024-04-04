package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int k = 0;
    static int sum = 0;

    static TreeInfo diameter3(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        } else {
            TreeInfo left = diameter3(root.left);
            TreeInfo right = diameter3(root.right);
            int ht = Math.max(left.ht, right.ht) + 1;
            int diam3 = left.ht + right.ht + 1;
            int myDiam = Math.max(Math.max(left.diam, right.diam), diam3);
            return new TreeInfo(ht, myDiam);
        }
    }

    static void printTree(Node root, int lb) {
        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);
        ++k;

        while (!q.isEmpty()) {
            Node curr = (Node) q.remove();
            if (curr != null) {
                System.out.print(curr.data + " ");
                if (k == lb) {
                    sum += curr.data;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                    ++k;
                }
            }
        }

    }


    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTrees {
        static int idx = -1;

        static Node buildTree(int[] nodes) {
            ++idx;
            if (nodes[idx] == -1) {
                return null;
            } else {
                Node root = new Node(nodes[idx]);
                root.left = buildTree(nodes);
                root.right = buildTree(nodes);
                return root;
            }
        }

        static void preOrder(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = (Node) q.remove();
                if (currNode != null) {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                } else {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                }
            }

        }

        static int countTree(Node root) {
            if (root == null) {
                return 0;
            } else {
                int n = countTree(root.left);
                int n2 = countTree(root.right);
                return n + n2 + 1;
            }
        }

        static int sumOfNode(Node root) {
            if (root == null) {
                return 0;
            } else {
                int n = sumOfNode(root.left);
                int n2 = sumOfNode(root.right);
                return n + n2 + root.data;
            }
        }

        static int depthOfTree(Node root) {
            if (root == null) {
                return 0;
            } else {
                int n1 = depthOfTree(root.left);
                int n2 = depthOfTree(root.right);
                return Math.max(n1, n2) + 1;
            }
        }

        static int diameter(Node root) {
            if (root == null) {
                return 0;
            } else {
                int dim1 = diameter(root.left);
                int dim2 = diameter(root.right);
                int dim3 = depthOfTree(root.left) + depthOfTree(root.right) + 1;
                return Math.max(dim3, Math.max(dim1, dim2));
            }
        }
    }


    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, 2, -1, -1, 3, -1, -1, 5, 3, -1, -1, 4, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.BinaryTrees.buildTree(nodes);
        BinaryTree.BinaryTrees.levelOrder(root);
    }

}
