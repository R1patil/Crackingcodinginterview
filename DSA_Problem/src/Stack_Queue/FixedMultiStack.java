package Stack_Queue;

public class FixedMultiStack {

    private int numStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        values = new int[stackCapacity * numStacks];
        sizes = new int[numStacks]; // all initialized to 0
    }

    // Push operation
    public void push(int stackNum, int value) {
        if (sizes[stackNum] >= stackCapacity) {
            throw new IllegalStateException("Stack " + stackNum + " is full");
        }

        int index = stackNum * stackCapacity + sizes[stackNum];
        values[index] = value;
        sizes[stackNum]++;
    }

    // Pop operation
    public int pop(int stackNum) {
        if (sizes[stackNum] == 0) {
            throw new IllegalStateException("Stack " + stackNum + " is empty");
        }

        int topIndex = stackNum * stackCapacity + sizes[stackNum] - 1;
        int value = values[topIndex];
        values[topIndex] = 0; // optional cleanup
        sizes[stackNum]--;
        return value;
    }

    // Peek operation
    public int peek(int stackNum) {
        if (sizes[stackNum] == 0) {
            throw new IllegalStateException("Stack " + stackNum + " is empty");
        }

        int topIndex = stackNum * stackCapacity + sizes[stackNum] - 1;
        return values[topIndex];
    }

    // Test the stacks
    public static void main(String[] args) {
        FixedMultiStack stacks = new FixedMultiStack(3); // 3 stacks of size 3 each

        stacks.push(0, 10);
        stacks.push(0, 20);
        stacks.push(0, 30);

        stacks.push(1, 100);
        stacks.push(1, 200);

        stacks.push(2, 1000);

        System.out.println("Top of Stack 0: " + stacks.peek(0)); // 30
        System.out.println("Pop from Stack 0: " + stacks.pop(0)); // 30
        System.out.println("New Top of Stack 0: " + stacks.peek(0)); // 20

        System.out.println("Top of Stack 1: " + stacks.peek(1)); // 200
        System.out.println("Top of Stack 2: " + stacks.peek(2)); // 1000
    }
}
