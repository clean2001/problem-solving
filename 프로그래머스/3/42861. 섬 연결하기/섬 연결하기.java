import java.util.*;
class Solution {
    static int parents[];
    static int findParent(int n) {
        if(parents[n] == n) return n;
        
        return (parents[n] = findParent(parents[n]));
    }
    
    static void unionNode(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        
        parents[pa] = pb;
    }
    
    static int ans = 0;
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int i=1; i<n; ++i) parents[i] = i;
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0; i<costs.length; ++i) {
            pq.add(new int[] {costs[i][0], costs[i][1], costs[i][2]});
        }
        
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int pa = findParent(edge[0]);
            int pb = findParent(edge[1]);
            
            if(pa != pb) {
                unionNode(edge[0],  edge[1]);
                ans += edge[2];
            }
        }
    
        return ans;
    }
}