import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int[][] m1, m2;
  static int[][] diff;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    m1 = new int[N][M];
    m2 = new int[N][M];
    diff = new int[N][M];

    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<M; ++j) {
        m1[i][j] = s.charAt(j) - '0';
      }
    }

    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<M; ++j) {
        m2[i][j] = s.charAt(j) - '0';
        if(m1[i][j] != m2[i][j]) diff[i][j] = 1;
      }
    }

    int cnt = 0;
    for(int i=0; i+3<=N; ++i) {
      for(int j=0; j+3<=M; ++j) {
        if(diff[i][j] == 1) {
          flip(i, j);
          cnt++;
        }

//        System.out.println();
//        for(int k=0; k<N; ++k) {
//          System.out.println(Arrays.toString(diff[k]));
//        }
      }
    }

    // 비교하기
    loop1:
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(diff[i][j] == 1) {
          cnt = -1; break loop1;
        }
      }
    }


    System.out.println(cnt);

  }

  private static void flip(int y, int x) {
    for(int i=y; i<y+3; ++i) {
      for(int j=x; j<x+3; ++j) {
        diff[i][j] = Math.abs(diff[i][j] - 1);
      }
    }
  }

  private static boolean compareArr(int y, int x) {
    for(int i=y; i<y+3; ++i) {
      for(int j=x; j<x+3; ++j) {
        if(diff[i][j] == 1) return false;
      }
    }

    return true;
  }
}