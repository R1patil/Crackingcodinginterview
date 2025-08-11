package Linked_List;

import java.util.Scanner;

public class KthToLast_TwoPointer {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    // ✅ Add node at the end
    public void addElement(int value) {
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

    // ✅ Two-pointer method to get kth to last node
    public int getKthToLast(int k) {
        Node fast = head;
        Node slow = head;

        // Move fast k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("k is larger than the list size");
            }
            fast = fast.next;
        }

        // Move both pointers until fast hits the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    // Optional: print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        KthToLast_TwoPointer list = new KthToLast_TwoPointer();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            list.addElement(input.nextInt());
        }

        System.out.print("Enter k (to get kth to last element): ");
        int k = input.nextInt();

        try {
            int result = list.getKthToLast(k);
            System.out.println("The " + k + "th to last element is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }
}
