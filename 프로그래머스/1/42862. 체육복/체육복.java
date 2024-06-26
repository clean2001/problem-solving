import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        
        for(int r : reserve) {
            cnt[r-1]++;
        }
        for(int l : lost) {
            cnt[l-1]--;
        }
        
        
        for(int i=0; i<n; ++i) {
            if(i > 0 && cnt[i] == 0 && cnt[i-1] == 2) {
                cnt[i-1]--; cnt[i]++;
            } else if(i<n-1 && cnt[i] == 0 && cnt[i+1] == 2) {
                cnt[i+1]--; cnt[i]++;
            }
        }
        
        return (int)Arrays.stream(cnt).filter(a -> a >= 1).count();
    }
}