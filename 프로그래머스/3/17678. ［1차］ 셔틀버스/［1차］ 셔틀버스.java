import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int[] timeArr = new int[timetable.length];
    
        for (int i = 0; i < timeArr.length; i++) {
            timeArr[i] = cal(timetable[i]);
        }
        
        Arrays.sort(timeArr);
        
        int busArriveTime = 3600 * 9; // 09:00, 9시 1번 적립
        int busLastTime = busArriveTime + (n - 1) * t * 60;
        int completeCrew = -1; // 탑승 처리된 마지막 크루 인덱스
        int lastRemainBusChair = 0;
        for (int i = 0; i < n; i++) { //n회 버스가 온다
            int canTakeCnt = m; // 탑승 가능 인원
            for (int j = completeCrew + 1; j < timeArr.length; j++) {
                if (canTakeCnt == 0) break;
                
                if (busArriveTime >= timeArr[j]) { // 버스 도착 시각보다 먼저 와 있는 크루인 경우
                    completeCrew = j;
                    canTakeCnt--; // 탑승 처리
                    lastRemainBusChair = canTakeCnt;
                } else break; // 아닌 경우 해당 버스 더 이상 인원 안태움
            }
            
            if (completeCrew + 1 < timeArr.length && timeArr[completeCrew + 1] > busLastTime) break;
            
            if (i != n - 1) {
                busArriveTime += t * 60;
            }
        }
        
        int time = 0;
        // 마지막 탑승 처리된 크루가 존재하면
        if (completeCrew != -1) {
            if (lastRemainBusChair > 0) {
                time = busArriveTime;
            } else {
                if (busArriveTime < busLastTime) {
                    time = busLastTime;
                } else {
                    time = timeArr[completeCrew] - 60; // 마지막에 자리가 안남았으니 마지막 크루보단 1분 일찍오도록
                }
            }
        } else { // 모든 크루가 버스를 못탔다면
            time = busLastTime; // 마지막 버스 탑승
        }
        
        int hour = time / 3600;
        int min = (time % 3600) / 60;
        
        String hourString = hour <= 9 ? "0" + hour : String.valueOf(hour);
        String minString = min <= 9 ? "0" + min : String.valueOf(min);        
        
        answer = hourString + ":" + minString;
        return answer;
    }
    
    static int cal(String str) {
        String[] sub = str.split(":");
        int hour = Integer.parseInt(sub[0]);
        int min = Integer.parseInt(sub[1]);
        
        int total = 3600 * hour + 60 * min;
        
        return total;
    }

}