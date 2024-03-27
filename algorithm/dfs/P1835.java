import java.util.*;

class Solution {
    static int N = 8;
    static int cnt = 0;
    static Map<Character, Integer> map;
    static boolean[] vis;
    static String[] cons;
    public int solution(int n, String[] data) {
        cnt = 0;
        
        cons = data;

        map = new HashMap<>();
        vis = new boolean[8];
        for(int i=0; i<8; ++i) vis[i] = false;
    
        char[] mems = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        
        int idx = 0;
        for(char c : mems) {
            map.put(c, idx);
            idx++;
        }
    
        
        
        dfs(0, new ArrayList<Integer>());
        return cnt;
    }
    
    static void dfs(int depth, ArrayList<Integer> complete) {

        if(complete.size() == 8) {
            if(!is_ok(complete)) return;
            cnt++;
            return;
        } else if(depth == 8) return;
        
        for(int i=0; i<8; ++i) {
            if(vis[i]) continue;
            
            // 놓기
            
            vis[i] = true;
            complete.add(i);
            dfs(depth+1, complete);
            vis[i] = false;
            complete.remove(complete.size()-1);
        }  
    }
    
    static boolean is_ok(ArrayList<Integer> complete) {
        for(String con : cons) {
            char p1 = con.charAt(0);
            char p2 = con.charAt(2);
            char how = con.charAt(3);
            int dist = con.charAt(4) - '0';
            
            int idx1 = map.get(p1);
            int idx2 = map.get(p2);
            
            int diff = Math.abs(complete.indexOf(idx1) - complete.indexOf(idx2)) - 1; // 사이에 몇명?
            
            int w1 = complete.indexOf(idx1);
            
            if(how == '=') {
                if(diff != dist) return false;
            } else if(how == '>') { // 거리가 더 커야함
                if(diff <= dist) return false;
            } else {
                if(diff >= dist) return false;
            }
        
        }
        
        return true;
    }
}