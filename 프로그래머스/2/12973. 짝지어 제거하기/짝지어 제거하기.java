import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            Character peekNum = stack.peekLast();
            if (peekNum != null) {
                if (peekNum == c) {
                    stack.pollLast();
                } else {
                    stack.offerLast(c);
                }
            } else {
                stack.offerLast(c);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        

        return answer;
    }
}