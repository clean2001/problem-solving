import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; ++i) {
            pq.add(priorities[i]);
            q.add(i);
        }
        
        int turn = 0;
        while(!pq.isEmpty()) {
            if(pq.peek() == priorities[q.peek()]) {
                int cur = q.poll();
                pq.poll();
                turn++;
                if(cur == location) {
                    return turn;
                }
            } else {
                int cur = q.poll();
                q.add(cur);
            }
        }
        
        return 0;

    }
}