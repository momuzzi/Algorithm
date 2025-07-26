import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offerLast(queue1[i]);
        }
        
        long sum2 = 0;
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.offerLast(queue2[i]);
        }

        if ((sum1 + sum2) % 2 != 0) return -1;
        
        int cnt = 0;
        int loop = queue1.length * 3;
        while (sum1 != sum2) {
            if (loop == 0) return -1;
            
            if (sum1 > sum2) {
                int num = q1.pollFirst();
                q2.offerLast(num);
                sum1 -= num;
                sum2 += num;
            } else {
                int num = q2.pollFirst();
                q1.offerLast(num);
                sum2 -= num;
                sum1 += num;
            }
            
            cnt++;
            loop--;
        }
        
        answer = cnt;
        
        return answer;
    }
}