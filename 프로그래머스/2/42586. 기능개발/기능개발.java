import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int l = 100 - progresses[i];
            
            int mok = l / speeds[i];
            int mod = l % speeds[i];
            
            if (mod == 0) {
                q.offerLast(mok);
            } else {
                q.offerLast(mok + 1);
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while (!q.isEmpty()) {    
            int pollNum = q.pollFirst();
        
            int cnt = 1;
            while (!q.isEmpty() && q.peekFirst() <= pollNum) {
                q.pollFirst();
                cnt++;
            }
            
            answerList.add(cnt);
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}