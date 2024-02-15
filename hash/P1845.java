// 프로그래머스 1845 폰켓몬
// 원래 HashSet<Integer>를 선언하고 모든 폰켓몬을 넣어서 중복된 원소를 제거 -> HashSet의 사이즈 == 종류
// 종류와 N/2 중 작은걸 출력하는 문제이다.
import java.util.*;

class P1845 {
    static int[] cnt;
    public int solution(int[] nums) {
        int answer = 0;

        cnt = new int[200001];
        int c = 0;
        for(int i=0; i<nums.length; ++i) {
            int pokemon = nums[i];
            if(cnt[pokemon] == 0) {
                c++;
            }

            cnt[pokemon]++;
        }


        return Math.min(c, (nums.length/2));
    }
}
