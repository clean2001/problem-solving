import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int a : works) {
            pq.add(a);
        }
        
        for(int i=0; i<n; ++i) {
            if(pq.isEmpty()) return 0;
            int maxVal = pq.poll();
            if(maxVal - 1 > 0) {
                pq.add(maxVal-1);
            }  
        }
        
        long ans = 0;
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            ans += (long)cur*cur;
        }
        
        return ans;
    }
}