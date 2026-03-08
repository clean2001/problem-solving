import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  public static int tempCount = 0;
  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static List<List<Integer>> adj = new ArrayList<>();
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    for(int i=0; i<n; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<n; ++i) {
      String s = br.readLine();
      for(int j=0; j<n; ++j) {
        if(s.charAt(j) == 'Y') {
          adj.get(i).add(j);
        }
      }
    }

    int maxVal = 0;
    for(int i=0; i<n; ++i) {
      // 친구 찾기
      Set<Integer> set = new HashSet<>();
      set.addAll(adj.get(i));

      // 2친구 찾기
      List<Integer> nexts = adj.get(i);
      for (Integer next : nexts) {
        set.addAll(adj.get(next));
      }

      maxVal = Math.max(maxVal, set.size()-1);
    }

    bw.write(Integer.toString(maxVal));
    bw.flush();
  }


}