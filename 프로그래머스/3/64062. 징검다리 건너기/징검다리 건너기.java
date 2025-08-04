import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int l = 1;
        int h = 200_000_000;
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (cross(m, k, stones)) {
                answer = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return answer;
    }
    
    static boolean cross(int m, int k, int[] stones) {
        int zeroCnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - m < 0) {
                zeroCnt++;
            } else {
                zeroCnt = 0;
            }
            
            if (zeroCnt == k) return false;
        }
        
        return true;
    }
}