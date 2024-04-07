import java.io.*;
import java.util.*;
// 3190. 뱀
class Main {
  static int N, K, L;
  static int cur_size = 0;
  static int head_y = 1;
  static int head_x= 1;
  static int tail_y = 1;
  static int tail_x = 1;
  static int d = 0;

  static int[] dy = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
  static int[] dx = {1, 0, -1, 0};
  static int[][] map;

  static Queue<Turn> list = new LinkedList<>();

  static class Turn {
    int time;
    String direction;

    Turn(int time, String direction) {
      this.time = time;
      this.direction = direction;
    }

  }

  static class Node {
    int y, x;

    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N+1][N+1];
    K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      map[y][x] = -1;
    }

    L = Integer.parseInt(br.readLine());
    for(int i=0; i<L; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      list.add(new Turn(Integer.parseInt(st.nextToken()), st.nextToken()));
//      System.out.println(list.get(list.size()-1).time + " "+ list.get(list.size()-1).direction);
    }

    // 뱀 움직이기 시작
    map[1][1] = 1; // 양수는 뱀
    cur_size = 1;
    int ans = 0;
    Deque<Node> dq = new LinkedList<>();
    dq.addFirst(new Node(1, 1));
    while(true) {
      ans++;

      // 머리 늘리기
      int ny = dq.peekFirst().y + dy[d];
      int nx = dq.peekFirst().x + dx[d];
      if(ny < 1 || nx < 1 || ny > N || nx > N) break;
      if(map[ny][nx] >= 1) break;

      dq.addFirst(new Node(ny, nx)); // 머리 추가

      if(map[ny][nx] == -1) { // 사과가 있다. -> 꼬리 가만히 있기
        cur_size++; map[ny][nx] = 0;
      } else { // 사과가 없다. -> 몸을 수축시키기
        Node tail = dq.pollLast();
        int ty = tail.y;
        int tx = tail.x;
        map[ty][tx] = 0; // 수축
        }

      map[ny][nx] = 1; // 머리를 표시;

      // 방향 전환
      if(!list.isEmpty() && list.peek().time == ans) { // 방향 바꾸어야함
        Turn turn = list.poll();
        if(turn.direction.equals("D")) { // 오른쪽
          d = (d+1)%4;
        } else {
          d = (d+4-1)%4;
        }

      }

    }

    System.out.println(ans);

  }
}