import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfInt;

class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 기울기가 처음으로 양수로 가는?
    N = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();

    long temp = 0;
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int loc = Integer.parseInt(st.nextToken());
      int people = Integer.parseInt(st.nextToken());
      list.add(new int[] {loc, people});
      temp -= people;
    }

    list.sort((a, b) -> {
      return a[0] - b[0];
    });
    
    int ans = 0;
    for(int[] cur : list) {
      temp += (cur[1] * 2L);
      if(temp >= 0) {
        ans = cur[0];
        break;
      }
    }

    System.out.println(ans);
  }
}