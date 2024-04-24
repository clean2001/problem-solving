import java.io.*;
import java.util.*;
// 다리만들기2
class Main {
  static int N, M;
  static int[][] map;
  static boolean[][] vis;
  static int[][] adj;
  static int[][] islandMap;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  static class Bridge implements Comparable<Bridge>{
    int from;
    int to;
    int dist;

    Bridge(int from, int to, int dist) {
      this.from = from;
      this.to = to;
      this.dist = dist;
    }

    public int compareTo(Bridge b) {
      return this.dist - b.dist;
    }
  }

  static class Node {
    int y, x, d;
    Node(int y, int x, int d) {
      this.y = y;
      this.x = x;
      this.d = d;
    }

    public boolean equals(Node n) {
      return this.y == n.y && this.x == n.x;
    }
  }

  // MST
  static int[] parent;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    vis = new boolean[N][M];
    map = new int[N][M];
    islandMap = new int[N][M];

    // 입력 받기
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 섬을 세기
    int idx = 1;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(map[i][j] == 1 && !vis[i][j]) {
          bfs(i, j, idx);
          ++idx;
        }
      }
    }

    adj = new int[idx][idx];
    for(int i=0; i<idx; ++i) {
      for(int j=0; j<idx; ++j) {
        adj[i][j] = Integer.MAX_VALUE;
      }
    }

    // 다리 세기
    // 가로
    for(int i=0; i<N; ++i) {
      int curIsland = 0;
      int len = 0;
      for(int j=0; j<M; ++j) {
        if(curIsland == 0 && map[i][j] == 1) {
          curIsland = islandMap[i][j];
        } else if(curIsland > 0 && map[i][j] == 0) {
          len++;
        } else if(curIsland > 0 && map[i][j] == 1) {
          int island = islandMap[i][j];
          if(island == curIsland) { // 여기서 len = 0 해줘야함.. 아 중간에 0끼어있을 수 있어서 그렇구나
            len = 0; continue;
          }
          if(len <= 1) {
            len = 0;
            curIsland = island;
            continue;
          }

          adj[island][curIsland] = Math.min(len, adj[island][curIsland]);
//          adj[curIsland][island] = Math.min(len, adj[curIsland][island]);
          len = 0;
          curIsland = island;
        }
      }
    }

    // 세로
    for(int i=0; i<M; ++i) {
      int curIsland = 0;
      int len = 0;
      for(int j=0; j<N; ++j) {
        if(curIsland == 0 && map[j][i] == 1) {
          curIsland = islandMap[j][i];
        } else if(curIsland > 0 && map[j][i] == 0) {
          len++;
        } else if(curIsland > 0 && map[j][i] == 1) {
          int island = islandMap[j][i];
          if(island == curIsland) {
            len = 0; continue;
          }
          if(len <= 1) {
            len = 0;
            curIsland = island;
            continue;
          }
          adj[island][curIsland] = Math.min(len, adj[island][curIsland]);
          len = 0;
          curIsland = island;
        }
      }
    }


    // 다리 추가
    ArrayList<Bridge> list = new ArrayList<>();
    for(int i=0; i<idx; ++i) {
      for(int j=0; j<idx; ++j) {
        if(adj[i][j] == Integer.MAX_VALUE) continue;
        list.add(new Bridge(i, j, adj[i][j]));
      }
    }

////    // debug
//    for(int i=1; i<idx; ++i) {
//      for(int j=1; j<idx; ++j) {
//        System.out.print(adj[i][j] + " ");
//      }
//      System.out.println();
//    }
//    // debug
//    for(int i=0; i<N; ++i) {
//      for(int j=0; j<M; j++) {
//        System.out.print(islandMap[i][j] + " ");
//      }
//      System.out.println();
//    }

    // 다리 연결 하기 => 작은 것부터
    parent = new int[idx];
    for(int i=0; i<idx; ++i) parent[i] = i;

    Collections.sort(list);
    int ans = 0;
    boolean flag = false;
    for(Bridge b : list) {
      // 다 연결 되어있는지 체크
      if(isAllConnected(idx)) {
        flag = true;
        break;
      }
      // 안돼있으면 유니온
      ans += union(b.from, b.to, b.dist);
    }

    if(isAllConnected(idx)) {
      flag = true;
    }

    if (flag) {
      System.out.println(ans);
    } else {
      System.out.println(-1);
    }


  }

  private static boolean isAllConnected(int idx) {
    if(idx == 1) return true;
    int p = findParent(1);
    for(int i=2; i<idx; ++i) {
      int curP = findParent(i);
      if(p!=curP) return false;
    }

    return true;
  }

  private static int findParent(int n) {
    if(parent[n] == n) return n;
    else return parent[n] = findParent(parent[n]);
  }

  private static int union(int a, int b, int d) {
    int pa = findParent(a);
    int pb = findParent(b);

    if(pa == pb) return 0;
    else {
      parent[pa] = pb;
      return d;
    }
  }

  private static void bfs(int y, int x, int idx) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(y, x, 0));
    vis[y][x] = true;

    while(!q.isEmpty()) {
      Node cur = q.poll();
      islandMap[cur.y][cur.x] = idx;
      for(int i=0; i<4; ++i) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if(map[ny][nx] == 0) continue;
        if(vis[ny][nx]) continue;

        vis[ny][nx] = true;
        Node n = new Node(ny, nx, cur.d+1);
        q.add(n);
        vis[ny][nx] = true;
      }
    }

  }
}