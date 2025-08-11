package Linked_List;

public class DeleteMiddleNode {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // ✅ Builds a sample list and deletes a given node
    public static void main(String[] args) {
        DeleteMiddleNode list = new DeleteMiddleNode();

        // Create a sample list: 10 → 20 → 30 → 40 → 50
        Node head = list.new Node(10);
        head.next = list.new Node(20);
        Node toDelete = list.new Node(30);   // the node we'll delete
        head.next.next = toDelete;
        toDelete.next = list.new Node(40);
        toDelete.next.next = list.new Node(50);

        System.out.println("Before deleting:");
        list.printList(head);

        // Delete node 30 (we are only given a pointer to it)
        list.deleteGivenNode(toDelete);

        System.out.println("After deleting node 30:");
        list.printList(head);
    }

    // ✅ Deletes the given node (not last) by copying the next node’s data
    public void deleteGivenNode(Node node) {
        if (node == null || node.next == null) {
            System.out.println("Cannot delete the last node or null.");
            return;
        }

        // Copy next node's data into current node
        node.data = node.next.data;

        // Skip the next node
        node.next = node.next.next;
    }

    // ✅ Print the linked list
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
