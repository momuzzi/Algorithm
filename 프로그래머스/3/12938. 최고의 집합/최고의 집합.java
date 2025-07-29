import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int mok = s / n;
        int mod = s % n;
        
        if (mok == 0) {
            return new int[] {-1};
        }
        
        Arrays.fill(answer, mok);
        
        if (mod != 0) {
            for (int i = n - 1; i >= 0; i--) {
                if (mod == 0) break;
                answer[i]++;
                mod--;
            }         
        }
        
        return answer;
    }
}