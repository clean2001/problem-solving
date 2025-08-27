import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 테스트 데이터를 만드는 코드
 */
class Main {
  static int[][] arr;
  static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
  static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      if(w == 0 && h == 0) break;

      arr = new int[h][w];
      for(int i=0; i<h; ++i) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<w; ++j) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int cnt = 0;
      for(int i=0; i<h; ++i) {
        for(int j=0; j<w; ++j) {
          if(arr[i][j] == 1) {
            bfs(i,j, arr, h, w);
            cnt++;
          }
        }
      }
      bw.write(cnt + "\n");
    }
    bw.flush();
  }

  public static void bfs(int y, int x, int[][] arr, int h, int w) {
    arr[y][x] = -1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {y, x});
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      for(int i=0; i<8; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny <0 || ny >= h || nx < 0 || nx >= w) continue;
        if(arr[ny][nx] != 1) continue;
        arr[ny][nx] = -1;
        q.add(new int[]{ny, nx});
      }
    }

    return;
  }
}