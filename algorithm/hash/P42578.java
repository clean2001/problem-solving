import java.util.*;
// 의상
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int len = clothes.length;
        for(int i=0; i<len; ++i) {
            Integer num = map.get(clothes[i][1]);
            if(num == null) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], num+1);
            }
        }
        
        int ans = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            ans *= (entry.getValue() + 1);
        }
        
        return ans - 1;
    }
}