import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int maxLen = (int) Math.sqrt(total);
        
        int ans1 = 0, ans2 = 0;
        for(int i=3; i<=maxLen; ++i) {
            System.out.println(i);
            if(total % i > 0) continue;
            
            int len1 = i, len2 = total / i;
            
            
            if(yellow == (len2-2) * (len1- 2)) {
                ans1 = len1; ans2 = len2;
                break;
            }
        }
        
        int[] ans = {ans2, ans1};
        return ans;
    }
}