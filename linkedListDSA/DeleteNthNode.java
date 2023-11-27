package linkedListDSA;

public class DeleteNthNode {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
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

    public void printList() {
        if (head == null) {
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Remove Nth Node From End of List
    public void deleteNthNode(int n) {
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

        if (size == n) {
            head = head.next;
            return;
        }

        int indexToSearch = size - n;
        Node prevNode = head;
        int i = 1;
        while (i < indexToSearch) {
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
    }


    public static void main(String[] args) {
        DeleteNthNode list = new DeleteNthNode();
        // add node first
        for (int i = 4; i > 0; i--) {
            list.addFirstNode(i);
        }
        // print all node
        list.printList();
        // Remove Nth Node From End of List
        list.deleteNthNode(1);
        list.printList();

    }
}
