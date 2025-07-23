import java.util.*;

class Solution {
    
    static int tNum;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        tNum = target;
        
        dfs(0, numbers);
        
        return cnt;
    }
    
    static void dfs(int idx, int[] numbers) {
        LinkedList<int[]> s = new LinkedList<>();
        s.offerLast(new int[] {idx, numbers[idx]});
        s.offerLast(new int[] {idx, numbers[idx] * -1});
    
        while (!s.isEmpty()) {
            int[] poll = s.pollLast();
            
            if (poll[0] == numbers.length - 1) {
                if (poll[1] == tNum) {
                    cnt++;
                }
            }
            
            if (poll[0] >= numbers.length - 1) continue;
            
            s.offerLast(new int[] {poll[0] + 1, poll[1] + numbers[poll[0] + 1]});
            s.offerLast(new int[] {poll[0] + 1, poll[1] + -1 * numbers[poll[0] + 1]});
        }  
    }
}