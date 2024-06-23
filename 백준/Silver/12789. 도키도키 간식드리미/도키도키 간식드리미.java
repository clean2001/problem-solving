import java.io.*;
import java.util.*;

class Main {
  static int N;
  static boolean[] vis;
  static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    vis = new boolean[N+1];
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    vis[0] = true;
    Deque<Integer> dq = new LinkedList<>();
    for(int i=0; i<N; ++i) {
      if(vis[arr[i]-1]) {
        vis[arr[i]] = true;
      } else if(!dq.isEmpty() && vis[dq.peek() - 1]){
        while(!dq.isEmpty() && vis[dq.peek() - 1]) {
          vis[dq.poll()] = true;
        }
        dq.addFirst(arr[i]);
      } else {
        dq.addFirst(arr[i]);
      }

    }

    while(!dq.isEmpty()) {
      if(vis[dq.peek() - 1]) {
        vis[dq.poll()] = true;
      } else {
        break;
      }
    }

    String ans = "Nice";
    for(int i=1; i<=N; ++i) {
      if(!vis[i]) {
        ans = "Sad";
        break;
      }
    }

    System.out.println(ans);

  }

}