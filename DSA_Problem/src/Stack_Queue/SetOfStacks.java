package Stack_Queue;

import java.util.*;

public class SetOfStacks {
    private List<Stack<Integer>> stacks = new ArrayList<>();
    private int threshold;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(int value) {
        // If no stacks yet, or last stack is full → create new stack
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == threshold) {
            stacks.add(new Stack<>());
        }

        // Push to last stack
        stacks.get(stacks.size() - 1).push(value);
    }

    // Optional: view current state
    public void printStacks() {
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println("Stack " + i + ": " + stacks.get(i));
        }
    }
    public int pop() {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        Stack<Integer> last = stacks.get(stacks.size() - 1);
        int value = last.pop();

        // If the last stack is now empty, remove it
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }
    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException("Invalid stack index");
        }

        Stack<Integer> target = stacks.get(index);
        int value = target.pop();

        // Remove the stack if it's now empty
        if (target.isEmpty()) {
            stacks.remove(index);
        }

        return value;
    }


    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);

        for (int i = 1; i <= 10; i++) {
            stacks.push(i);
        }

        stacks.printStacks();
        System.out.println("Pop from stack 1: " + stacks.popAt(1));
        stacks.printStacks();

    }
}
