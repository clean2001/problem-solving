import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main{
  private static int gcb(int a, int b) {
    if(b == 0) return a;
    if(a == 1) return 1;

    return gcb(b, a % b);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
    }

    if(N == 1) {
      System.out.println(arr[0]);
    } else {
      int cur = gcb(arr[0], arr[1]);
      for(int i=2; i<N; ++i) {
        cur = gcb(cur, arr[i]);
      }
      System.out.println(cur);
    }

  }
}