import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String s = br.readLine();

      if(s == null || s.isEmpty() || s.isBlank()) {
        break;
      }

      StringTokenizer st = new StringTokenizer(s);


      int N = Integer.parseInt(st.nextToken());

      int[] arr = new int[N];
      for(int i=0; i<N; ++i) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      boolean[] chk = new boolean[N];
      for(int i=1; i<N; ++i) {
        int diff = Math.abs(arr[i] - arr[i-1]);

        if(diff < N) {
          chk[diff] = true;
        }
      }

      // 확인
      boolean isOk = true;
      for(int i=1; i<N; ++i) {
        if(!chk[i]) {
          isOk = false;
          break;
        }
      }

      if(isOk) {
        bw.write("Jolly\n");
      } else {
        bw.write("Not jolly\n");
      }
    }

    bw.flush();
  }

}