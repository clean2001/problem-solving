import java.io.*;
import java.util.*;

class Main {
  static int[] rev = {0, 6, 5, 4, 3, 2, 1}; // 정반대에 뭐가 있는지
  static int[] cur = {0, 0, 0, 0, 0, 0, 0}; // 위, 북, 동, 서, 남, 아래
  static int N, M, x, y, K;

  static int[] dy = {0, 0, 0, -1, 1}; // - 동서북남
  static int[] dx = {0, 1, -1, 0, 0};
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<K; ++i) {
//      System.out.println(i + " idx");
      int cmd = Integer.parseInt(st.nextToken());
      int ny = y + dy[cmd];
      int nx = x + dx[cmd];

      if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

      if(cmd == 1) { // 동
        cur = move1(cur);
      } else if(cmd == 2) { // 서
        cur = move2(cur);
      } else if(cmd == 3) { // 북
        cur = move3(cur);
      } else if(cmd == 4) { // 남
        cur = move4(cur);
      }

      if(map[ny][nx] != 0) { // 아래에 복사
        cur[6] = map[ny][nx];
        map[ny][nx] = 0;
      } else if(map[ny][nx] == 0){ // 바닥에 복사
        map[ny][nx] = cur[6];
      }

      bw.write(cur[1] + "\n");
      x = nx; y = ny;
    }

    bw.flush();
  }

  static int[] move1(int[] cur) { // 동
    int[] ret = new int[7];
    ret[3] = cur[1];
    ret[2] = cur[2];
    ret[1] = cur[4];
    ret[4] = cur[6];
    ret[6] = cur[3];
    ret[5] = cur[5];

    return ret;
  }


  static int[] move2(int[] cur) { // 서
    int[] ret = new int[7];
    ret[4] = cur[1];
    ret[1] = cur[3];
    ret[3] = cur[6];
    ret[6] = cur[4];
    ret[2] = cur[2];
    ret[5] = cur[5];

    return ret;
  }


  static int[] move3(int[] cur) { // 북
    int[] ret = new int[7];
    ret[2] = cur[1];
    ret[1] = cur[5];
    ret[5] = cur[6];
    ret[6] = cur[2];
    ret[3] = cur[3];
    ret[4] = cur[4];

    return ret;
  }


  static int[] move4(int[] cur) { // 남
    int[] ret = new int[7];
    ret[1] = cur[2];
    ret[5] = cur[1];
    ret[6] = cur[5];
    ret[2] = cur[6];
    ret[3] = cur[3];
    ret[4] = cur[4];

    return ret;
  }
}