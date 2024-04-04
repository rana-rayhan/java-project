package queueDSA;

public class LinkListQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueY {
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void addQ(int d) {
            Node newNode = new Node(d);

            // 1st queue add
            if (head == null && tail == null) {
                head = tail = newNode;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public int removeQ() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return front;
        }

        public int peekQ() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }

    }

    public static void main(String[] args) {
        QueueY q = new QueueY();
        q.addQ(1);
        q.addQ(2);
        q.addQ(3);
        q.addQ(4);

        while (!q.isEmpty()){
            System.out.println(q.peekQ());
            q.removeQ();
        }

    }
}
