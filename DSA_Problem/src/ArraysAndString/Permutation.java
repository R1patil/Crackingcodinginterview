package ArraysAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        String s1="Rahul";
        String s2="Rahul";
        Permutation p=new Permutation();
        System.out.println(p.checkPermutation(s1,s2));
        System.out.println(p.checkPermutationSort(s2,s1));

    }
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:s2.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c)-1);
            if(map.get(c)<0){
                return false;
            }
        }
        return true;
    }

    public boolean checkPermutationSort(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
