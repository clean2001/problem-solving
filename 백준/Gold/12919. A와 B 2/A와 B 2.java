import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
  private static String S;
  private static int ans = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    S = br.readLine();
    String T = br.readLine();

    dfs(new StringBuilder(T));

    System.out.println(ans);
  }

  private static void dfs(StringBuilder sb) {
    if(sb.toString().equals(S)) {
      ans = 1;
      return;
    }

    if(sb.length() == 0) return;

    if(sb.charAt(sb.length() - 1) == 'A') {
      StringBuilder sb1 = new StringBuilder(sb).deleteCharAt(sb.length() - 1);
      dfs(sb1);
    }

    if(ans == 1) return;

    if(sb.charAt(0) == 'B') {
      StringBuilder sb2 = new StringBuilder(sb).deleteCharAt(0).reverse();
      dfs(sb2);
    }

  }
}