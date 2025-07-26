import java.io.*;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, M, K;
  static boolean[] vis;
  static int[] ans;
  static int turn = 1;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      int a = Integer.parseInt(br.readLine());
      list.add(a);
      sum += a;
      int curCnt = map.getOrDefault(a, 0);
      map.put(a, curCnt+1);
    }

    List<Integer> most = new ArrayList<>();
    int maxCnt = -1;
    for(Map.Entry<Integer, Integer> e : map.entrySet()) {
      if(e.getValue() > maxCnt) {
        most = new ArrayList<>();
        most.add(e.getKey());
        maxCnt = e.getValue();
      } else if(e.getValue() == maxCnt) {
        most.add(e.getKey());
      }
    }

    Collections.sort(list);
    Collections.sort(most);

    int mostNum = 0;
    if(most.size() == 1) {
      mostNum = most.get(0);
    } else {
      mostNum = most.get(1);
    }

    System.out.println(Math.round((double)sum / N));
    System.out.println(list.get(list.size()/2));
    System.out.println(mostNum);
    System.out.println(list.get(list.size()-1) - list.get(0));
  }

}