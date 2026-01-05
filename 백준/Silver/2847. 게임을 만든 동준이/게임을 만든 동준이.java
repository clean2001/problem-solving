import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int ans = 0;
    for(int i=N-1; i >= 1; --i) {
      if(arr[i-1] >= arr[i]) {
        int diff = arr[i-1] - arr[i] + 1;
        arr[i-1] -= diff;
        ans += diff;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }
}