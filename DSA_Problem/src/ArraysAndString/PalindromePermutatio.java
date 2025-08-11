package ArraysAndString;

import java.util.HashMap;
import java.util.Map;
// we are cheaking the string is Angarm or permuataion bcz its differnt string
//  At most one character can have an odd count
// "taco cat" "acto cta"
public class PalindromePermutatio {
    public static void main(String[] args) {
        String name="Tact Coa";
         PalindromePermutatio p=new PalindromePermutatio();
         System.out.println(p.checkPermutation(name));
    }
    public boolean checkPermutation(String name){
        Map<Character,Integer> map=new HashMap<>();
        for(char c:name.toLowerCase().toCharArray()){
            if(c==' ') continue;
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int Oddcount=0;
        for(int count:map.values()){
            if(count%2!=0){
                Oddcount++;
                if(Oddcount>1){
                    return false;
                }
            }
        }
        return true;
    }
}
