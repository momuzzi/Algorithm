import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int head = 0;
        int tail = 10;
        while (tail <= discount.length) {
            Map<String, Integer> copyMap = new HashMap<>(map);
            
            int totalCnt = 0;
            for (int i = head; i < tail; i++) {
                if (copyMap.containsKey(discount[i])) {
                    int getCnt = copyMap.get(discount[i]);
                    
                    if (getCnt > 0) {
                        copyMap.put(discount[i], getCnt - 1);
                        totalCnt++;
                    }
                }
            }
            
            if (totalCnt == 10) {
                answer++;
            }
            
            head++;
            tail++;
        }
        
        return answer;
    }
}