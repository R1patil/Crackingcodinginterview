package Stack_Queue;

import java.util.Stack;

public class MySorter {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        System.out.println("Before sorting: " + stack);

        MySorter s = new MySorter();  // your class name
        s.sortStack(stack);

        System.out.println("After sorting: " + stack);
    }

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }

            tempStack.push(current);
        }

        // Move sorted values back to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

}
