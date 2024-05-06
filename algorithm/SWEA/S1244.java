import java.util.*;
import java.io.*;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
  static int ans = 0;
  static int maxCnt = 0;
  static String[] nums;
  public static void main(String args[]) throws Exception
  {

    Scanner sc = new Scanner(System.in);
    int T;
    T=sc.nextInt();


    for(int test_case = 1; test_case <= T; test_case++)
    {
      String s = sc.next();
      nums = s.split("");
      int len = nums.length;
      maxCnt = sc.nextInt();

      ans = 0;
      maxCnt = Math.min(len, maxCnt);
      dfs(0, 0, len);

      System.out.println("#" + test_case + " " + ans);
    }
  }

  private static void dfs(int depth, int cnt, int len) {
    if(cnt == maxCnt) {
        String str = "";
      for(int i=0; i<len; ++i) {
          str += nums[i];
      }
      int calculatedNum = Integer.parseInt(str);
      ans = Math.max(calculatedNum, ans);
      return;
    }


    for(int i=depth; i<len; ++i) {
      for(int j=i+1; j<len; ++j) {

        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        dfs(i, cnt+1, len);

        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
  }

}