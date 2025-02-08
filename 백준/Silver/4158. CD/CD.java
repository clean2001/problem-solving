import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());


      if(N == 0 && M == 0) break;

      Set<Integer> set = new HashSet<>();
      for(int i=0; i<N; ++i) {
        int a = Integer.parseInt(br.readLine());
        set.add(a);
      }

      int ans = 0;
      for(int i=0; i<N; ++i) {
        int b = Integer.parseInt(br.readLine());
        if(set.contains(b)) {
          ans++;
        }
      }

      bw.write(ans + "\n");
    }

    bw.flush();
  }

}