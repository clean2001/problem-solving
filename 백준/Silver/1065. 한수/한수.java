import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] map;
  static int ans = -1;

  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    int ans = 0;
    for(int i=1; i<=N; ++i) {
      String s = String.valueOf(i);

      if(s.length() <= 2) {
        ans++;
        continue;
      }

      // 등차 수열인지 체크
      String[] arr = s.split("");
      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      int c = Integer.parseInt(arr[2]);

      if(b - a == c - b) {
        ans++;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}