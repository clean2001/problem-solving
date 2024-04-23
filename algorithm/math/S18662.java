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
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
             
            int diff = Math.abs(a + c - 2 * b);
             
            double ans = (double)diff/2.0;
             
            System.out.printf("#" + test_case + " %.1f\n", ans);
        }
    }
}