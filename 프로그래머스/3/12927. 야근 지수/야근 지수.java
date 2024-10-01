import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        for(int w : works) {
            pq.add(w);
        }
        
        for(int i=0; i<n; ++i) {
            if(pq.isEmpty()) break;
            int k = pq.poll();
            if(k > 1) {
                pq.add(--k);
            }
        }
        
        long ans = 0;
        while(!pq.isEmpty()) {
            int k = pq.poll();
            ans += k*k;
        }
        
        return ans;
    }
}