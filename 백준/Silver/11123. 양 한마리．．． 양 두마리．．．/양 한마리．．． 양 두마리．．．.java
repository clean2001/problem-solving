import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
  static int[][] arr;
  static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
  static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int K = Integer.parseInt(br.readLine());

    while(K -- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      char[][] arr = new char[N][M];
      for(int i=0; i<N; ++i) {
        String s = br.readLine();
        for(int j=0; j<M; ++j) {
          arr[i][j] = s.charAt(j);
        }
      }


      int cnt = 0;
      for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
          if(arr[i][j] == '#') {
            bfs(i, j, arr);
            cnt++;
          }
        }
      }

      bw.write(cnt + "\n");

    }

    bw.flush();

  }

  public static void bfs(int y, int x, char[][] arr) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{y, x});
    arr[y][x] = '-';
    while(!q.isEmpty()) {
      int[] cur  = q.poll();

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[0].length) continue;
        if(arr[ny][nx] != '#') continue;
        arr[ny][nx] = '-';
        q.add(new int[]{ny, nx});
      }
    }
  }

}