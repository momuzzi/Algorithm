import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        if (gems.length == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        
        Set<String> totalSet = new HashSet<>();
        
        for (String gem : gems) {
            totalSet.add(gem);
        }

        int start = 0;
        int end = 0;
        Set<String> calSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        calSet.add(gems[0]);
        map.put(gems[0], 1);
    
        int minLength = Integer.MAX_VALUE;
        
        while (start <= end && end < gems.length) {    
            if (calSet.size() < totalSet.size()) {
                end++;
                
                if (end == gems.length) break;
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                calSet.add(gems[end]);
            } else if (calSet.size() == totalSet.size()) {
                if (minLength > end - start) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                
                if (map.get(gems[start]) == 1) {
                    map.put(gems[start], 0);
                    calSet.remove(gems[start++]);
                } else {
                    map.put(gems[start], map.get(gems[start]) - 1);
                    start++;
                }
            }
        }
        
        return answer;
    }
}