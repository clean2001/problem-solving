import java.util.*;

class Solution {
    static class Node {
        int x; int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int lan[][] = new int[1001][1001];
    static ArrayList<Set<Integer>> list = new ArrayList<>(); // 각 i 번째 셋에는 그 열을 지나는 석유 공간의 번호가 들어있다. 
    static int[] sizes = new int[250001]; // 석유 면적을 나타냄. 인덱스는 석유공간
    static boolean visited[][] = new boolean[1001][1001];
    
    
    public int solution(int[][] land) {
        
        
        for(int i=0; i<land[0].length; ++i) {
            list.add(new HashSet<Integer>());
        }
        
        for(int i=0; i<land.length; ++i) {
            for(int j=0; j<land[i].length; ++j) {
                lan[i][j] = land[i][j];
            }
        }
        
        int num = 0;
        // BFS 돌리면서 석유공간 찾기
        for(int i=0; i<land.length; ++i) {
            for(int j=0; j<land[i].length; ++j) {
                if(land[i][j] == 0) continue;
                if(visited[i][j]) continue;
                
                int s = bfs(i, j, land.length, land[0].length, num);
                sizes[num] = s;
                num++;
                
            }
        }
        
        int max_val = 0;
        for(int i=0; i<land[0].length; ++i) {
            int val = 0;
            for(int n : list.get(i)) {
                val += sizes[n];
            }
            
            if(max_val < val) max_val = val;
        }
        
        return max_val;
    }
    
    static int bfs(int sx, int sy, int lx, int ly, int num) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = true;
        int result = 0;
        
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.remove();
            
            result++;
            
            list.get(y).add(num); // 추가
            
            for(int i=0; i<4; ++i) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx < 0 || nx >= lx || ny < 0 || ny >= ly) {
                    continue;
                }
                
                if(visited[nx][ny]) continue;
                if(lan[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
                
            }
        }
        
        return result;
    }
}