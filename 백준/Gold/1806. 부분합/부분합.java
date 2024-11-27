import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];

    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int l = 0;
    int r = 0;
    int total = arr[0];
    int ans = Integer.MAX_VALUE;
    while(l <= r) {
      if(total >= S) {
        ans = Math.min(ans, r - l + 1);
        total -= arr[l++];
      } else if(r < N - 1) {
        total += arr[++r];
      } else {
        break;
      }
    }

    if(total >= S) {
      ans = Math.min(ans, r - l + 1);
    }

//    System.out.println(total);
    if(ans == Integer.MAX_VALUE) {
      System.out.println(0);
    } else {
      System.out.println(ans);
    }
  }
}