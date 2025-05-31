import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

class Main {
  static int[] vis;
  static int N, M, ans = 0;
  static List<List<Integer>> adj;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Set<String> set = Set.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

    String s = br.readLine();

    int i = 0;
    int ans = 0;
    while(i<s.length()) {
      // 2개 확인
      if(i + 1 < s.length()) {
        String sub = s.substring(i, i+2);

        if(set.contains(sub)) {
          i += 2;
          ans++;
          continue;
        }
      }

      // 3개 확인
      if(i + 2 < s.length()) {
        String sub = s.substring(i, i+3);

        if(set.contains(sub)) {
          i += 3;
          ans++;
          continue;
        }
      }

      i++; ans++;

    }

    System.out.println(ans);
  }
}