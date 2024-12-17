import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  private static int blue = 0, white = 0;
  private static int[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solve(0, 0, N, N);

    System.out.println(white);
    System.out.println(blue);

  }

  private static void solve(int sy, int sx, int ey, int ex) {
    int color = arr[sy][sx];
    int len = (ey - sy) / 2;
    boolean isOk = true;
    for(int i=sy; i<ey; i++) {
      for(int j=sx; j<ex; j++) {
        if(color != arr[i][j]) {
          isOk = false;
          break;
        }
      }
    }

    if(isOk) {
      if(color == 1) blue++;
      else white++;
    } else {
      solve(sy, sx, sy + len, sx + len);
      solve(sy + len, sx, ey, sx + len);
      solve(sy, sx + len, sy + len, ex);
      solve(sy + len, sx + len, ey, ex);
    }
  }
}