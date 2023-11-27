package linkedListDSA;

public class PalindromeList {
    ListNode head;
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // find middle of the list
    public ListNode findMiddle(ListNode h) {
        ListNode hare = h;
        ListNode turtle = h;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
    // reverse list from middle
    public ListNode reverseList(ListNode h) {
        ListNode prevNode = null;
        ListNode currNode = h;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
    // check value is palindrome or not
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode secondHalf = reverseList(middle.next);

        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (secondHalf.val != firstHalf.val) {
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }


    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PalindromeList list = new PalindromeList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.printList();

        System.out.println(list.isPalindrome());

    }
}
