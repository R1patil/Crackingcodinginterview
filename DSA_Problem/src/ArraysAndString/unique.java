package ArraysAndString;

import java.util.HashSet;
import java.util.Set;

public class unique {
    // we use to solve the data data structure thats why space complexity is  0(N) and Time Complexity 0(N)
    // if we use the brute force then time complexity o(N2) and space complexity is o(1)
    // in the interview they will ask diff i have written both method below cheak it
    public static void main(String[] args) {
        String name="problemSloving";
        unique obj=new unique();
        //obj.ArraysAndString.unique(name);
        System.out.println(obj.uniqueUsingSet(name));
        System.out.println(obj.uniqueUsingBrute(name));
    }
    public boolean uniqueUsingSet(String arr) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<arr.length();i++){
            if(set.contains(arr.charAt(i))){
                return false;
            }
            set.add(arr.charAt(i));
        }
       return true;
    }

    // TIME COMPLEXITY 0(N2)
    // SPACE COMPLEXITY O(1)
    public boolean uniqueUsingBrute(String name){
        for(int i=0;i<name.length();i++){
            for(int j=i+1;j<name.length();j++) {
                if (name.charAt(i) == name.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
