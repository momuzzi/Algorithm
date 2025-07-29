import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 문자, 인덱스
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String sk = skill_trees[i];
            
            int beforeIdx = -1;
            boolean flag = true;
            for (int j = 0; j < sk.length(); j++) {
                if (map.containsKey(sk.charAt(j))) {
                    if (map.get(sk.charAt(j)) == beforeIdx + 1) {
                        beforeIdx = map.get(sk.charAt(j));
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}