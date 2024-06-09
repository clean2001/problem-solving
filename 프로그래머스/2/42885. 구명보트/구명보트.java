import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int left = 0, right = len - 1;
        int cnt = 0;
        while(left <= right) {
            int lw = people[left], rw = people[right];
            
            if(left == right) rw = 0;
            if(lw + rw <= limit) {
                left++; right--;
                cnt++;
            } else {
                right--;
                cnt++;
            }
        }
        
        return cnt;
    }
}