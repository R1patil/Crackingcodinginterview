package Linked_List;

public class IntersectionList {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // 🔧 Get length of any list
    private int getLength(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // ✅ Detect intersection
    public Node getIntersectionNode(Node headA, Node headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        Node longer = (lenA > lenB) ? headA : headB;
        Node shorter = (lenA > lenB) ? headB : headA;

        int diff = Math.abs(lenA - lenB);

        // Move longer ahead by diff
        while (diff-- > 0) {
            longer = longer.next;
        }

        // Walk both together
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer; // ✅ Found intersection
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null; // 🚫 No intersection
    }

    // 🌱 Build test case with intersection
    public static void main(String[] args) {
        IntersectionList list = new IntersectionList();

        // Shared part
        Node shared = list.new Node(8);
        shared.next = list.new Node(10);

        // List A: 3 → 7 → 8 → 10
        Node a1 = list.new Node(3);
        a1.next = list.new Node(7);
        a1.next.next = shared;

        // List B:      99 → 1 → 8 → 10
        Node b1 = list.new Node(99);
        b1.next = list.new Node(1);
        b1.next.next = shared;

        Node result = list.getIntersectionNode(a1, b1);

        if (result != null) {
            System.out.println("Intersection at node with data: " + result.data);
        } else {
            System.out.println("No intersection");
        }
    }
}
