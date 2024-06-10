import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        int[] answer = new int[T];
        for(int t = 0; t < T; ++t) {
            
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            int[] subArr = new int[j-i+1];
            
            // 배열 옮기기
            for(int cur = i-1, idx = 0; cur < j; ++cur, ++idx) {
                subArr[idx] = array[cur];
            }

            // 정렬하기
            Arrays.sort(subArr);
            answer[t] = subArr[k-1];
            
        }

        
        return answer;
        
    }
}