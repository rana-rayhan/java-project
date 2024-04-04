package queueDSA;

public class QueueScratch {
    static class QueueY {
        static int[] arr;
        static int size;
        static int rear = -1;

        QueueY(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void addQueue(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int removeQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peekQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        QueueY q = new QueueY(3);
        QueueY.addQueue(1);
        QueueY.addQueue(2);
        QueueY.addQueue(3);

        while (!QueueY.isEmpty()){
            System.out.println(QueueY.peekQueue());
            QueueY.removeQueue();
        }

    }
}
