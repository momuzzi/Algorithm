import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        int[] answer = new int[set.size()];
        
        int index = 0;
        for (int n : set) {
            answer[index] = n;
            index++;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}