class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        int oneCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') oneCnt++;
        }
        
        for (int i = n + 1; i <= 1_000_000; i++) {
            String str2 = Integer.toBinaryString(i);
            int oneCnt2 = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == '1') oneCnt2++;
            }
            
            if (oneCnt == oneCnt2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}