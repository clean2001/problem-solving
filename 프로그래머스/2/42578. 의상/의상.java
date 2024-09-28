import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Long> m = new HashMap<>();
        
        for(String[] s : clothes) {
            long count = m.getOrDefault(s[1], 0L);
            m.put(s[1], count+1L);
        }
        
        long answer = 1;
        for(Map.Entry<String, Long> entry : m.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        
        return (int)(answer - 1L);
    }
}