import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int startIndex = 0;
        List<Integer> list = new ArrayList<>();
        while(startIndex < progresses.length) {
            int cnt = 0;
            for(int i=startIndex; i<progresses.length; ++i) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100 && startIndex == i) {
                    startIndex++;
                    cnt++;
                }
            }
            if(cnt > 0)
                list.add(cnt);
        }
        
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); ++i) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}