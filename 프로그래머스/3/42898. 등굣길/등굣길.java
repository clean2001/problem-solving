class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dist = new int[m+1][n+1];
        dist[1][1] = 1;
        
        for(int i=0; i<puddles.length; ++i) {
            dist[puddles[i][0]][puddles[i][1]] = -1;
        }
        for(int i=1; i<=m; ++i) {
            for(int j=1; j<=n; ++j) {
                if(dist[i][j] == -1) continue;
                
                if(dist[i-1][j] != -1) {
                    dist[i][j] = (dist[i][j] + dist[i-1][j]) % 1000000007;
                }
                
                if(dist[i][j-1] != -1) {
                    dist[i][j] = (dist[i][j] + dist[i][j-1]) % 1000000007;
                }

            }
        }
        
        return (dist[m][n]) % 1000000007;
    }
}