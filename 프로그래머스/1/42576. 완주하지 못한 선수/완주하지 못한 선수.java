import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completedMap = new HashMap<>();
        
        // 완주한 선수의 이름과 그 수를 저장(선수 이름 중복 고려)
        for(String c : completion) {
            completedMap.put(c, completedMap.getOrDefault(c, 0) + 1);
        }
        
        String ans = "";
        for(String p : participant) {
            Integer cnt = completedMap.get(p);
            if(cnt == null || cnt == 0) {
                ans = p; break;
            } else {
                completedMap.put(p, cnt-1);
            }
        }
        return ans;
    }
}