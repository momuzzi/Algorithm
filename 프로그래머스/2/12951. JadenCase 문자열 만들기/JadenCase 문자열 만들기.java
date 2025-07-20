class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean isHead = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer += c;
                isHead = true;
            } else {
                if (isHead) {
                    answer += Character.toUpperCase(c);
                    isHead = false;
                } else {
                    answer += Character.toLowerCase(c);
                }
            }
        }
        
        return answer;
    }
}