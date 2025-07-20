class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (true) {  
            int zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                }
            }
            answer[1] += zero;
            
            int num = s.length() - zero;
            
            if (num == 1) {
                if (zero > 0) {
                    answer[0]++;
                }
                break;
            }
            
            String str = "";
            int mok = 0;
            int mod = 0;
            while (true) {
                mok = num / 2;
                mod = num % 2;
                num = mok;
                str += mod;
                
                if (mok == 0) break;
            }
            
            s = str;
            answer[0]++;
        }
        
        return answer;
    }
}