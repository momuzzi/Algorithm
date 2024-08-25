import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 그리드 알고리즘을 사용하기 위해 가장 먼저 배열들을 정렬해준다
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 1. 도난 당하지 않은 학생 수 = 전체 학생 수 - lost 학생 수
        int answer = n - lost.length;
        
        // 2. 여벌을 가져왔지만, 수업에는 참여 가능하지만 도난을 당했으면 빌려줄 수 없음
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 3. 마지막으로 도난을 당한 학생은 여벌이 남는 학생에게 체육복을 빌리고 수업에 참여한다
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }       
}