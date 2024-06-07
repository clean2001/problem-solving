import java.io.*;
import java.util.*;

class Main {
  static int T;
  static int N, M;
  static int cy, cx;
  static char[][] map;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, -1, 1};

  static Queue<Node> fire = new LinkedList<>();

  static class Node {
    int y, x, d;
    Node(int y, int x, int d) {
      this.y = y;
      this.x = x;
      this.d = d;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      fire = new LinkedList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      map = new char[M][N];
      for(int i=0; i<M; ++i) {
        String line = br.readLine();
        for(int j=0; j<N; ++j) {
          map[i][j] = line.charAt(j);

          if(map[i][j] == '@') {
            cy = i; cx = j;
          } else if(map[i][j] == '*') fire.add(new Node(i, j, 0));
        }
      }

      int ans = bfs();
      if(ans == -1) {
        System.out.println("IMPOSSIBLE");
      } else {
        System.out.println(ans);
      }
    }
  }

  private static int bfs() {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(cy, cx,0));
    boolean[][] vis = new boolean[M][N];
    vis[cy][cx] = true;
    int prev = -1;

    while(!q.isEmpty()) {
      Node cur = q.poll();


      if(cur.d != prev) {
        prev = cur.d;
        makeFire(fire, prev);
//        printMap();
//        System.out.println();
      }

      for(int i=0; i<4; ++i) {
        int ny = cur.y + dy[i];

        int nx = cur.x + dx[i];

        if(ny < 0 || nx < 0 || ny >= M || nx >= N) { // 탈출
          return cur.d + 1;
        }
        if(map[ny][nx] == '*' || map[ny][nx] == '#') continue;
        if(vis[ny][nx]) continue;

        vis[ny][nx] = true;
        q.add(new Node(ny, nx, cur.d+1));
      }
    }
    return -1;
  }

  // 이걸 bfs로 바꿔야 함
  private static void makeFire(Queue<Node> q, int d) {
    while(!q.isEmpty()) {
      Node cur = q.peek();
      if(cur.d != d) return;

      q.poll();

      for(int i=0; i<4; ++i) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if(ny < 0 || nx < 0 || ny >= M || nx >= N) {
          continue;
        }
        if(map[ny][nx] == '*' || map[ny][nx] == '#') continue;
        q.add(new Node(ny, nx, cur.d+1));
        map[ny][nx] = '*';
      }
    }
  }

  private static void printMap() {
    for(int i=0; i<M; ++i) {
      for(int j=0; j<N; ++j) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }
}