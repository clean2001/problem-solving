import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.add(s);
        }
        
        int cnt = 0;
        
        while(pq.size() > 1) {
            int first = pq.poll(), second = pq.poll();
            // System.out.println(first + " " + second);
            if(first >= K) {
                pq.add(first); pq.add(second);
                break;
            }
            
            int newSc = first + second * 2;
            pq.add(newSc);
            cnt++;
        }
        
        if(pq.poll() < K) return -1;
        
        return cnt;
    }
}