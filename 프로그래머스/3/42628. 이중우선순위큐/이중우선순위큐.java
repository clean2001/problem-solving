import java.util.*;

class Solution {
    public static class Num {
        int n;
        boolean live;
        
        Num(int n, boolean live) {
            this.n = n;
            this.live = live;
        }
        
        @Override
        public String toString() {
            return n + " " + live;
        }
    }
    public int[] solution(String[] operations) {
        Queue<Num> maxq = new PriorityQueue<>((a, b) -> b.n - a.n);
        Queue<Num> minq = new PriorityQueue<>((a, b) -> a.n - b.n);
        
        for(String s : operations) {
            String[] ops = s.split(" ");
            if(ops[0].equals("I")) {
                int num = Integer.parseInt(ops[1]);
                Num numObj = new Num(num, true);
                maxq.add(numObj);
                minq.add(numObj);
            } else if(ops[1].equals("-1")) { // 최소 삭제
                while(!minq.isEmpty() && minq.peek().live == false) minq.poll();
                
                if(!minq.isEmpty()) {
                    minq.poll().live = false;
                }
            } else if(ops[1].equals("1")) { // 최대 삭제
                while(!maxq.isEmpty() && maxq.peek().live == false) maxq.poll();
                
                if(!maxq.isEmpty()) {
                    maxq.poll().live = false;
                }
            }
            
            
        }
        

        
        int[] ans = new int[2];
        ans[0] = 0; ans[1] = 0;
        while(!minq.isEmpty() && minq.peek().live == false) {
            minq.poll();
        }
        
        if(!minq.isEmpty()) {
            ans[1] = minq.peek().n;
        }
        
        while(!maxq.isEmpty() && maxq.peek().live == false) {
            maxq.poll();
        }
        
        if(!maxq.isEmpty()) {
            ans[0] = maxq.peek().n;
        }
        
        return ans;
    }
}