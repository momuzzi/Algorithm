import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] col;
    static boolean[] leftUp;
    static boolean[] rightUp;
    
    public int solution(int n) {    
        col = new boolean[n];
        leftUp = new boolean[2 * n - 1];
        rightUp = new boolean[2 * n - 1];
        
        bt(0, n);
        
        return answer;
    }
    
    static void bt(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!col[i] && !leftUp[n - (depth - i) - 1] && !rightUp[depth + i]) {
                col[i] = true;
                leftUp[n - (depth - i) - 1] = true;
                rightUp[depth + i] = true;
                bt(depth + 1, n);
                col[i] = false;
                leftUp[n - (depth - i) - 1] = false;
                rightUp[depth + i] = false;
            }
        }
    }
}