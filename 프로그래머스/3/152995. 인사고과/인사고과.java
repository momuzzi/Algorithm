import java.util.*;

class Solution {
    
    static class Node {
        int sum;
        int index;
        
        Node(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }    
    }
    
    public int solution(int[][] scores) {
        int maxWorkNum = 0;
        for (int i = 0; i < scores.length; i++) {
            int[] score = scores[i];
            maxWorkNum = Math.max(maxWorkNum, score[0]);
        }
        
        PriorityQueue<Integer>[] arr = new PriorityQueue[maxWorkNum + 1];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }
        
        for (int i = 0; i < scores.length; i++) {
            int[] score = scores[i];
            arr[score[0]].offer(score[1]);
        }
        
        int[] maxPeekFromRight = new int[maxWorkNum + 1];
        for (int i = maxWorkNum; i >= 0; i--) {
            int max = arr[i].isEmpty() ? 0 : arr[i].peek();
            
            if (i == maxWorkNum) {
                maxPeekFromRight[i] = max;
            } else {
                maxPeekFromRight[i] = Math.max(max, maxPeekFromRight[i + 1]);
            } 
        }
        
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            int[] score = scores[i];
            
            if (score[0] != maxWorkNum && maxPeekFromRight[score[0] + 1] > score[1]) continue;
            
            list.add(new Node(score[0] + score[1], i));
        }
        
        list.sort((a, b) -> Integer.compare(b.sum, a.sum));
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).index == 0) return i + 1;
        }
        
        return -1;
    }
}