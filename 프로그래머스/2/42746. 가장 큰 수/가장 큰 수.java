import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        String[] strArray = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            strArray[i] = String.valueOf(numbers[i]); 
        }
        
        Arrays.sort(strArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if (strArray[0].equals("0")) {
            return "0";
        }
        
        StringBuilder builder = new StringBuilder();
        for (String str : strArray) {
            builder.append(str);
        }
        
        return builder.toString();
    }
}