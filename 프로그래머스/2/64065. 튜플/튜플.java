import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                i++;
                
                Set<Integer> set = new HashSet<>();
                int length = 0;
                while (s.charAt(i) != '}') {
                    String allStr = String.valueOf(s.charAt(i));
                    i++;
                    while (s.charAt(i) != '}' && s.charAt(i) != ',') {
                        allStr += String.valueOf(s.charAt(i));
                        i++;
                    }
                                        
                    int num = Integer.parseInt(allStr);
                    set.add(num);
                    length++;
                    
                    if (s.charAt(i) == ',') {
                        i++;
                    }
                }
                
                Node node = new Node(set, length);
                list.add(node);
            }
        }
        
        list.sort((a, b) -> Integer.compare(a.length, b.length));
        
        int[] answer = new int[list.size()];
        
        answer[0] = list.get(0).set.stream().collect(Collectors.toList()).get(0);
        Set<Integer> beforeSet = list.get(0).set;
        for (int i = 1; i < list.size(); i++) {
            Set<Integer> nowSet = list.get(i).set;
            
            for (int n : nowSet) {
                if (!beforeSet.contains(n)) {
                    answer[i] = n;
                    break;
                }
            }
            
            beforeSet = nowSet;
        }
        
        return answer;
    }
    
    static class Node {
        Set<Integer> set;
        int length;
        
        Node(Set<Integer> set, int length) {
            this.set = set;
            this.length = length;
        }
    }
}