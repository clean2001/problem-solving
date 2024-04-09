import java.io.*;
import java.util.*;
// B16235 나무 재테크
class Main {
  static int N, M, K;
  static int[][] nutri;
  static int[][] map;
  static Deque<Tree>[][] tree;
  static int tree_idx = M;
  static int ans = M;

  static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
  static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

  static class Tree implements Comparable<Tree> {
    int y, x;
    int idx;
    int year;

    public Tree(int y, int x, int idx, int year) {
      this.y = y;
      this.x = x;
      this.idx = idx;
      this.year = year;
    }

    public int compareTo(Tree t) {
      return this.year - t.year;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    nutri = new int[N+1][N+1];
    map = new int[N+1][N+1];
    tree = new Deque[N+1][N+1];
    for(int i=0; i<N+1; ++i) {
      for(int j=0; j<N+1; ++j) {
        tree[i][j] = new LinkedList<>();
      }
    }

    for(int i=1; i<=N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; ++j) {
        nutri[i][j] = Integer.parseInt(st.nextToken());
        map[i][j] = 5;
      }
    }

    for(int i=1; i<=M; ++i) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int year = Integer.parseInt(st.nextToken());

      tree[y][x].add(new Tree(y, x, i, year));
    }

    ans = M;
    for(int year = 1; year <= K; ++year) {
      int[][] die = new int[N + 1][N + 1];
      ArrayList<Tree> removed = new ArrayList<>();
      // 봄 -> 양분을 먹고 나이 증가.
      for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {

          if (tree[i][j].isEmpty())
            continue;

          Deque<Tree> list = tree[i][j];
          // 봄
          for (int k = 0; k < list.size();) {
            Tree t = list.poll();
            if (map[i][j] >= t.year) {
              map[i][j] -= t.year;
              t.year++;
              k++; //
              list.add(t);
            } else {
              removed.add(t); // 버리기
              ans--;
            }
          }
        }
      }

      // 여름 -> 거름
      for (Tree t : removed) {
        map[t.y][t.x] += t.year/2;

      }

      // 가을 -> 번식
      for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
          if (tree[i][j].isEmpty())
            continue;
          Deque<Tree> list = tree[i][j];
          for (Tree t : list) {
            if (t.year % 5 == 0) { // 나이가 5의 배수
              for (int n = 0; n < 8; ++n) {
                int ny = i + dy[n], nx = j + dx[n];
                if (ny < 1 || nx < 1 || ny > N || nx > N)
                  continue;
                tree[ny][nx].addFirst(new Tree(ny, nx, ++tree_idx, 1));
                ans++;
              }
            }
          }
        }
      }

      // 겨울 -> 양분 추가
      for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
          map[i][j] += nutri[i][j];
        }
      }
    }

    bw.write(ans + "\n");
    bw.flush();

  }


}