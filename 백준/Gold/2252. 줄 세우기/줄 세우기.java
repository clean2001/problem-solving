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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Queue<Integer> q = new LinkedList<>();
    int[] indegree = new int[N+1];
    List<List<Integer>> nexts = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      nexts.add(new ArrayList<>());
    }

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      indegree[b]++;
      nexts.get(a).add(b);
    }

    for(int i=1; i<=N; ++i) {
      if(indegree[i] == 0) {
        q.add(i);
      }
    }

    while(!q.isEmpty()) {
      // indegree 0 찾기
      int target = q.poll();
      bw.write(target + " ");

      indegree[target] = -1; // 방문 표시
      List<Integer> next = nexts.get(target);
      for(int n : next) {
        indegree[n]--;

        if(indegree[n] == 0) {
          q.add(n);
        }
      }
    }
    bw.flush();
  }

}