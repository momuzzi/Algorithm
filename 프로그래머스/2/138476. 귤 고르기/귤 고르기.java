import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> list = map.values().stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        
        for (int i = 0; i < list.size(); i++) {
            int cnt = list.get(i);
            
            if (k > cnt) {
                k -= cnt;
                answer++;
                continue;
            }
            
            if (k <= cnt) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}