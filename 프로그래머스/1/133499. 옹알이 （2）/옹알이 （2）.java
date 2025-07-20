import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++) {
            int beforeIdx = -1;
            boolean continueFlag = true;
            boolean match = true;
            while (true) {
                for (int j = 0; j < 4; j++) {
                    if (babbling[i].startsWith(arr[j])) {
                        if (j == beforeIdx) {
                            continueFlag = false;
                            break;
                        };
                        
                        babbling[i] = babbling[i].substring(arr[j].length());
                        beforeIdx = j;
                        match = true;
                        break;
                    } else {
                        match = false;
                    }
                }
                
                if (!continueFlag || beforeIdx == -1 || !match) break;
                
                if (babbling[i].length() == 0) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}