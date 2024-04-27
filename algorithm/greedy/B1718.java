import java.io.*;
import java.util.*;
// 카드 정렬하기
class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N+1];
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i=1; i<=N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
      pq.add(arr[i]);
    }

    int ans = 0;
    while(pq.size() > 1) {
      int a = pq.poll();
      int b = pq.poll();

      pq.add(a+b);
      ans += (a+b);
    }

    System.out.println(ans);
  }
}