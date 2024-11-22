import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = " " + br.readLine();
    String b = " " + br.readLine();
    String c = " " + br.readLine();

    int[][][] dp = new int[a.length()][b.length()][c.length()];

    for(int i=1; i<a.length(); ++i) {
      for (int j = 1; j < b.length(); ++j) {
        for (int k = 1; k < c.length(); ++k) {
          if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
            dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
          } else { // 다르다면?
            dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
          }
        }
      }
    }

    System.out.println(dp[a.length()-1][b.length()-1][c.length()-1]);
  }
}