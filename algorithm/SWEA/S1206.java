import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
// 1206. view
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; ++i) {
                arr[i] = sc.nextInt();
            }
             
            int cnt = 0;
            for(int i=2; i<N-2; ++i) {
                int left1 = arr[i-1], left2 = arr[i-2];
                int right1 = arr[i+1], right2 = arr[i+2];
                 
                int maxHeight = Math.max(left1, Math.max(left2, Math.max(right1, right2)));
                 
                if(maxHeight < arr[i]) cnt += (arr[i] - maxHeight);
                 
            }
             
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}