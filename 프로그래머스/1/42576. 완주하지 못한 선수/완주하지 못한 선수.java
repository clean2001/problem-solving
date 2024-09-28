import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> c = new HashMap<>();
        for(String name : completion) {
            int count = c.getOrDefault(name, 0);
            
            c.put(name, count+1);
        }
        
        String answer = "";
        
        for(String name : participant) {
            int count = c.getOrDefault(name, 0);
            
            if(count == 0) {
                answer = name;
                break;
            }
            
            c.put(name, count - 1);
        } 
        
        return answer;
    }
}