import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int left = 0, right = people.length - 1;
        
        // 정렬하기
        Arrays.sort(people);
        
        while(left <= right) {
            if(left == right) {
                answer++;
                break;
            }
            
            int w1 = people[left];
            int w2 = people[right];
            
            if(w1 + w2 > limit) {
                answer++;
                right--;
            } else {
                answer++;
                right--;
                left++;
            }
        }
        
        return answer;
    }
}