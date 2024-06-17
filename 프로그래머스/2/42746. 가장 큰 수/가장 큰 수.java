import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 34 32 30 3
        // 34 3 32 30
        String[] sArr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; ++i) {
            sArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(sArr, (a, b) -> (b+a).compareTo(a+b));
        

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sArr.length; ++i) {
            if(sb.length() == 0 && sArr[i].equals("0")) continue;
            sb.append(sArr[i]);
        }

        if(sb.length() == 0) sb.append("0");
        return sb.toString();
            
    }
}