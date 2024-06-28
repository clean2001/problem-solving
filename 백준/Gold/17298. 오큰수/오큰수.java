import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  // 일단 저희가 어떤 아이디어로 풀었는지 전체적으로 설명을 드리자면, bfs를 활용하여 풀었습니다.
  // bfs를 이용한 풀이는 크게 두가지가 나올 수 있음 -> 1. 상어가 없는 부분인 0에서 bfs를 돌려서 bfs를 0의 개수만큼 여러번 돌리는 방법, 2. 상어가 있는 위치를 큐에 먼저 저장해놓고 bfs를 돌려서 0인 칸까지의 최단 거리를 구해나가는 bfs를 한번만 돌리는 방법
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Deque<Integer> dq = new LinkedList<>();
    int[] inputs = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[N];
    result[N-1] = -1;
    for(int i=0; i<N; ++i) {
      int idx = N - 1 - i;
      int cur = inputs[idx];

      if(dq.isEmpty()) {
        result[idx] = -1;
        dq.addFirst(inputs[idx]);
      } else if(cur < dq.peekFirst()) {
        result[idx] = dq.peekFirst();
        dq.addFirst(cur);
      } else {
        while(!dq.isEmpty() && dq.peekFirst() <= cur) {
          dq.pollFirst();
        }
        if(dq.isEmpty()) {
          result[idx] = -1;
          dq.addFirst(cur);
        } else {
          result[idx] = dq.peekFirst();
          dq.addFirst(cur);
        }
      }

//      System.out.println(dq);

    }

    for(int i=0; i<N; ++i) {
      bw.write(result[i] + " ");
    }
    bw.flush();
  }
}