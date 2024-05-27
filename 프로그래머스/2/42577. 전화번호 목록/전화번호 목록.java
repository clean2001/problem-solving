import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        // 해시 맵 만들기
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<len; ++i) {
            String sub = "";
            for(int j=phone_book[i].length()-1; j>=0; --j) {
                sub = phone_book[i].substring(0, j);
                if(map.get(sub) != null) break;
                map.put(sub, i);
            }
        }
        
        boolean ans = true;
        for(int i=0; i<len; ++i) {
            Integer idx = map.get(phone_book[i]);
            if(idx != null && idx != i) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}