import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    Integer[] arr = new Integer[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int ans = 0;
    int l = 0, r = N-1;
    while(l < r) {
      if(arr[l] + arr[r] <= K) {
        ans++;
        l++; r--;
      } else {
        r--;
      }
    }

    System.out.println(ans);
  }
}