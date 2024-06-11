import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int p : nums) {
            set.add(p);
        }
        
        return Math.min(nums.length/2, set.size());
    }
}