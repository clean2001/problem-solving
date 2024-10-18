import java.util.*;

class Solution {
    public static int ans = 0;
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            int cnt = map.getOrDefault(t, 0);
            map.put(t, cnt+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }
        
        int ans = 0;
        while(!pq.isEmpty() && k > 0) {
            ans++;
            int[] cur = pq.poll();
            k -= cur[1];
        }
        
        return ans;
    }
    

}