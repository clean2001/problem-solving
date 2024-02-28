import java.io.*;
import java.util.*;

class B16236 {
    static int N;
    static int[][] map;
    static int shark = 2;
    static int remain = 2;
    static int cury, curx;
    static class Node {
        int y, x;
        int dist;

        Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] != 0 && map[i][j] != 9) {
                    pq.add(map[i][j]);
                }

                if(map[i][j] == 9) {
                    cury = i;
                    curx = j;
                    map[i][j] = 0;
                }
            }
        }

        int ans = 0;
        while(true) {

            int cy = cury, cx = curx;
            int ret = bfs(cury, curx);

//            System.out.println("ret: " + ret);

            if(ret == -1) break;

            ans += ret;
            remain--;
            if(remain == 0) {
                shark++;
                remain = shark;
            }

        }

        System.out.println(ans);
    }

    private static int bfs(int cy, int cx) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                if(o1.dist == o2.dist && o1.y == o2.y) return o1.x - o2.x;
                else if(o1.dist == o2.dist) return o1.y - o2.y;

                return o1.dist - o2.dist;
            }
        });

//        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
//                o1.x != o2.x ? Integer.compare(o1.x, o2.x) : (o1.y != o2.y ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x))
//        );
        q.add(new Node(cy, cx, 0 ));

        boolean[][] visited = new boolean[N][N];
        visited[cy][cx] = true;

        int cnt;

        while(!q.isEmpty()) {
            Node cur = q.poll();


            if(map[cur.y][cur.x] > 0 && map[cur.y][cur.x] < shark) {
                map[cur.y][cur.x] = 0;
                cury = cur.y;
                curx = cur.x;
                cnt = cur.dist;

                return cnt;
            }

            for(int i=0; i<4; ++i) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny < 0 || nx <0 || ny >= N || nx >= N) continue;
                if(map[ny][nx] > shark) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new Node(ny, nx, cur.dist + 1));
            }
        }
        return -1;
    }
}