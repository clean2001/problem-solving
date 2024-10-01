import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청이 들어온 시간을 기준으로 정렬 (요청 들어온 시간이 같다면 처리가 더 짧은 것)
        Arrays.sort(jobs, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1]; 
            }
            
            return a[0] - b[0];
        });
        
        // 2. pq를 선언(짧은거 우선 정렬)하고, 시작시간 세팅
        int cur = 0; // 현재 시간
        int total = 0; // 누적 처리 시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return  a[1] - b[1];
        });
        int idx = 0;
        int cnt = 0;
        while(cnt < jobs.length) {
            if(pq.isEmpty()) {
                if(idx < jobs.length) {
                    cur += (jobs[idx][0] - cur); // 시간 맞추기
                    pq.add(jobs[idx]);
                    idx++;
                }
            } else { // 큐가 안비어져있음
                cnt++;
                int[] job = pq.poll();
                cur += job[1];
                total = total + cur + - job[0];
                
                // 큐에 일 모두 넣기
                while(idx < jobs.length && jobs[idx][0] <= cur) {
                    pq.add(jobs[idx++]);
                }
            }
        }
        
        return total / jobs.length;

    }
}