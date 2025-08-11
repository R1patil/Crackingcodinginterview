package ArraysAndString;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Rotate layer by layer, starting from the outermost layer
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save top element
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3},
            {4,  5,  6},
            {7,  8,  9}
        };

        System.out.println("Before rotation:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("After rotation:");
        printMatrix(matrix);
    }
}
