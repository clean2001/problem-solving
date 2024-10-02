import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] a1 = new int[] {1, 2, 3, 4, 5};
        int[] a2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0, cnt2 =0, cnt3 = 0;
        for(int i=0; i<answers.length; ++i) {
            int answer = answers[i];
            if(a1[i % a1.length] == answer) {
                cnt1++;
            }
            
            if(a2[i % a2.length] == answer) {
                cnt2++;
            }
            
            if(a3[i % a3.length] == answer) {
                cnt3++;
            }
        }
        
        int maxVal = Math.max(cnt1, Math.max(cnt2, cnt3));
        ArrayList<Integer> list = new ArrayList<>();
        if(cnt1 == maxVal) list.add(1);
        if(cnt2 == maxVal) list.add(2);
        if(cnt3 == maxVal) list.add(3);
        
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); ++i) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}