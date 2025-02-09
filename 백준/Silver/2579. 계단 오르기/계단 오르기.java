import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[N+1][2];
    int[] score = new int[N+1];

    for(int i=1; i<=N; ++i) {
      score[i] = Integer.parseInt(br.readLine());
    }

    dp[1][0] = score[1];
    dp[1][1] = score[1];
    for(int i=2; i<=N; ++i) {
      dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + score[i];
      dp[i][1] = dp[i-1][0] + score[i];
    }

    System.out.println(Math.max(dp[N][0], dp[N][1]));

    bw.flush();
  }

}