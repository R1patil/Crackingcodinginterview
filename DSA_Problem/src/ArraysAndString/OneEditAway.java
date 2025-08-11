package ArraysAndString;

public class OneEditAway {
    public static void main(String[] args) {
        OneEditAway checker = new OneEditAway();

        System.out.println(checker.oneEditAway("pale", "ple"));   // true
        System.out.println(checker.oneEditAway("pales", "pale")); // true
        System.out.println(checker.oneEditAway("pale", "bale"));  // true
        System.out.println(checker.oneEditAway("pale", "bake"));  // false
    }

    public boolean oneEditAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return oneEditInsert(s2, s1);
        }

        return false;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private boolean oneEditInsert(String shorter, String longer) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < shorter.length() && index2 < longer.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                if (index1 != index2) return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
