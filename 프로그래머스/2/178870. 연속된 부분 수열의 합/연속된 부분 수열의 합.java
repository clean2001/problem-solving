class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0; // 시작 인덱스, 끝 인덱스
        int cur = sequence[0]; // 현재까지의 부분합
        int[] ans = new int[] {0, sequence.length};
        while(left < sequence.length) {
            if(cur < k && right + 1 < sequence.length) {
                cur += sequence[++right];
            } else if(cur == k) {
                int len1 = ans[1] - ans[0];
                int len2 = right - left;
                
                if(len1 > len2) {
                    ans[0] = left;
                    ans[1] = right;
                }
                cur -= sequence[left++];
            } else {
                cur -= sequence[left++];
            }
        }
        
        return ans;
    }
}