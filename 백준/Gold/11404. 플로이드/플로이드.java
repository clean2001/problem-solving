import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static int[][] dist;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    dist = new int[n+1][n+1];

    // dist 배열 초기화
    for(int i=0; i<=n; ++i) {
      for(int j=0; j<=n; ++j) {
        dist[i][j] = Integer.MAX_VALUE;

        if(i==j) dist[i][j] = 0;
      }
    }

    for(int i=0; i<m; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      dist[s][e] = Math.min(dist[s][e], w);
    }

    for(int k=1; k<=n; ++k) {
      for(int j=1; j<=n; ++j) {
        for(int i=1; i<=n; ++i) {
          if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;

          dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
        }
      }
    }


    for(int i=1; i<=n; ++i) {
      for(int j=1; j<=n; ++j) {
        if(dist[i][j] == Integer.MAX_VALUE) {
          System.out.print(0+" ");
        } else {
          System.out.print(dist[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}
