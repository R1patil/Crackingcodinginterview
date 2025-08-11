package Linked_List;

public class DetectLoop {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Head of the list
    Node head = null;

    // Add node to end of list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Create a loop in the list (for testing)
    public void createLoop(int pos) {
        if (head == null || pos < 0) return;

        Node loopStart = null;
        Node temp = head;
        int count = 0;

        while (temp.next != null) {
            if (count == pos) loopStart = temp;
            temp = temp.next;
            count++;
        }

        temp.next = loopStart;  // create the loop
    }

    // Floyd's algorithm to detect and return start of loop
    public Node detectLoopStart() {
        Node slow = head;
        Node fast = head;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected
                break;
            }
        }

        if (fast == null || fast.next == null) return null; // No cycle

        // Phase 2: Find the start of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;  // Start of the loop
    }

    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(-4);

        list.createLoop(1);  // loop back to node with data=2

        Node loopStart = list.detectLoopStart();
        if (loopStart != null) {
            System.out.println("Loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("No loop detected.");
        }
    }
}
