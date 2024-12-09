class Solution {
    private static int ansZero = 0, ansOne = 0;
    public int[] solution(int[][] arr) {
        solve(0, 0, arr.length, arr[0].length, arr);
        
        return new int[] {ansZero, ansOne};
    }
    
    private static void solve(int ix, int iy, int ex, int ey, int[][] arr) {
        int val = arr[ix][iy];
        boolean isOk = true;
        for(int i=ix; i<ex; ++i) {
            for(int j=iy; j<ey; ++j) {
                if(val != arr[i][j]) {
                    isOk = false;
                    break;
                }
            }
        }
        
        if(isOk) {
            if(val == 0) ansZero++;
            else ansOne++;
        } else {
            int len = (ey - iy) / 2;
            solve(ix, iy, ix + len, iy + len, arr);
            solve(ix, iy + len, ix + len, ey, arr);
            solve(ix + len, iy, ex, iy + len, arr);
            solve(ix + len, iy + len, ex, ey, arr);
        }
    }
}