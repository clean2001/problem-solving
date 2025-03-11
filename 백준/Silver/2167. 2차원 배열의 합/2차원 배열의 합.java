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

    int[][] arr = new int[N][M];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; ++i) {
      st = new StringTokenizer(br.readLine());

      int q = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int sum = 0;
      for(int a=q-1; a<x; ++a) {
        for(int b=r-1; b<y; ++b) {
          sum += arr[a][b];
        }
      }

      bw.write(sum + "\n");
    }


    bw.flush();

  }
}