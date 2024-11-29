import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[M];
    for(int i=0; i<M; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    // 칸별로 모이는 빗물의 양을 구하기
    for(int i=1; i<M-1; ++i) {
      int h = arr[i];

      int left = -1;
      int right = -1;
      for(int j=0; j<i; ++j) {
        if(arr[j] <= h) continue;
        left = Math.max(left, arr[j]);
      }

      for(int j=i+1; j<M; ++j) {
        if(arr[j] <= h) continue;
        right = Math.max(right, arr[j]);
      }

      if(right == -1 || left == -1) continue;

      ans += (Math.min(right, left) - h);
    }

    System.out.println(ans);
  }
}