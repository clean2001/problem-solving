import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfInt;

class Main {
  static int N;
  static int[] arr;
  static boolean[] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      int num = Integer.parseInt(br.readLine());
      if(i == 0) continue;
      list.add(num);
    }


    int cnt = 0;
    while(!list.isEmpty()) {
      cnt++;
      int minVal = list.get(0) - 1;
      int maxVal = list.get(list.size()-1);
      for(int cur = minVal; cur <= maxVal; cur += minVal) {
//        System.out.println(minVal + " " + maxVal);
        list.remove(Integer.valueOf(cur + 1));
      }
    }

    System.out.println(cnt);
  }
}