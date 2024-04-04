package queueDSA;
import java.util.Stack;

public class StackQ {
    static class QueueQ {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();
        public boolean isEmpty() {
            return s1.isEmpty();
        }
        public void addQ(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public int removeQ() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
        public int peekQ() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        QueueQ q = new QueueQ();
        q.addQ(1);
        q.addQ(2);
        q.addQ(3);
        q.addQ(4);

        while (!q.isEmpty()) {
            System.out.println(q.peekQ());
            q.removeQ();
        }
    }
}
