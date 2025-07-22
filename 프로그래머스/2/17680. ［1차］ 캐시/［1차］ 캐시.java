import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> q = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (q.contains(city)) {
                int idx = q.indexOf(city);
                q.remove(idx);
                answer += 1;
            } else {
                if (cacheSize != 0 && q.size() == cacheSize) {
                    q.pollFirst();
                }
                
                answer += 5;
            }
            
            if (cacheSize != 0) {
                q.offerLast(city);
            }
        }
        
        return answer;
    }
}