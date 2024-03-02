import java.io.*;
import java.sql.Array;
import java.util.*;

class B1753 {
    static int V, E, S;
    static List<ArrayList<Node>> adj = new ArrayList<>();

    static int[] visited;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int next;
        int weight;

        Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());

        for(int i=0; i<=V; ++i) {
            adj.add(new ArrayList<>());
        }

        visited = new int[V+1];
        for(int i=0; i<visited.length; ++i) visited[i] = INF;

        for(int i=0; i<E; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Node(v, w));
        }

        dijkstra();
        for(int i=1; i<=V; ++i) {
            if(visited[i] == INF) {
                bw.write("INF\n");
            } else bw.write(visited[i] + "\n");
        }

        bw.flush();
    }

    static void dijkstra() {
        visited[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
//            visited[cur.next] = Math.min(visited[cur.next], cur.weight);
            if(visited[cur.next] < cur.weight) continue;

            for(Node n : adj.get(cur.next)) {
                if(visited[n.next] > visited[cur.next] + n.weight) {
//                    System.out.println(n.next + " " + visited[cur.next] + n.weight);
                    visited[n.next] = visited[cur.next] + n.weight;
                    pq.add(new Node(n.next, visited[n.next]));
                }
            }

        }
    }
}