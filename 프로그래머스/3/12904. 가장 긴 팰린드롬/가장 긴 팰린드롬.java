class Solution
{
    public int solution(String s)
    {
        int answer = Integer.MIN_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, isP(i, i, s));
            answer = Math.max(answer, isP(i, i - 1, s));
        }

        return answer;
    }
    
    static int isP(int l, int r, String s) {
        while (l >= 0 && r >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return r - l - 1;
    }
}