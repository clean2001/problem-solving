import java.util.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long s = 0, e = (long)times[times.length - 1] * n;
        long ans = (long)(e+1);

        while(s <= e) {
            long mid = (s + e) / 2;
            boolean isOk = can(mid, n, times);
            if(isOk) { // 가능
                ans = mid;
                e = mid-1;
            } else { // 시간을 늘려야한다.
                s = mid+1;
                
            }
        } 
        return ans;
    }
    
    private static boolean can(long t, int n, int[] times) {
        long people = 0;
        for(int time : times) {
            people += (t / (long)time);
        }
        
        return people >= n;
    }
}