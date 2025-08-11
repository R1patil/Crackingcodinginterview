package Linked_List;

public class SumLists {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Add two numbers represented by reverse linked lists
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.data : 0;
            int val2 = (l2 != null) ? l2.data : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            current.next = new Node(digit);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    // Helper to create linked list from array
    public Node buildList(int[] digits) {
        Node head = null, tail = null;
        for (int val : digits) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Print linked list
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " → ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SumLists sl = new SumLists();

        // 617 is represented as 7 → 1 → 6
        int[] num1 = {7, 1, 6};
        int[] num2 = {5, 9, 2};  // 295

        Node l1 = sl.buildList(num1);
        Node l2 = sl.buildList(num2);

        System.out.print("First number: ");
        sl.printList(l1);
        System.out.print("Second number: ");
        sl.printList(l2);

        Node result = sl.addTwoNumbers(l1, l2);
        System.out.print("Sum: ");
        sl.printList(result); // should be 2 → 1 → 9 (912)
    }
}
