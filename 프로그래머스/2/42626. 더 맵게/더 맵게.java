import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }
        
        int cnt = 0;
        while(pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            cnt++;
        }
        
        if(pq.peek() < K) return -1;
        
        return cnt;
    }
}