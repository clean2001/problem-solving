import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length-1;
        int ans = 0;
        while(left <= right) {
            if(left == right) {
                ans++; break;
            }
            
            if(people[left] + people[right] <= limit) {
                ans++; left++; right--;
            } else {
                ans++; right--;
            }
        }
        
        return ans;
    }
}