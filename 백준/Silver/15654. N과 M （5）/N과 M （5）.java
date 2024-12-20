
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  private static Integer[] arr;
  private static boolean[] vis;
  private static int[] arrInt;
  private static int N, M;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new Integer[N];
    vis = new boolean[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    arrInt = Stream.of(arr).sorted().mapToInt(a -> a).toArray();

//    for(int i=0; i<arrInt.length; ++i) {
//      System.out.print(arrInt[i] + " ");
//    }
//    System.out.println();

    perm(new ArrayList<>(), 0);

    bw.flush();
  }

  private static void perm(List<Integer> list, int idx) throws Exception {
//    bw.write(list + "\n");
    if(list.size() == M) {
      for (Integer val : list) {
        bw.write(val + " ");
      }
      bw.write("\n");
      return;
    }


    for(int i=0; i<N; ++i) {
      if(vis[i]) continue;
      vis[i] = true;
      list.add(arrInt[i]);
      perm(list, i+1);
      list.remove(list.size()-1);
      vis[i] = false;
    }
  }
}
