package ArraysAndString;

public class PartitionList {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    //  Add node at end
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //  Partition around value x
    public void partition(int x) {
        Node l1Head = null, l1Tail = null;
        Node l2Head = null, l2Tail = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = null; // Detach current node

            if (current.data < x) {
                // Add to less-than-x list
                if (l1Head == null) {
                    l1Head = l1Tail = current;
                } else {
                    l1Tail.next = current;
                    l1Tail = current;
                }
            } else {
                // Add to greater-or-equal list
                if (l2Head == null) {
                    l2Head = l2Tail = current;
                } else {
                    l2Tail.next = current;
                    l2Tail = current;
                }
            }

            current = next;
        }

        //  Connect both lists
        if (l1Tail != null) {
            l1Tail.next = l2Head;
            head = l1Head;
        } else {
            head = l2Head;
        }
    }

    //  Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //  Demo
    public static void main(String[] args) {
        PartitionList list = new PartitionList();
        int[] values = {3, 5, 8, 5, 10, 2, 1};

        for (int val : values) {
            list.add(val);
        }

        System.out.println("Before partition:");
        list.printList();

        int x = 5;
        list.partition(x);

        System.out.println("After partition around x = " + x + ":");
        list.printList();
    }
}
