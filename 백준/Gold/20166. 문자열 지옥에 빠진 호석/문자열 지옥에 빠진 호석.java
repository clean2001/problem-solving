import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  public static int[] dp;
  private static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
  private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
  public static char map[][];
  public static int N, M;

  static class Node {
    int y, x;
    String s;

    Node(int y, int x, String s) {
      this.y = y;
      this.x = x;
      this.s = s;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<M; ++j) {
        map[i][j] = s.charAt(j);
      }
    }

    Map<String, Integer> m = new HashMap<>();
    for(int i=0; i<K; ++i) {
      String s = br.readLine();

      if(m.get(s) != null) {
        System.out.println(m.get(s));
        continue;
      }

      int temp = 0;
      for(int j=0; j<N; ++j) {
        for(int k=0; k<M; ++k) {
          if(map[j][k] != s.charAt(0)) continue;
          
          int ret = bfs(j, k, s);
          temp += ret;
        }
      }

      System.out.println(temp);
      m.put(s, temp);
    }
  }

  private static int bfs(int sy, int sx, String target) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(sy, sx, Character.toString(map[sy][sx])));
    int ret = 0;
    while(!q.isEmpty()) {
      Node cur = q.poll();
      if(cur.s.equals(target)) {
        ret++; continue;
      } else if(cur.s.length() >= target.length()) {
        continue;
      }

      for(int i=0; i<8; ++i) {
        int ny = (cur.y + map.length + dy[i]) % N;
        int nx = (cur.x + map[0].length + dx[i]) % M;

        if(cur.s.length() < target.length() && map[ny][nx] == target.charAt(cur.s.length())) {
          q.add(new Node(ny, nx, cur.s + Character.toString(map[ny][nx])));

        }
      }
    }

    return ret;

  }
}