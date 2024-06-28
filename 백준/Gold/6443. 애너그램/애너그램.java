import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    while(N-- > 0) {
      String input = br.readLine();
      char[] ch = new char[input.length()];
      int[] cnt = new int[26]; // a~z
      for(int i=0; i<input.length(); ++i) { // 개수 세기
        cnt[input.charAt(i) - 'a']++;
      }

      dfs(0, new char[ch.length], cnt);
    }

    bw.flush();
  }

  private static void dfs(int depth, char[] result, int[] cnt) throws Exception {
    if(depth == result.length) {
      for(int i=0; i<result.length; ++i) {
        bw.write(result[i]);
      }

      bw.write("\n");
      return;
    }

    for(int i=0; i<26; ++i) {
      if(cnt[i] == 0) continue;
      result[depth] = (char)(i + 'a');
      cnt[i]--;
      dfs(depth+1, result, cnt);
      cnt[i]++;
    }
  }
}