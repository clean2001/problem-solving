import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = k;
        
        while(end < number.length()) {
            int maxVal = number.charAt(start) - '0';
            int maxIdx = start;
            for(int i=start+1; i<=end; ++i) {
                if(maxVal < number.charAt(i) - '0') {
                    maxVal = number.charAt(i) - '0';
                    maxIdx = i;
                }
            }
            sb.append(maxVal);
            start = maxIdx+1;
            end++;
        }
        
        return sb.toString();
    }
}