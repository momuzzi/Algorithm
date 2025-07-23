import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<Node> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offerLast(new Node(priorities[i], i));
        }
        
        Arrays.sort(priorities);
        
        int idx = priorities.length - 1;
        int maxNum = priorities[idx];
        int turn = 1;
        while (true) {
            Node pollNode = q.pollFirst();
            
            if (pollNode.num == maxNum) {
                if (pollNode.location == location) {
                    break;
                }
                
                maxNum = priorities[--idx];
                turn++;
            } else {
                q.offerLast(pollNode);
            }
        }
        
        return turn;
    }
    
    static class Node {
        int num;
        int location;
        
        Node(int num, int location) {
            this.num = num;
            this.location = location;
        }
    }
    
}