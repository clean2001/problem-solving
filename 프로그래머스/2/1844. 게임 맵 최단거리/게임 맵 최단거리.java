import java.util.*;

class Solution {
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[maps.length][maps[0].length];
        
        vis[0][0] = 1;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; ++i) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny >= maps.length || ny < 0 || nx >= maps[0].length || nx < 0) {
                    continue;
                }
                if(maps[ny][nx] == 0 || vis[ny][nx] != 0) continue;
                
                
                vis[ny][nx] = vis[cur[0]][cur[1]] + 1;
                q.add(new int[]{ny, nx});
                
                if(ny == maps.length-1 && nx == maps[0].length-1) return vis[ny][nx];
            }
        }
        
        return -1;
    }
}