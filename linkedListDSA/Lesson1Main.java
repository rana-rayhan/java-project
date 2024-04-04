package linkedListDSA;

public class Lesson1Main {
    Node head;
    private int size;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    // add first node
    public void addFirstNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLastNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Node is empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Node is empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public void printNode() {
        if (head == null) {
            System.out.println("Node is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public int checkSize() {
        return size;
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursiveNode(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseRecursiveNode(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    // delete linkList for nth given number
    public void deleteNthNum(int n) {
        if (head.next == null) {
            head = null;
            return;
        }
        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int indexToSearch = size - n;
        Node prev = head;
        int i = 1;
        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        Lesson1Main list = new Lesson1Main();

        list.addLastNode(1);
        list.addLastNode(2);
        list.addLastNode(3);
        list.addLastNode(4);

        list.printNode();
        //list.reverseList();
        //list.printNode();

        //list.head = list.reverseRecursiveNode(list.head);
        //list.printNode();

        int listSize = list.checkSize();
        list.deleteNthNum(3);
        list.printNode();

    }
}
