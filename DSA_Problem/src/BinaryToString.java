public class BinaryToString {

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR"; // only allow numbers between 0 and 1
        }

        StringBuilder binary = new StringBuilder();
        binary.append("0.");

        while (num > 0) {
            if (binary.length() >= 34) { // includes "0." → max 32 binary digits
                return "ERROR";
            }

            num *= 2;
            if (num >= 1) {
                binary.append("1");
                num -= 1;
            } else {
                binary.append("0");
            }
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBinary(0.625));  // Output: 0.101
        System.out.println(printBinary(0.72));   // Output: ERROR
        System.out.println(printBinary(0.5));    // Output: 0.1
        System.out.println(printBinary(0.25));   // Output: 0.01
    }
}
