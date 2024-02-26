// 백준 1912 연속합
import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] dp; // 1~i번째까지 합을 나타낸 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; ++i) {
            dp[i] = dp[i-1] + arr[i];
        }

        int minval = 0;
        int ans = arr[1];
        for(int i=1; i<=n; ++i) {
            if(ans < dp[i] - minval) {
                ans = dp[i] - minval;
            }

            if(dp[i] < minval) minval = dp[i];
        }

        System.out.println(ans);
    }
}