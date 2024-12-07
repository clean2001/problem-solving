import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long ans = 0;
    int left = 0, right = 0;
    while(right < N) {
      if(duplicate(arr, left, right)) {
        ans += (long)(right - left);
        left++;
      } else {
        right++;
      }
    }

    for(int i=left; i<right; ++i) {
      ans += (long)(right - i);
    }

    System.out.println(ans);
  }

  private static boolean duplicate(int[] arr, int l, int r) {
    for(int i=l; i<r; ++i) {
      if(arr[i] == arr[r]) return true;
    }

    return false;
  }
}