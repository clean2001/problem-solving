import java.io.*;
import java.util.*;

class Main {
  static int N, K;
  static int[] t;
  static int[] vis;

  static class Node implements Comparable<Node> {
    int d;
    int t;

    Node(int d, int t) {
      this.d = d;
      this.t = t;
    }

    public int compareTo(Node n) {
      return this.t - n.t;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    vis = new int[300000];
    for(int i=0; i<300000; ++i) vis[i] = Integer.MAX_VALUE;
    vis[N] = 0;

    int ans = Integer.MAX_VALUE;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(N, 0));
    while(!pq.isEmpty()) {
      Node cur = pq.poll();
//      System.out.println(cur.d + "   " + cur.t);
      if(cur.d == K) {
        ans = cur.t; break;
      }

    if(2*cur.d < 300000 && vis[2*cur.d] > cur.t) {
      pq.add(new Node(2*cur.d, cur.t));
      vis[2*cur.d] = cur.t;
    }
    if(cur.d+1 < 300000 && vis[cur.d+1] > cur.t+1) {
      pq.add(new Node(cur.d+1, cur.t+1));
      vis[1+cur.d] = cur.t+1;
    }
    if(cur.d-1 >= 0 && vis[cur.d-1] > cur.t+1) {
      pq.add(new Node(cur.d-1, cur.t+1));
      vis[cur.d-1] = cur.t+1;
      }
    }

    System.out.println(ans);
  }
}