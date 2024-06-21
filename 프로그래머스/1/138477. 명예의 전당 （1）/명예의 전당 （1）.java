import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[score.length];
        int idx = 0;
        for(int n : score) {
            if(pq.size() < k) {
                pq.add(n);
            } else if(pq.peek() < n) {
                pq.poll();
                pq.add(n);
            }
            ans[idx++] = pq.peek();
        }
        
        return ans;
    }
}