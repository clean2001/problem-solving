import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 처리시간이 짧은 순
        PriorityQueue<int[]> pq  = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        // 들어오는 순서대로 정렬 해주기
        Arrays.sort(jobs, (a, b) -> {
            return a[0] - b[0];
        });
        
        int pointer = 0; // 몇번째를 큐에 넣을 차례인지
        int done = 0;
        int time = 0; // 시간
        int total = 0; // 시간 합계
        while(done < jobs.length) {
            
            // 일을 모두 넣기
            while(pointer < jobs.length && time >= jobs[pointer][0]) {

                pq.add(new int[]{jobs[pointer][0], jobs[pointer][1]});
                pointer++;
            }
            if(!pq.isEmpty()) { // 할일 있음
                int[] cur = pq.poll();
                time += cur[1];
                total += (time - cur[0]);
                done++;
            } else if(pointer < jobs.length && pq.isEmpty()) { // 큐가 비어있음
                    time = jobs[pointer][0];
                }
            }
        
        return (int)((double)total / jobs.length);
            
            
    }
        
}