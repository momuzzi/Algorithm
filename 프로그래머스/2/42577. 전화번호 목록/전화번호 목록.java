import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        Arrays.sort(phone_book);
     
        String prefix = "prefix";
        
        Set<String> strSet = new HashSet<>();
        
        for (String str : phone_book) {
            if (str.startsWith(prefix)) {
                return false;
            }
            
            strSet.add(str);
            prefix = str;
        }
        
        return true;
    }
}