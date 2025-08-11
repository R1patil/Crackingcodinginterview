public class FlipBitToWin {

    public static int flipBit(int n) {
        // Edge case: all bits are 1
        if (~n == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // at least one bit can be flipped

        while (n != 0) {
            if ((n & 1) == 1) {
                currentLength++;
            } else {
                // Check next bit
                if ((n & 2) == 0) {
                    previousLength = 0;
                } else {
                    previousLength = currentLength;
                }
                currentLength = 0;
            }

            maxLength = Math.max(previousLength + 1 + currentLength, maxLength);
            n >>= 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int num = 0b11011101111; // 1775
        System.out.println(flipBit(num)); // Output: 8
    }
}
