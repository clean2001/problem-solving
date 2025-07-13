import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, C, T;
  static int[][][] map;
  static int[][][] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new int[N][M][K];
    vis = new int[N][M][K];
    Queue<int[]> q = new LinkedList<>();
    for(int k=0; k<K; ++k) {
      for(int i=0; i<N; ++i) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; ++j) {
          map[i][j][k] = Integer.parseInt(st.nextToken());

          if(map[i][j][k] == 1) {
            q.add(new int[] {i, j, k});
            vis[i][j][k] = 1;
          }
        }
      }
    }

    int ans = 0;
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      for(int i=0; i<6; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        int nz = cur[2] + dz[i];

        if(ny < 0 || nx < 0 || nz <0 || ny >= N || nx >= M || nz >= K) continue;
        if(vis[ny][nx][nz] != 0) continue;
        if(map[ny][nx][nz] != 0) continue;

        vis[ny][nx][nz] = vis[cur[0]][cur[1]][cur[2]] + 1;
        map[ny][nx][nz] = 1;
        ans = vis[ny][nx][nz];
        q.add(new int[]{ny, nx, nz});
      }
    }

    boolean flag = true;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        for(int k=0; k<K; ++k) {
          if(map[i][j][k] == 0) {
            flag = false; break;
          }
        }
      }
    }

//    for(int i=0; i<N; ++i) {
//      for(int j=0; j<M; ++j) {
//        for(int k=0; k<K; ++k) {
//          bw.write(map[i][j][k] + " ");
//        }
//        bw.write("\n");
//      }
//      bw.write("\n");
//    }

    if(!flag) bw.write("-1\n");
    else if(ans == 0) bw.write(ans+"\n");
    else bw.write(ans-1+"\n");
    bw.flush();
  }

}