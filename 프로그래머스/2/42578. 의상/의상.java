import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> countMap = new HashMap<>();
        
        for(int i=0; i<clothes.length; ++i) {
            String clothType = clothes[i][1];
            countMap.put(clothType, countMap.getOrDefault(clothType, 0) + 1);
        }
        
        int result = 1;
        for(int cnt : countMap.values()) {
            result *= (cnt + 1);
        }
        
        return result - 1;
        
    }
}