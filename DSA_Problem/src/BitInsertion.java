public class BitInsertion {

    public static int insertBits(int N, int M, int i, int j) {
        // Step 1: Create a mask to clear bits i through j in N
        int allOnes = ~0; // 111111... all 1s

        int left = allOnes << (j + 1);  // 1s before position j
        int right = (1 << i) - 1;       // 1s after position i

        int mask = left | right;        // 1s everywhere except i to j

        // Step 2: Clear bits i through j in N
        int n_cleared = N & mask;

        // Step 3: Shift M into position
        int m_shifted = M << i;

        // Step 4: OR them together
        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        int N = 1024; // 10000000000
        int M = 19;   // 10011
        int i = 2;
        int j = 6;

        int result = insertBits(N, M, i, j);
        System.out.println("Result: " + result); // Output: 1100
    }
}
