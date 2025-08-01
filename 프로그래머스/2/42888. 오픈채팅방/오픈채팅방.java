import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        Map<String, String> map = new HashMap<>();
        int answerCnt = 0;
        for (int i = 0; i < record.length; i++) {
            String str = record[i];
            String[] split = str.split(" ");
            String action = split[0];
            String pk = split[1];
    
            if (split.length == 3) {
                String nickname = split[2];
                map.put(pk, nickname);
            }
            
            if (!action.equals("Change")) {
                answerCnt++;
            }
        }
        
        String[] answer = new String[answerCnt];
        
        int idx = 0;
        int cnt = 0;
        while (cnt < answerCnt) {
            String str = record[idx];
            String[] split = str.split(" ");
            String action = split[0];
            String pk = split[1];
                        
            if (action.equals("Enter")) {
                answer[cnt] = map.get(pk) + "님이 들어왔습니다.";
                cnt++;
            }
            
            if (action.equals("Leave")) {
                answer[cnt] = map.get(pk) + "님이 나갔습니다.";
                cnt++;
            }
            
            idx++;
        }
        
        return answer;
    }
}