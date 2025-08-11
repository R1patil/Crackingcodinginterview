package Stack_Queue;

import java.util.Stack;
import java.util.EmptyStackException;

public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    // Push to stack
    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    // Pop from stack
    public int pop() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }

        int value = mainStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    // Get current minimum
    public int min() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    // Peek top of main stack
    public int peek() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack.peek();
    }

    // Test it
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(2);
        stack.push(2);
        stack.push(3);

        System.out.println("Current min: " + stack.min()); // 2
        stack.pop(); // removes 3
        stack.pop(); // removes 2
        System.out.println("Current min after pops: " + stack.min()); // 2
        stack.pop(); // removes 2
        System.out.println("Current min after removing all 2s: " + stack.min()); // 5
    }
}
