import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
  private static String S;
  private static int N, M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    int l = 0, r = 0;
    int sum = arr[0], ans = 0;
    while(l <= r) {
//      System.out.println(l + " " + r + " " + sum);
      if(sum == M) {
        ans++;
        if(r < N-1) {
          sum += arr[++r];
        } else {
          sum -= arr[l++];
        }
      } else if((sum < M || l == r) && r < N-1) {
        sum += arr[++r];
      } else {
        sum -= arr[l++];

      }
    }

    System.out.println(ans);
  }
}