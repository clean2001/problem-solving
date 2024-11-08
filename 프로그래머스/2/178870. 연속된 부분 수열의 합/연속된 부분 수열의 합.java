class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];
        int ansL = 0, ansR = sequence.length;
        while(left <= right && left < sequence.length) {
            
            if(sum == k) {
                // System.out.println(left + " " + right + " " + sum);
                if(right - left < ansR - ansL) {
                    ansR = right;
                    ansL = left;
                } 
                
                sum -= sequence[left++];
            } else if(sum < k) {
                if(right+1 >= sequence.length) break;
                sum += sequence[++right];
            } else {
                sum -= sequence[left++];
            }
        }
        
        int[] ans = new int[2];
        int idx = 0;
        ans[0] = ansL;
        ans[1] = ansR;
        
        return ans;
    }
}