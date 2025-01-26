import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int sum = 1;
    int left = 1, right = 1;
    int ans = 0;

    while(left <= N) {
      if(sum < N) {
        sum += ++right;
      } else if(sum > N) {
        sum -= left++;
      } else {
//        bw.write(left + " " + right + "\n");
        ans++;
        sum -= left++;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}