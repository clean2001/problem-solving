import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] vis = new int[100002];
    for(int i=0; i<100002; ++i) {
      vis[i] = Integer.MAX_VALUE;
    }
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{N, 0});
    vis[N] = 0;
    int ans = 100001; // 찾는데까지 걸리는 횟수
    int ansCnt = 0; // 그 개수
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      if(cur[0] == K && ans == 100001) {
        ans = cur[1];
        ansCnt++;
      } else if(cur[0] == K && ans == cur[1]) {
        ansCnt++;
      }

      int n1 = cur[0] + 1;
      int n2 = cur[0] - 1;
      int n3 = cur[0] * 2;
      int nCnt = cur[1] + 1;

      if(n1 >= 0 && n1 <= 100001 && nCnt < ans && vis[n1] >= nCnt) {
        vis[n1] = nCnt;
        q.add(new int[]{n1, nCnt});
      }

      if(n2 >= 0 && n2 <= 100001 && nCnt < ans && vis[n2] >= nCnt) {
        vis[n2] = nCnt;
        q.add(new int[]{n2, nCnt});
      }

      if(n3 >= 0 && n3 <= 100001 && nCnt < ans && vis[n3] >= nCnt) {
        vis[n3] = nCnt;
        q.add(new int[]{n3, nCnt});
      }

    }


    System.out.println(ans);
    System.out.println(ansCnt);

  }
}