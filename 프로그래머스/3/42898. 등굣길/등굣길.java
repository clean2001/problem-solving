class Solution {
    static int D = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n][m];
        boolean[][] p = new boolean[n][m];
        // 웅덩이 표시하기
        for(int[] pd : puddles) {
            p[pd[1]-1][pd[0]-1] = true;
        }
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(p[i][j]) continue;
                
                if(i==0 && j == 0) {
                    map[i][j] = 1L;
                } else if(i == 0) {
                    map[i][j] = map[i][j-1];
                } else if(j == 0) {
                    map[i][j] = map[i-1][j];
                } else {
                    map[i][j] = (map[i-1][j] % D + map[i][j-1] % D) % D;
                }
            }
        }
        return (int)(map[n-1][m-1] % D);
    }
}