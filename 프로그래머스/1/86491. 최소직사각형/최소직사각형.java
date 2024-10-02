class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0; // 이곳에 큰 것을 넣을 것임
        int maxY = 0;
        for(int[] s : sizes) {
            if(s[0] > s[1]) {
                maxX = Math.max(maxX, s[0]);
                maxY = Math.max(maxY, s[1]);
            } else {
                maxX = Math.max(maxX, s[1]);
                maxY = Math.max(maxY, s[0]);
            }
        }
        
        return maxX * maxY;
    }
}