import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[][] arr = new boolean[101][101];

    for(int i=0; i<4; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int sx = Integer.parseInt(st.nextToken());
      int sy = Integer.parseInt(st.nextToken());
      int ex = Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());

      for(int x=sx; x<ex; ++x) {
        for(int y=sy; y<ey; ++y) {
          arr[x][y] = true;
        }
      }
    }

    int ans = 0;
    for(int i=0; i<=100; ++i) {
      for(int j=0; j<=100; ++j) {
        if(arr[i][j]) ans++;
      }
    }

    bw.write(ans+"\n");
    bw.flush();
  }
}