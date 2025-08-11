package Stack_Queue;

import java.util.*;

public class MyQueue {
    Stack<Integer> stackNewest = new Stack<>();
    Stack<Integer> stackOldest = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        stackNewest.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }

        if (stackOldest.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return stackOldest.pop();
    }

    // Main to test
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20

        queue.enqueue(40);
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // 40
    }
}
