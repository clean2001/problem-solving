import java.util.*;

class Solution {
    public static int[][] map;
    public static int[] dy = {1, -1, 0, 0};
    public static int[] dx = {0, 0, 1, -1};
    public static int totalLen = 0, midLen = 0;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        
        // 직사각형 부분을 1로 표시
        for(int[] rec : rectangle) {
            int lx = rec[0]*2, ly = rec[1]*2, hx = rec[2]*2, hy = rec[3]*2;
            for(int i=lx; i<=hx; ++i) {
                for(int j=ly; j<=hy; ++j) {
                    map[i][j] = 1;
                }
            }
        }
        
        // 직사각형 부분 안쪽을 0으로 표시
        for(int[] rec : rectangle) {
            int lx = rec[0]*2, ly = rec[1]*2, hx = rec[2]*2, hy = rec[3]*2;
            for(int i=lx+1; i<hx; ++i) {
                for(int j=ly+1; j<hy; ++j) {
                    map[i][j] = 0;
                }
            }
        }
        

        
        int cx = characterX, cy = characterY;
        dfs(cx*2, cy*2, map, itemX*2, itemY*2);
        
        System.out.println(totalLen + " " + midLen + " " + (totalLen-midLen));

        // 한쪽 방향으로 테두리 길이 세기 => 더 짧은 것 리턴
        return Math.min((totalLen - midLen), midLen) / 2;
        // return totalLen;
    }
    
    private static void dfs(int x, int y, int[][] map, int ix, int iy) {
        if(x == ix && y == iy) midLen = totalLen;
        
        map[x][y] = 2; // 방문
        totalLen++;
        for(int i=0; i<4; ++i) {
            for(int j=0; j<4; ++j) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < 1 || nx > 100 || ny < 1 || ny > 100) continue;
                if(map[nx][ny] != 1) continue;
                dfs(nx, ny, map, ix, iy);
                
            }
        }
    }
}