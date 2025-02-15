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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int k=1000; k>=0; --k) {
      int cntUp = 0, cntDown = 0;
      for(int i=0; i<N; ++i) {
        if(arr[i] < k) cntDown++;
        if(arr[i] >= k) cntUp++;
      }

      if(cntUp >= k) {
        System.out.println(k);
        break;
      }

    }
  }

}