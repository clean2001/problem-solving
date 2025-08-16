import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int ans = 1;
    int maxVal = 0;
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int[] arr = new int[5];
      for(int j=0; j<5; ++j) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      for(int j=0; j<5; ++j) {
        for(int k=j+1; k<5; ++k) {
          for(int l=k+1; l<5; ++l) {
            int cur = arr[j] + arr[k] + arr[l];
            if(cur%10 >= maxVal) {
              maxVal = cur%10;
              ans = i+1;
            }
          }
        }
      }
    }

    System.out.println(ans);
  }
}