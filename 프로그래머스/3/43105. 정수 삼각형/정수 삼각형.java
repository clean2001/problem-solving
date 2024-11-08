class Solution {
    public int solution(int[][] triangle) {
        for(int i=1; i<triangle.length; ++i) {
            for(int j=0; j<triangle[i].length; ++j) {
                if(j - 1 < 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j >= triangle[i-1].length) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        int ans = -1;
        for(int i=0; i<triangle.length; ++i) {
            // System.out.println(triangle[triangle.length-1][i]);
            ans = Math.max(ans, triangle[triangle.length-1][i]);
        }
        
        return ans;
    }
}