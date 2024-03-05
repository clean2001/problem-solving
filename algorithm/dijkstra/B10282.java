import java.io.*;
import java.util.*;

class B10282 {
    static int T, N, D, C;
    static int M = 10000;
    static int[] visited = new int[M+1];
    static int INF = (int)1e9;


    static ArrayList<ArrayList<Node>> adj;

    static class Node implements Comparable<Node>{
        int n, d;
        Node(int n, int d) {
            this.n = n;
            this.d = d;
        }

        public int compareTo(Node n) {
            return this.d - n.d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            visited = new int[N+1];
            adj = new ArrayList<>();
            for(int i=0; i<=N; ++i) {
                visited[i] = INF;
                adj.add(new ArrayList<>());
            }

            for(int i=0; i<D; ++i) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                adj.get(b).add(new Node(a, s));
            }

            dijkstra();
            int ans = 0;
            int time = -1;
            for(int i=1; i<=N; i++) {
                if(visited[i] != INF) {
                    ans++;
                    time = Math.max(time, visited[i]);
                }
            }

            bw.write(ans + " " + time + "\n");
        }

        bw.flush();
    }

    public static void dijkstra() {
        visited[C] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(C, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.n] < cur.d) continue;

            for(Node next : adj.get(cur.n)) {
                if(visited[next.n] > cur.d + next.d) {
                    visited[next.n] = cur.d + next.d;
                    pq.add(new Node(next.n, visited[next.n]));
                }
            }
        }
    }
}