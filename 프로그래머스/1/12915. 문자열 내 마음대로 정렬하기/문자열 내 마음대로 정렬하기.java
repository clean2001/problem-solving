import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 앞에 붙이는 작업
        for(int i=0; i<strings.length; ++i) {
            String s = strings[i];
            String targetString = Character.toString(s.charAt(n));
            strings[i] = targetString + s;
        }
        
        Arrays.sort(strings);
        
        for(int i=0; i<strings.length; ++i) {
            strings[i] = strings[i].substring(1, strings[i].length());
        }
        
        return strings;
    }
}