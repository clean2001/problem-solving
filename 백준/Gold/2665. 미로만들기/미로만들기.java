import java.io.*;
import java.util.*;

class Main {
  static int N, K;
  static int[][] map;
  static int[][] dp;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static class Node implements Comparable<Node> {
    int y, x, c;
    Node(int y, int x, int c) {
      this.y = y;
      this.x = x;
      this.c = c;
    }

    @Override
    public int compareTo(Node n) {
      return this.c - n.c;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
//    K = N * N;
    map = new int[N][N];
    dp = new int[N][N];

    for(int i=0; i<N; ++i) {
      String[] line = br.readLine().split("");
      for(int j=0; j<N; ++j) {
        map[i][j] = Integer.parseInt(line[j]);
      }
    }



    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    System.out.println(bfs());
    
  }
  private static int bfs() {
    PriorityQueue<Node> q = new PriorityQueue<>();
    q.add(new Node(0, 0, 0));
    dp[0][0] = 0;
    int ans = Integer.MAX_VALUE;

    while(!q.isEmpty()) {
      Node cur = q.poll();

      if(cur.y == N-1 && cur.x == N-1) {
        ans = Math.min(cur.c, ans);
      }

      for(int i=0; i<4; ++i) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];
        if(ny < 0 || nx < 0 || nx >= N || ny >= N) continue;

        if(map[ny][nx] == 0) { // 검은색
          if(dp[ny][nx] > cur.c + 1) {
            dp[ny][nx] = cur.c + 1;
            q.add(new Node(ny, nx, cur.c + 1));
          }
        } else { // 흰색
          if(dp[ny][nx] > cur.c) {
            dp[ny][nx] = cur.c;
            q.add(new Node(ny, nx, cur.c));
          }
        }
      }
    }
    return ans;
  }
}