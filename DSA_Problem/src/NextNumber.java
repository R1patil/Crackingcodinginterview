public class NextNumber {

    // 🔼 Get the next **larger** number with same number of 1s
    public static int getNext(int n) {
        int c = n;
        int c0 = 0; // count of trailing 0s
        int c1 = 0; // count of ones after trailing 0s

        // Step 1: Count trailing 0s (from right)
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        // Step 2: Count 1s after trailing 0s
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        // Edge case: if no bigger number exists
        if (c0 + c1 == 31 || c0 + c1 == 0) return -1;

        // Step 3: Position of right-most non-trailing 0
        int p = c0 + c1;

        // Step 4: Flip the 0 at position p
        n |= (1 << p);

        // Step 5: Clear all bits to the right of p
        n &= ~((1 << p) - 1);

        // Step 6: Insert (c1-1) ones at the right
        n |= (1 << (c1 - 1)) - 1;

        return n;
    }

    // 🔽 Get the next **smaller** number with same number of 1s
    public static int getPrev(int n) {
        int temp = n;
        int c0 = 0; // count of trailing 1s
        int c1 = 0; // count of 0s after trailing 1s

        // Step 1: Count trailing 1s
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        // If temp is 0, no smaller number possible
        if (temp == 0) return -1;

        // Step 2: Count 0s after trailing 1s
        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        // Step 3: Position of right-most non-trailing 1
        int p = c0 + c1;

        // Step 4: Clear bits from bit p onwards
        n &= (~0 << (p + 1));

        // Step 5: Insert (c1 + 1) ones, shifted to the left of c0
        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);

        return n;
    }

    // ✅ Test it
    public static void main(String[] args) {
        int n = 45; // binary: 101101
        System.out.println("Original: " + n + " = " + Integer.toBinaryString(n));
        System.out.println("Next:     " + getNext(n) + " = " + Integer.toBinaryString(getNext(n)));
        System.out.println("Prev:     " + getPrev(n) + " = " + Integer.toBinaryString(getPrev(n)));
    }
}
