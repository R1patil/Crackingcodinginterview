package Linked_List;

import java.util.Scanner;

public class kthElement {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

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

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int getKthToLastElement(int k) {
        int length = getLength();
        int indexFromStart = length - k;

        if (indexFromStart < 0) {
            throw new IllegalArgumentException("k is larger than the list size.");
        }

        Node temp = head;
        for (int i = 0; i < indexFromStart; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        kthElement list = new kthElement();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            list.addElement(input.nextInt());
        }

        System.out.print("Enter k: ");
        int k = input.nextInt();

        try {
            int result = list.getKthToLastElement(k);
            System.out.println("The " + k + "th to last element is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }
}
