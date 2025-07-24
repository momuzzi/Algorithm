import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String opLine : operations) {
            String[] op = opLine.split(" ");
            int num = Integer.parseInt(op[1]);

            if (op[0].equals("I")) {
                minQ.offer(num);
                maxQ.offer(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                if (num == 1) {
                    clean(maxQ, map);
                    if (!maxQ.isEmpty()) {
                        int pollNum = maxQ.poll();
                        map.put(pollNum, map.get(pollNum) - 1);
                        if (map.get(pollNum) == 0) map.remove(pollNum);
                    }
                } else {
                    clean(minQ, map);
                    if (!minQ.isEmpty()) {
                        int pollNum = minQ.poll();
                        map.put(pollNum, map.get(pollNum) - 1);
                        if (map.get(pollNum) == 0) map.remove(pollNum);
                    }
                }
            }
        }
        
        clean(maxQ, map);
        clean(minQ, map);
        
        if (map.isEmpty()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        return answer;
    }
    
    static void clean(PriorityQueue<Integer> q, Map<Integer, Integer> map) {
        while (!q.isEmpty() && map.getOrDefault(q.peek(), 0) == 0) {
            q.poll();
        }
    }
}