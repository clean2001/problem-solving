import java.util.*;

class Solution {
    public static int[] dy = {1, -1, 0, 0};
    public static int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        return bfs(0, 0, maps);
    }
    
    public static int bfs(int y, int x, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int[][] dist = new int[maps.length][maps[0].length];
        dist[y][x] = 1;
        int maxY = maps.length;
        int maxX = maps[0].length;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; ++i) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if(ny >= maxY || ny < 0 || nx >= maxX || nx < 0) {
                    continue;
                }
                if(dist[ny][nx] > 0) continue;
                if(maps[ny][nx] == 0) continue;
                
                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
                
                if(ny == maxY-1 && nx == maxX-1) return dist[ny][nx];
                
                q.add(new int[]{ny, nx});
            }
        }
        
        return -1;
    }
}