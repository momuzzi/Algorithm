import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.need != b.need) {
                return Integer.compare(a.need, b.need);
            } else {
                if (a.request != b.request) {
                    return Integer.compare(a.request, b.request);
                } else {
                    return Integer.compare(a.num, b.num);
                }
            }
        });
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int returnSum = 0;
        int time = 0;
        int cnt = 0;
        int idx = 0;
        while (cnt < jobs.length) {
            for (int i = idx; i < jobs.length; i++) {
                if (jobs[i][0] <= time) {
                    pq.offer(new Job(i, jobs[i][0], jobs[i][1]));
                    idx++;
                } else {
                    break;
                }
            }
            
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.need;
                returnSum += time - job.request;
                cnt++;
            } else {
                time++;
            }
        }
        
        answer = returnSum / jobs.length;
        
        return answer;
    }
    
    static class Job {
        int num;
        int request;
        int need;
        
        Job(int num, int request, int need) {
            this.num = num;
            this.request = request;
            this.need = need;
        }
    }
}