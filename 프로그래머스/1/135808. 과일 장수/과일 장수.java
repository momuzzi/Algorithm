import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int cnt = m;
        for (int i = score.length - 1; i >= 0; i--) {
            cnt--;
            
            if (cnt == 0) {
                answer += score[i] * m;
                
                cnt = m;
            }
        }
        
        return answer;
    }
}