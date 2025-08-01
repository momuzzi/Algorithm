import java.util.*;

class Solution {
    
    static Set<Set<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {    
        bt(user_id, banned_id, 0, new HashSet<>());
        
        return set.size();
    }
    
    static void bt(String[] user_id, String[] banned_id, int depth, Set<String> c) {
        if (depth == banned_id.length) {
            set.add(new HashSet<>(c));
            return;
        }    
            
        for (int i = 0; i < user_id.length; i++) {
            if (c.contains(user_id[i])) continue;
                
            if (!match(user_id[i], banned_id[depth])) continue;
                
            c.add(user_id[i]);
            bt(user_id, banned_id, depth + 1, c);
            c.remove(user_id[i]);
        }
    }
    
    static boolean match(String banId, String userId) {
        if (banId.length() != userId.length()) return false;
        
        for (int i = 0; i < banId.length(); i++) {
            if (userId.charAt(i) == '*') continue;
            
            if (banId.charAt(i) != userId.charAt(i)) return false;
        }
        
        return true;
    }
}