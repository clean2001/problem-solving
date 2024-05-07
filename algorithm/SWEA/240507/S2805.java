import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
             
            for(int i=0; i<N; ++i) {
                String s = sc.next();
                for(int j=0; j<N; ++j) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
             
            int ans = 0;
            for(int i=0; i<N; ++i) {
                int padding = Math.abs(N / 2 - i);
                for(int j = padding; j < N - padding; ++j) {
                    ans += arr[i][j];
                }
            }
             
            System.out.println("#" + test_case + " " + ans);
        }
    }
}