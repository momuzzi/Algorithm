import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        LinkedList<int[]> s = new LinkedList<>();
        
        s.offerLast(new int[] {numbers[0], 0});
        
        for (int i = 1; i < numbers.length; i++) {
            while (!s.isEmpty() && s.peekLast()[0] < numbers[i]) {
                int[] poll = s.pollLast();
                
                answer[poll[1]] = numbers[i];
            }
            
            s.offerLast(new int[] {numbers[i], i});
        }
        
        if (!s.isEmpty()) {
            for (int[] arr : s) {
                answer[arr[1]] = -1;
            }
        }
        
        return answer;
    }
}