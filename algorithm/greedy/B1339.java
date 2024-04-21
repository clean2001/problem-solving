import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] point = new int[26];
    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; ++i) {
      String input = br.readLine();
//      String[] arr = input.split("");
      int pos = 1;
      for(int j = input.length()-1; j>=0; j--) {
        int idx = input.charAt(j) - 'A';
        point[idx] += pos;
        pos *= 10;
      }
    }

    Arrays.sort(point);

    int ans = 0;
    int num = 9;
    for(int i = 25; i>=0; i--) {
      if(point[i] == 0) continue;
      ans += point[i] * num;
      num--;
    }

    System.out.println(ans);
  }
}