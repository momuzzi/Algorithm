import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
            
            if (set.size() == (nums.length / 2)) {
                break;
            }
            
        }
        
        answer = set.size();
        
        return answer;
    }
}