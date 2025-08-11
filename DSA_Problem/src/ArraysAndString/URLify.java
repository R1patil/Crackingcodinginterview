package ArraysAndString;

public class URLify {
    public static void main(String[] args) {
        char[] input = "Mr John Smith    ".toCharArray();
        int trueLength = 13;

        urlify(input, trueLength);
        System.out.println(new String(input));
    }

    public static void urlify(char[] str, int trueLength) {
        int spaceCount = 0;

        // Count spaces in the true length
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;

        // If there’s no extra space at the end, this avoids ArrayIndexOutOfBounds
        if (trueLength < str.length) str[trueLength] = '\0';

        // Work backwards through the array
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
