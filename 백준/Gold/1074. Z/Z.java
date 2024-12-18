import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  private static int blue = 0, white = 0;
  private static boolean isDone = false;
  private static int r, c;
  private static int cnt = 0;
  private static int[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int length = 1 << N;

    solve(0, 0, length, length);
    System.out.println(cnt);
  }

  private static void solve(int iy, int ix, int ey, int ex) {
    if(isDone) return;

    if(ey - iy == 2) {
      for(int i=iy; i<ey; ++i) {
        for(int j=ix; j<ex; ++j) {
          if(i == r && j == c) {
            isDone = true;
            return;
          }

          cnt++;
        }
      }
    } else {
      int len = (ey - iy) / 2;
      if(r >= iy && r < iy + len && c >= ix && c < ix + len) {
        solve(iy, ix, iy + len, ix + len);
      } else {
        cnt += (len * len);
      }

      if(isDone) return;

      if(r >= iy && r < iy + len && c >= ix+len && c < ex) {
        solve(iy, ix + len, iy + len, ex);
      } else {
        cnt += (len * len);
      }
      if(isDone) return;

      if(r >= iy + len && r < ey && c >= ix && c < ix + len) {
        solve(iy + len, ix, ey, ix + len);

      } else {
        cnt += (len * len);
      }

      if(isDone) return;
      if(r >= iy+len && r < ey && c >= ix+len && c < ex) {
        solve(iy + len, ix + len, ey, ex);
      } else {
        cnt += (len * len);
      }
    }
  }

}