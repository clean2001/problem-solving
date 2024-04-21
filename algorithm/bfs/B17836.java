import java.io.*;
import java.util.*;

class Main {
  static int N, M, T;
  static int[][] map;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static class Node {
    int y, x;
    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[N+1][M+1];

    for(int i=1; i<=N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());

      }
    }

    int ans = bfs();
    System.out.println(ans > T ? "Fail" : ans);
  }

  static int bfs() {
    int[][] dist  = new int[N+1][M+1];
    dist[1][1] = 1;
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1, 1));
    int pDist = Integer.MAX_VALUE;
    int gDist = Integer.MAX_VALUE;
    while(!q.isEmpty()) {
      Node cur = q.poll();

      if(cur.y == N && cur.x == M) pDist = dist[cur.y][cur.x] - 1; // 공주를 찾음

      // 칼을 찾음
      if(map[cur.y][cur.x] == 2) {
        gDist = dist[cur.y][cur.x] - 1 + (N-cur.y) + (M-cur.x);
      }

      for(int i=0; i<4; ++i) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if(!isSafe(ny, nx)) continue;
        if(map[ny][nx] == 1) continue;
        if(dist[ny][nx] > 0) continue;

        dist[ny][nx] = dist[cur.y][cur.x] + 1;
        q.add(new Node(ny, nx));
      }
    }

    return Math.min(pDist, gDist);
  }

  static boolean isSafe(int y, int x) {
    return y>=1 && y<=N && x>=1 && x<=M;
  }
}