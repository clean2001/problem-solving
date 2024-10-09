import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
  public static int[] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    if(s.charAt(0) == '0') {
      System.out.println(0);
      System.exit(0);
    }

    s = "0" + s;

    if(s.length() <= 2) {
      if(s.charAt(1) == '0') {
        System.out.println(0);
      } else {
        System.out.println(1);
      }

      System.exit(0);

    } else {
      dp = new int[s.length()+1];
      dp[0] = 1;
      dp[1] = 1; // 맨 앞 문자로 만들 수 있는 뜻은 1가지이다.
      for (int i = 2; i < s.length(); ++i) {
        int cur = s.charAt(i) - '0';
        int prev = s.charAt(i-1) - '0';

        int total = prev * 10 + cur;

        if(prev != 0 && cur != 0 && total <= 26) {
          dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
        } else if(prev != 0 && total <= 26) {
          dp[i] = dp[i-2] % 1000000;
        } else if(cur != 0) {
          dp[i] = dp[i-1] % 1000000;
        } else {
          System.out.println(0);
          System.exit(0);
        }
      }

      System.out.println(dp[s.length()-1]);
    }
  }
}