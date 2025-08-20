class Solution {
    /**
     * Finds the single element in an array where every other element appears exactly three times.
     * Uses a bit-counting approach to achieve O(1) space and O(n) time.
     *
     * Intuition: For each bit position (0 to 31), the count of set bits across all numbers
     * will be a multiple of 3 for all bits belonging to the triple numbers, plus 0 or 1 for
     * the bits belonging to the single number. Isolating these "extra" bits constructs the answer.
     *
     * This approach is chosen over a HashMap to meet the constant space requirement.
     * It handles negative numbers correctly by checking all 32 bits.
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate over each bit position in a 32-bit integer.
        // We must check all 32 bits to handle negative numbers (two's complement representation).
        for (int i = 0; i < 32; i++) {
            int count = 0;
            // Create a mask to isolate the i-th bit. For example, i=0: 0001, i=1: 0010.
            int mask = 1 << i;

            // Count the total number of times the i-th bit is set across all numbers.
            for (int num : nums) {
                // Using bitwise AND with the mask checks if the specific bit is set.
                // The condition is `!= 0` instead of `== 1` because the result of (num & mask)
                // is the value of the bit *in its original position* (e.g., 2, 4, 8), not 1.
                if ((num & mask) != 0) {
                    count++;
                }
            }

            // The core logic: For the single number, its bits will appear once.
            // For the numbers appearing three times, their bits contribute counts that are multiples of 3.
            // Therefore, if the total count for a bit is not a multiple of 3 (mod 3 == 1),
            // it means the single number has this bit set.
            if (count % 3 == 1) {
                // Set the corresponding bit in the result. This builds the answer one bit at a time.
                result |= mask;
            }
        }
        return result;
    }
}