import java.util.*;

class Solution {
    
    public int solution(int[] a) {
        int answer = 2;
        
        int[] leftMin = new int[a.length];
        leftMin[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        int[] rightMin = new int[a.length];
        rightMin[rightMin.length - 1] = a[a.length - 1];
        for (int i = rightMin.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        for (int i = 1; i < a.length - 1; i++) {
            if (!(leftMin[i] != a[i] && rightMin[i] != a[i])) {
                answer++;
            }
        }
        
        return answer;
    }
}