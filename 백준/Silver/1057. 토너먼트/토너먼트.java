import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int cur = 2;
    int ans = 1;

    while(true) {
      int d1, d2;
      if(a == 1) {
        d1 = 0;
      } else {
        d1 = (a - 1) / cur;
      }

      if(b == 1) {
        d2 = 0;
      } else {
        d2 = (b - 1) / cur;
      }

      if(d1 == d2) break;

      ans++;
      cur = cur << 1;
    }

    System.out.println(ans);
  }
}