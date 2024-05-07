import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    private static int[][] arr;
    private static int N, L;
    private static int ans;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt(); // 재료 개수
            L = sc.nextInt(); // 제한 칼로리
            ans = 0;
             
            arr = new int[N][2]; // 0 -> 재료 점수, 1 -> 칼로리 수
             
            for(int i=0; i<N; ++i) {
                arr[i][0] = sc.nextInt(); arr[i][1] = sc.nextInt();
            }
             
            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + ans);
        }
       
    }
     
    private static void dfs(int depth, int calSum, int tasteSum) {
        if(calSum <= L)  {
            ans = Math.max(tasteSum, ans);
        }
 
        if(calSum > L) return;
         
        for(int i=depth; i<N; ++i) {
            dfs(i+1, calSum + arr[i][1], tasteSum + arr[i][0]);
        }
    }
}