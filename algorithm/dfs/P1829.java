import java.util.*;

class P1829 {
    static int area = 0;
    static int num_of_area = 0;
    static int cur_num = 0;
    static boolean[][] visited;
    static int N = 0, M = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        M = m;
        N = n;
        area = 0;
        num_of_area = 0;
        cur_num = 0;

        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                visited[i][j] = false;
            }
        }
        
        int[] answer = new int[2];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(visited[i][j]) continue;
                if(picture[i][j] == 0) continue;
                visited[i][j] = true;
                cur_num = 0;
                num_of_area++;
                dfs(i, j, picture);
                area = Math.max(cur_num, area);
            }
        }
        answer[0] = num_of_area;
        answer[1] = area;
        return answer;
    }
    
    
    static void dfs(int y, int x, int[][] picture) {
        cur_num++;
        for(int i=0; i<4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0||ny>=M||nx<0||nx>=N) continue;
            if(visited[ny][nx]) continue;
            if(picture[ny][nx] != picture[y][x]) continue; 
            
            visited[ny][nx] = true;
            dfs(ny, nx, picture);
        }
        
    }
}