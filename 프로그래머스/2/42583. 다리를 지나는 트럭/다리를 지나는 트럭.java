import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {       
        LinkedList<int[]> q = new LinkedList<>();
        
        q.offerLast(new int[] {truck_weights[0], 1});
        int time = 1;
        int idx = 1;
        int totalWeight = truck_weights[0];
        while (!q.isEmpty()) {
            time++;
            if (time - q.peekFirst()[1] == bridge_length) {
                totalWeight -= q.pollFirst()[0];
            }
            
            if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight && q.size() < bridge_length) {
                totalWeight += truck_weights[idx];
                q.offerLast(new int[] {truck_weights[idx], time});
                idx++;
            }
        }
        
        return time;
    }
}