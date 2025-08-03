import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : topping) {
            set.add(t);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> firstPiece = new HashSet<>();
        for (int t : topping) {
            if (set.size() == firstPiece.size()) {
                answer++;
            }
            
            int mapGet = map.get(t);
            firstPiece.add(t);
            if (mapGet - 1 == 0) {
                map.remove(t);
                set.remove(t);
            } else {
                map.put(t, mapGet - 1);
            }
        }
        
        return answer;
    }
}