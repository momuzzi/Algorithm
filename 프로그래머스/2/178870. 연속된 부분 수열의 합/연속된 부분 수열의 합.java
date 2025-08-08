class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int[] sum = new int[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) {
            sum[i + 1] = sum[i] + sequence[i];
        }
        
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        while (left <= right && right < sum.length) {
            if (sum[right] - sum[left] == k) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                left++;
            } else if (sum[right] - sum[left] > k) {
                left++;
            } else {
                right++;
            }
        }
        
        return answer;
    }
}