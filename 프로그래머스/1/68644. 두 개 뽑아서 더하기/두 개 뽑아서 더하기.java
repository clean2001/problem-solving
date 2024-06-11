import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length; ++i) {
            for(int j=i+1; j<numbers.length; ++j) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
//         int[] ans = new int[set.size()];
        
//         int idx = 0;
//         for(int n : set.entrySet()) {
//             ans[idx++] = n;
//         }
        
        
        return set.stream().mapToInt(a -> a).toArray();
    }
}