import java.util.*;

class Solution {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private static int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1}); // y, x, dist;
        boolean[][] vis = new boolean[maps.length][maps[0].length];
        vis[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; ++i) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny >= maps.length || nx >= maps[0].length
                   || ny < 0 || nx < 0) continue;
                if(maps[ny][nx] == 0) continue;
                if(vis[ny][nx]) continue;
                
                if(ny == maps.length-1 && nx == maps[0].length-1) {
                    return cur[2] + 1;
                }
                
                vis[ny][nx] = true;
                q.add(new int[] {ny, nx, cur[2] + 1});
            }
        }
        return -1;
    }
    
}