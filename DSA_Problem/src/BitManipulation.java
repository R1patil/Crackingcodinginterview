public class BitManipulation {

    // Swaps odd and even bits of an integer
    public static int swapOddEvenBits(int x) {
        // 0xAAAAAAAA = 101010... in binary (odd bits set)
        // 0x55555555 = 010101... in binary (even bits set)
        int evenBits = x & 0x55555555;
        int oddBits = x & 0xAAAAAAAA;

        evenBits <<= 1;  // shift even bits to odd positions
        oddBits >>= 1;   // shift odd bits to even positions

        return evenBits | oddBits;
    }

    // Optional: Test it
    public static void main(String[] args) {
        int x = 42; // 0b101010
        System.out.println("Original:      " + Integer.toBinaryString(x));
        System.out.println("Swapped:       " + Integer.toBinaryString(swapOddEvenBits(x)));
        System.out.println("Decimal result: " + swapOddEvenBits(x));
    }
}
