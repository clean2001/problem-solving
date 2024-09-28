import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokemon = new HashSet<>();
        for(int a : nums) {
            pokemon.add(a);
        }
        
        return Math.min(pokemon.size(), nums.length/2);
    }
}