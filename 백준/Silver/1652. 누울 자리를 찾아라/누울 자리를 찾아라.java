import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    char[][] map = new char[N][N];
    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<N; ++j) {
        map[i][j] = s.charAt(j);
      }
    }

    boolean prev = false;
    int cnt = 0;
    int ans1 = 0;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(!prev && map[i][j] == '.') cnt++;
        else if(prev && map[i][j] == '.') {
          prev = false;
          cnt++;
        } else if(!prev && map[i][j] == 'X') {
          prev = true;
          if(cnt >= 2) ans1++;
          cnt = 0;
        }
      }

      if(cnt >= 2) ans1++;
      cnt = 0;
      prev = false;
    }

    prev = false;
    cnt = 0;
    int ans2 = 0;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(!prev && map[j][i] == '.') cnt++;
        else if(prev && map[j][i] == '.') {
          prev = false;
          cnt++;
        } else if(!prev && map[j][i] == 'X') {
          prev = true;
          if(cnt >= 2) ans2++;
          cnt = 0;
        }
      }

      if(cnt >= 2) ans2++;
      cnt = 0;
      prev = false;
    }

    bw.write(ans1  + " " + ans2);
    bw.flush();
  }
}