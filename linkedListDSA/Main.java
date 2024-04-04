package linkedListDSA;

public class Main {
    Node1 head1;
    Node2 head2;
    Node3 head3;

    class Node1 {
        int data;
        Node1 next;

        Node1(int data) {
            this.data = data;
            next = null;
        }
    }

    class Node2 {
        int data;
        Node2 next;

        Node2(int data) {
            this.data = data;
            next = null;
        }
    }

    class Node3 {
        int data;
        Node3 next;

        Node3(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addNode1(int data) {
        Node1 newNode = new Node1(data);
        if (head1 == null) {
            head1 = newNode;
            return;
        }
        newNode.next = head1;
        head1 = newNode;
    }

    public void addNode2(int data) {
        Node2 newNode = new Node2(data);
        if (head2 == null) {
            head2 = newNode;
            return;
        }
        newNode.next = head2;
        head2 = newNode;
    }

    public void printNode1() {
        if (head1 == null) {
            System.out.println("Node is empty");
            return;
        }
        Node1 currNode = head1;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
    }

    public void printNode2() {
        if (head2 == null) {
            System.out.println("Node is empty");
            return;
        }
        Node2 currNode = head2;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
    }

    public void addLast(int data) {
        Node3 newNode = new Node3(data);
        if (head3 == null) {
            head3 = newNode;
            return;
        }
        Node3 currNode = head3;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void sumOfLink() {
        if (head1 == null && head2 == null) {
            System.out.println("Node is empty");
            return;
        }
        Node1 currN1 = head1;
        Node2 currN2 = head2;
        int carry = 0;

        while (currN1 != null || currN2 != null) {
            int x = (currN1 != null) ? currN1.data : 0;
            int y = (currN2 != null) ? currN2.data : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            int digit = sum % 10;

            addLast(digit);

            if (currN1 != null) {
                currN1 = currN1.next;
            }
            if (currN2 != null) {
                currN2 = currN2.next;
            }
        }

        // If there is a remaining carry
        if (carry > 0) {
            addLast(carry);
        }


        Node3 myNode = head3;
        while (myNode != null) {
            System.out.print(myNode.data + " -> ");
            myNode = myNode.next;
        }
    }

    public static void main(String[] args) {
        Main list = new Main();
        list.addNode1(7);
        list.addNode1(3);
        list.addNode1(5);
        list.printNode1();
        System.out.println();
        list.addNode2(2);
        list.addNode2(6);
        list.addNode2(2);
        list.printNode2();

        System.out.println();

        list.sumOfLink();

    }
}
