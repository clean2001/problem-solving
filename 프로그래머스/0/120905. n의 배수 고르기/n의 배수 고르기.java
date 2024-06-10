import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> ans = new ArrayList<>();
        for(int num : numlist) {
            if(num % n == 0) ans.add(num);
        }
        
        int[] answer = new int[ans.size()];
        int idx = 0;
        for(int a : ans) answer[idx++] = a;
        return answer;
    }
}