
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int n;
  static List<List<int[]>> adj;

  static int[][] matrix;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    matrix = new int[N][N];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] ret = solve(N, B, matrix);

    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        bw.write(ret[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }

  private static int[][] solve(int N, long B, int[][] m) {
    if(B == 1) {
      for(int i=0; i<N; ++i) {
        for(int j=0; j<N; ++j) {
          m[i][j] %= 1000;
        }
      }
      return m;
    }

    int[][] ret1 = solve(N, B/2, m);
    // 행렬 곱
    int[][] ret2 = new int[N][N];
    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        for(int k=0; k<N; ++k) {
          ret2[i][j] += (ret1[i][k] * ret1[k][j]) % 1000;
          ret2[i][j] %= 1000;
        }
      }
    }


    if(B%2 == 0) {
      return ret2;
    } else {
      int[][] ret3 = new int[N][N];
      for(int i=0; i<N; ++i) {
        for(int j=0; j<N; ++j) {
          for(int k=0; k<N; ++k) {
            ret3[i][j] += (ret2[i][k] * m[k][j]) % 1000;
            ret3[i][j] %= 1000;
          }
        }
      }

      return ret3;
    }
  }

}