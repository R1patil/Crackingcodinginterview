package Linked_List;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopWithHashing {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    // Detect loop start using HashSet
    public Node detectLoopStart(Node head) {
        Set<Node> visited = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return current; // ✅ start of loop
            }
            visited.add(current);
            current = current.next;
        }

        return null; // 🚫 no loop
    }

    // Create sample looped list
    public static void main(String[] args) {
        DetectLoopWithHashing list = new DetectLoopWithHashing();

        Node a = list.new Node(1);
        Node b = list.new Node(2);
        Node c = list.new Node(3);
        Node d = list.new Node(4);
        Node e = list.new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;  // 🔁 Loop starts at node 3

        Node result = list.detectLoopStart(a);
        if (result != null) {
            System.out.println("Loop starts at node with data: " + result.data);
        } else {
            System.out.println("No loop found.");
        }
    }
}
