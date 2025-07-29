import java.util.*;

class Solution {
    
    public int solution(String dirs) {        
        Set<String> set = new HashSet<>();
        
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char op = dirs.charAt(i);
            String path = null;
            String reversePath = null;
            if (op == 'U') {
                if (y == 5) continue;
                y++;
                path = String.valueOf(x) + String.valueOf(y - 1) + String.valueOf(x) + String.valueOf(y);
                reversePath = String.valueOf(x) + String.valueOf(y) + String.valueOf(x) + String.valueOf(y - 1);
            }
            
            if (op == 'D') {
                if (y == -5) continue;
                y--;
                path = String.valueOf(x) + String.valueOf(y + 1) + String.valueOf(x) + String.valueOf(y);
                reversePath = String.valueOf(x) + String.valueOf(y) + String.valueOf(x) + String.valueOf(y + 1);
            }
            
            if (op == 'R') {
                if (x == 5) continue;
                x++;
                path = String.valueOf(x - 1) + String.valueOf(y) + String.valueOf(x) + String.valueOf(y);
                reversePath = String.valueOf(x) + String.valueOf(y) + String.valueOf(x - 1) + String.valueOf(y);
            }
            
            if (op == 'L') {
                if (x == -5) continue;
                x--;
                path = String.valueOf(x + 1) + String.valueOf(y) + String.valueOf(x) + String.valueOf(y);   
                reversePath = String.valueOf(x) + String.valueOf(y) + String.valueOf(x + 1) + String.valueOf(y);
            }
            
            set.add(path);
            set.add(reversePath);
        }
        
        return set.size() / 2;
    }
}