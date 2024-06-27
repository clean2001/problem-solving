class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0;
        int sum = sequence[start];
        int idx1 = 0, idx2 = sequence.length;
        while(start <= end) {
            if(sum == k) {
                int len1 = idx2 - idx1;
                int len2 = end - start;
                if(len1 > len2) {
                    idx1 = start;
                    idx2 = end;
                }
                
                sum -= sequence[start++];
            } else if(sum < k && end < sequence.length - 1) {
                sum += sequence[++end];
            } else {
                sum -= sequence[start++];
            }
        }
        
        return new int[] {idx1, idx2};
    }
}