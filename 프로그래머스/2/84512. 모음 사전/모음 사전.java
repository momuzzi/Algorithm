import java.util.*;

class Solution {
    
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static List<String> words = new ArrayList<>();
    
    public int solution(String word) {
        dfs(0, "");

        return words.indexOf(word);    
    }
    
    static void dfs(int length, String word) {
        words.add(word);
        
        if (length == 5) return;
        
        for (int i = 0; i < alpha.length; i++) {
            dfs(length + 1, word + alpha[i]);
        }
    }
}