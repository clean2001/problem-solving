import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int R, C, T;
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[R][C];
    int hx = -1;
    int lx = -1;
    for(int i=0; i<R; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<C; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if(map[i][j] == -1 && hx == -1) {
          hx = i;
        } else if(map[i][j] == -1) {
          lx = i;
        }
      }
    }

    while(T -- > 0) {
      // 1. 확산

      // 1-1 복사
      int[][] newMap = new int[R][C];
      for(int i=0; i<R; ++i) {
        for(int j=0; j<C; ++j) {
          newMap[i][j] = map[i][j];
        }
      }


      for(int i=0; i<R; ++i) {
        for(int j=0; j<C; ++j) {
          if(map[i][j] == 0 || map[i][j] < 5) continue;

          int plus = map[i][j] / 5;
          int cnt = 0;
          for(int k=0; k<4; ++k) {
            int ny = i + dy[k];
            int nx = j + dx[k];


            if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            if(map[ny][nx] == -1) continue;

            cnt++;
            newMap[ny][nx] += plus;
          }


          newMap[i][j] -= plus * cnt;
        }
      }

      map = newMap;
//
//      System.out.println("확산 후:");
//      for(int i=0; i<R; ++i) {
//        for(int j=0; j<C; ++j) {
//          System.out.print(map[i][j] + " ");
//        }
//        System.out.println();
//      }

//      System.out.println();


      // 2. 공기 청정기
      // 2-1. 위쪽 청정기

      // 아래 이동
      for(int i=hx; i>0; --i) {
        map[i][0] = map[i-1][0];
      }
      map[hx][0] = -1;


      // 왼쪽이동
      for(int i=0; i<C-1; ++i) {
        map[0][i] = map[0][i+1];
      }

      // 위쪽이동
      for(int i=0; i<hx; ++i) {
        map[i][C-1] = map[i+1][C-1];
      }

      // 오른쪽이동
      for(int i=C-1; i>0; --i) {
        map[hx][i] = map[hx][i-1];
      }
      map[hx][1] = 0;

      // 2-2.아래쪽 공기 청정기

      // 위쪽 이동
      for(int i=lx; i<R-1; ++i) {
        map[i][0] = map[i+1][0];
      }
      map[lx][0] = -1;

      // 왼쪽이동
      for(int i=0; i<C-1; ++i) {
        map[R-1][i] = map[R-1][i+1];
      }

      // 아래 이동
      for(int i=R-1; i>lx; --i) {
        map[i][C-1] = map[i-1][C-1];
      }

      // 오른쪽이동
      for(int i=C-1; i>0; --i) {
        map[lx][i] = map[lx][i-1];
      }
      map[lx][1] = 0;


      int sum = 0;
      for(int i=0; i<R; ++i) {
        for(int j=0; j<C; ++j) {
          if(map[i][j] !=-1) sum += map[i][j];
        }
      }


//      System.out.println("이동 후:");
//      for(int i=0; i<R; ++i) {
//        for(int j=0; j<C; ++j) {
//          System.out.print(map[i][j] + " ");
//        }
//        System.out.println();
//      }
//
//      System.out.println();


    }


    int ans =0;
    for(int i=0; i<R; ++i) {
      for(int j=0; j<C; ++j) {
        if(map[i][j] == -1) continue;
        ans += map[i][j];
      }
    }
    System.out.print(ans);
  }
}