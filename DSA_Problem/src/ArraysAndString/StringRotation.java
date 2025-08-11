package ArraysAndString;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        String combined = s1 + s1;
        return combined.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println("Is rotation? " + isRotation(s1, s2));  // Output: true

        String s3 = "bottlewater";
        System.out.println("Is rotation? " + isRotation(s1, s3));  // Output: true

        String s4 = "bottlewat";  
        System.out.println("Is rotation? " + isRotation(s1, s4));  // Output: false
    }
}
