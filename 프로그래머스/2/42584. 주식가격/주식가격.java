import java.util.*;

class Solution {
    static class Num {
        int idx;
        int val;
        
        Num(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Num> dq = new LinkedList<>();
        int len = prices.length;
        for(int i=0; i<len; ++i) {
            if(dq.isEmpty() || dq.peekFirst().val <= prices[i]) {
                dq.addFirst(new Num(i, prices[i]));
                continue;
            }
            
            while(!dq.isEmpty() && dq.peekFirst().val > prices[i]) {
                Num cur = dq.pollFirst();
                ans[cur.idx] = i - cur.idx;
            }
            dq.addFirst(new Num(i, prices[i]));
        }
        
        while(!dq.isEmpty()) {
            Num cur = dq.pollFirst();
            ans[cur.idx] = len - cur.idx - 1;
        }
        
        return ans;
    }
}