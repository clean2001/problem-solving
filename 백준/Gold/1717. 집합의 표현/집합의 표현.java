import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  private static int[] parent;
  private static void unite(int a, int b) {
    int p1 = findParent(a);
    int p2 = findParent(b);
    parent[p1] = parent[p2];
  }

  private static int findParent(int a) {
    if(parent[a] == a) return a;
    return parent[a] = findParent(parent[a]);

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[N+1];
    for(int i=1; i<=N; ++i) {
      parent[i] = i;
    }

    for(int i=0; i<M; ++i) {
      st =  new StringTokenizer(br.readLine());
      int operator = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(operator == 0) {
        unite(a, b);
      } else {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if(p1==p2) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }

  }
}