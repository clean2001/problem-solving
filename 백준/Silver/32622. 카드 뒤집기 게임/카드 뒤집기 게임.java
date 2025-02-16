import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  private static boolean[] vis;
  private static int ans = 0;
  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {

      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 연속 구하기
    int prev = -1;
    int sum = 1;
    List<Integer> list = new ArrayList<>();
    int maxVal = -1;
    for(int i=0; i<N; ++i) {
      if(prev != arr[i]) {
        prev = arr[i];

        if(i > 0) {
          list.add(sum);
          maxVal = Math.max(maxVal, sum);
          sum = 1;
        }
      } else {
        sum++;
      }
    }

    if(sum > 0) {
      maxVal = Math.max(maxVal, sum);
      list.add(sum);
    }

    // 두개 합
    if(list.size() > 1) {
      for(int i=0; i<list.size()-1; ++i) {
        int sub = list.get(i) + list.get(i+1);
        maxVal = Math.max(sub, maxVal);
      }
    }

    System.out.println(maxVal);
  }



}