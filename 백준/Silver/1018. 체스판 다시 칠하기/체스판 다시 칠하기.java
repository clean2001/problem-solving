import java.io.*;
import java.util.*;
import javax.lang.model.type.ArrayType;

class Main {
  static int N, M;
  static char[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<M; ++j) {
        map[i][j] = s.charAt(j);
      }
    }

    int ans = 64;
    for(int sy = 0; sy <= N-8; ++sy) {
      for(int sx = 0; sx <= M-8; ++sx) {
        int cnt1 = countChanges(sy, sx, 'W'); // W로 시작
        int cnt2 = countChanges(sy, sx, 'B'); // B로 시작

        ans = Math.min(ans, Math.min(cnt1, cnt2));
      }
    }

    System.out.println(ans);
  }

  static int countChanges(int sy, int sx, char color1) {
    char color2;
    if(color1 == 'W') {
      color2 = 'B';
    } else {
      color2 = 'W';
    }
    int ret = 0;
    for(int i = 0; i < 8; ++i) {
      for(int j = 0; j < 8; ++j) {
        if(i % 2 == j % 2) { // color1
          if(map[i+sy][j+sx] != color1) ret++;
        } else { // color2
          if(map[i+sy][j+sx] != color2) ret++;
        }
      }
    }
    return ret;
  }
}