import java.io.*;
import java.util.*;

class Main {
  static Map<Integer, Integer> cntMap = new HashMap<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      int num = Integer.parseInt(st.nextToken());
      int cnt = cntMap.getOrDefault(num, 0);
      cntMap.put(num, cnt+1);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; ++i) {
      int num = Integer.parseInt(st.nextToken());
      bw.write(cntMap.getOrDefault(num, 0) + " ");
    }

    bw.flush();
  }
}