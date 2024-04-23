import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<3; ++i) {
                int a = sc.nextInt();
                list.add(a);
                 
            }
             
            int prev = list.get(2);
            int ans = 0;
            for(int i=1; i>=0; i--) {
                if(list.get(i) < prev) {
                    prev = list.get(i);
                    continue;
                }
                int cur = list.get(i);
                ans += (cur - prev + 1);
                if(prev - 1 <= 0) {
                    ans = -1; break;
                }
                 
                prev = prev-1;
            }
             
            System.out.println("#" + test_case + " " + ans);
                 
        }
    }
}