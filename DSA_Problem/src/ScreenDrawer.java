public class ScreenDrawer {

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int bytesPerRow = width / 8;
        int rowStart = y * bytesPerRow;

        int startOffset = x1 % 8;
        int firstByte = rowStart + (x1 / 8);

        int endOffset = x2 % 8;
        int lastByte = rowStart + (x2 / 8);

        // Case 1: x1 and x2 are in the same byte
        if (firstByte == lastByte) {
            int mask = (0xFF >> startOffset) & (0xFF << (7 - endOffset));
            screen[firstByte] |= (byte) mask;
        } else {
            // Set start byte
            int startMask = 0xFF >> startOffset;
            screen[firstByte] |= (byte) startMask;

            // Set full bytes in between
            for (int i = firstByte + 1; i < lastByte; i++) {
                screen[i] = (byte) 0xFF;
            }

            // Set end byte
            int endMask = 0xFF << (7 - endOffset);
            screen[lastByte] |= (byte) endMask;
        }
    }

    // Optional: to visualize in binary
    public static void printScreen(byte[] screen, int width) {
        for (int i = 0; i < screen.length; i++) {
            if (i % (width / 8) == 0) System.out.println();
            System.out.print(String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0') + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int width = 16;
        byte[] screen = new byte[width / 8 * 2];  // 2 rows

        drawLine(screen, width, 3, 13, 1);

        printScreen(screen, width);  // should print line on row 1 from pixel 3 to 13
    }
}
