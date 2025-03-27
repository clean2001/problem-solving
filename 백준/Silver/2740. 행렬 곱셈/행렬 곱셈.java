import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] m1 = new int[N][M];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        m1[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] m2 = new int[K][M];

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<K; ++j) {
        m2[j][i] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] res = new int[N][K];
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        for(int k=0; k<K; ++k) {
          res[i][k] += m1[i][j] * m2[k][j]; // 0 0 *
        }
      }
    }


    for(int i=0; i<N; ++i) {
      for(int j=0; j<K; ++j) {
        bw.write(res[i][j] + " ");
      }
      bw.write("\n");
    }
    bw.flush();
  }
}