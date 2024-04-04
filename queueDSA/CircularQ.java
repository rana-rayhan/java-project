package queueDSA;

public class CircularQ {
    static class QueueY {
        static int[] arr;
        static int size;
        static int rear = -1;
        static int front = -1;

        QueueY(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void addQueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int removeQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];
            if (front == rear) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peekQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        QueueY q = new QueueY(3);
        QueueY.addQueue(1);
        QueueY.addQueue(2);
        QueueY.addQueue(3);

        System.out.println(QueueY.removeQueue()+ " -> removed");
        QueueY.addQueue(4);
        System.out.println(QueueY.removeQueue()+ " -> removed");
        QueueY.addQueue(5);

        while (!QueueY.isEmpty()) {
            System.out.println(QueueY.peekQueue());
            QueueY.removeQueue();
        }

    }
}
