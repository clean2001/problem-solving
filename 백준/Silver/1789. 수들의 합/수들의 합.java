import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long N = Long.parseLong(br.readLine());

    long sum = 0;
    long ans = 0;
    for(long i=1; i<=N; ++i) {
      sum += i;

      if(sum > N) {
        ans = i - 1;
        break;
      } else if(sum >= N) {
        ans = i;
        break;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}