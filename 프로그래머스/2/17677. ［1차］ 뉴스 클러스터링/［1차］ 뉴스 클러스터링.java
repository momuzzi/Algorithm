import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> list1 = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            if (i == str1.length() - 1) break;
            
            String str = str1.substring(i, i + 2);
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                list1.add(str.toLowerCase());
                map1.put(str.toLowerCase(), map1.getOrDefault(str.toLowerCase(), 0) + 1);
            }
        }
        
        List<String> list2 = new ArrayList<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < str2.length(); i++) {
            if (i == str2.length() - 1) break;
            
            String str = str2.substring(i, i + 2);
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                list2.add(str.toLowerCase());
                map2.put(str.toLowerCase(), map2.getOrDefault(str.toLowerCase(), 0) + 1);
            }
        }
                
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < list1.size(); i++) {
            set.add(list1.get(i));
        }
        
        for (int i = 0; i < list2.size(); i++) {
            set.add(list2.get(i));
        }
        
        int multiSize = 0;
        int sumSize = 0;
        for (String str : set) {
            if (map1.containsKey(str) && map2.containsKey(str)) {
                int map1Cnt = map1.get(str);
                int map2Cnt = map2.get(str);
                
                int minCnt = Math.min(map1Cnt, map2Cnt);
                int maxCnt = Math.max(map1Cnt, map2Cnt);
                
                multiSize += minCnt;
                sumSize += maxCnt;
            } else if (map1.containsKey(str)) {
                int map1Cnt = map1.get(str);
                sumSize += map1Cnt;
            } else {
                int map2Cnt = map2.get(str);
                sumSize += map2Cnt;
            }
        }
        
        if (multiSize == 0 && sumSize == 0) {
            return 65536;
        }
        
        double j = (double) multiSize / (double) sumSize;
        
        answer = (int) (j * 65536);
        
        return answer;
    }
}