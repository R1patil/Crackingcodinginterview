package ArraysAndString;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression  obj = new StringCompression();

        System.out.println(obj.compressString("aabcccccaaa")); // a2b1c5a3
        System.out.println(obj.compressString("abcabc"));      // abcabc
        System.out.println(obj.compressString("aabb"));        // aabb
        System.out.println(obj.compressString("aaaa"));        // a4
    }
    public String compressString(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }

        // Append the last group
        sb.append(s.charAt(s.length() - 1));
        sb.append(count);

        // Return the shorter of the original or compressed
        return sb.length() < s.length() ? sb.toString() : s;
    }


}
