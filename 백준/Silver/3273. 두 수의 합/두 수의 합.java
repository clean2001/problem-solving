import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

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

    int target = Integer.parseInt(br.readLine());

    Arrays.sort(arr);

    int l = 0, r = N-1;
    int ans = 0;
    while(l < r) {
      int cur = arr[l] + arr[r];
      if(cur == target) {
        ans++; l++;
      } else if(cur < target) { // 더 크게 만들어야함
        l++;
      } else {
        r--;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}