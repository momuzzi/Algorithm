import java.util.*;

class Solution {
    
    static class Node {
        String transHead;
        int transNumber;
        int index;
        
        Node (String transHead, int transNumber, int index) {
            this.transHead = transHead;
            this.transNumber = transNumber;
            this.index = index;
        }
    }
    
    public String[] solution(String[] files) {        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (!a.transHead.equals(b.transHead)) {
                return a.transHead.compareTo(b.transHead);
            } else {
                if (a.transNumber != b.transNumber) {
                    return Integer.compare(a.transNumber, b.transNumber);
                } else {
                    return Integer.compare(a.index, b.index);
                }
            }
        });
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int headLastIdx = findHead(file);
            int numberLastIdx = findNumber(headLastIdx, file);
            
            String head = file.substring(0, headLastIdx + 1);
            String transHead = head.toLowerCase();
            String number = file.substring(headLastIdx + 1, numberLastIdx + 1);
            int transNumber = Integer.parseInt(number);
            
            pq.add(new Node(transHead, transNumber, i));
        }
        
        String[] answer = new String[pq.size()];

        for (int i = 0; i < answer.length; i++) {
            Node node = pq.poll();
            answer[i] = files[node.index];
        }
        
        return answer;
    }
    
    static int findHead(String file) {
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                return i - 1;
            }
        }
        
        return -1;
    }
    
    static int findNumber(int headIdx, String file) {
        int startIdx = headIdx + 1;
        int answerIdx = startIdx;
        
        for (int i = startIdx; i < file.length(); i++) {    
            if (!Character.isDigit(file.charAt(i))) {
                answerIdx = i - 1;
                break;
            }
            
            if (i - startIdx == 4) {
                answerIdx = i;
                break;
            }
            
            if (i == file.length() - 1) answerIdx = i;
        }
        
        return answerIdx;
    }
}