import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int[][] map;
  static int[] dy = {1, -1, 0, 0,};
  static int[] dx = {0, 0, -1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for(int i=0; i<N; ++i) {
      String line = br.readLine();
      for(int j=0; j<M; ++j) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs());
  }
  static int bfs() {
    int[][] dist = new int[N][M];
    dist[0][0] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0});
    while(!q.isEmpty()) {
      int[] cur = q.poll();

//      System.out.println(cur[0] + " " + cur[1]);
      if(cur[0] == N-1 && cur[1] == M-1) return dist[N-1][M-1];

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
        if(dist[ny][nx] > 0) continue;
        if(map[ny][nx] == 0) continue;

        q.add(new int[] {ny, nx});
        dist[ny][nx] = dist[cur[0]][cur[1]] + 1;

      }
    }

    return -1;
  }
}