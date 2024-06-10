import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] sum = new int[numbers.length * numbers.length];
        boolean[] chk = new boolean[201];
        // 2개 뽑아서 더하기
        for(int i=0; i<numbers.length; ++i) {
            for(int j=i+1; j<numbers.length; ++j) {
                int s = numbers[i] + numbers[j];
                chk[s] = true;
            }
        }
        int idx = 0;
        int[] tempArr = new int[201];
        for(int i=0; i<=200; ++i) {
            if(chk[i]) {
                tempArr[idx++] = i;
            }
        }
        
        return Arrays.copyOf(tempArr, idx);
    }
}