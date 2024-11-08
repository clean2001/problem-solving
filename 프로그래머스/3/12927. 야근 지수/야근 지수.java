import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i < works.length; ++i) {
            pq.add((long)works[i]);
        }
        
        long ans = 0L;
        for(int i=0; i<n; ++i) {
            long cur = pq.poll();
            if(cur > 0) {
                pq.add(cur-1);
            }
            
            if(pq.isEmpty()) {
                break;
            }
        }
        
        while(!pq.isEmpty()) {
            long a = pq.poll();
            ans += (a * a);
        }
        
        return ans;
    }
}