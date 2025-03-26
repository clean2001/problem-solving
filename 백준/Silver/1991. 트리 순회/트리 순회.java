import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
//////////////////////////////////////////////////////////////////////////////

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static Node[] nodes;

  static class Node {
    int left;
    int right;
  }

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());

    nodes = new Node[N]; // 알파벳 - 'A'
    for(int i=0; i<N; ++i) {
      nodes[i] = new Node();
    }

    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int cur = st.nextToken().charAt(0) - 'A';


      String left = st.nextToken();
      String right = st.nextToken();

      if(left.equals(".")) {
        nodes[cur].left = -1;
      } else {
        int leftNum = left.charAt(0) - 'A';
        nodes[cur].left = leftNum;
      }

      if(right.equals(".")) {
        nodes[cur].right = -1;
      } else {
        int rightNum = right.charAt(0) - 'A';
        nodes[cur].right = rightNum;
      }
    }

    preorder(0);
    bw.write("\n");
    inorder(0);
    bw.write("\n");
    postorder(0);
    bw.flush();
  }

  private static void preorder(int cur) throws Exception {
    if(cur == -1) return;

    bw.write(cur + 'A');
    preorder(nodes[cur].left);
    preorder(nodes[cur].right);

  }

  private static void inorder(int cur) throws Exception {

    if(cur == -1) return;

    inorder(nodes[cur].left);
    bw.write(cur + 'A');
    inorder(nodes[cur].right);
;
  }

  private static void postorder(int cur) throws Exception {
    if(cur == -1) return;

    postorder(nodes[cur].left);
    postorder(nodes[cur].right);
    bw.write(cur + 'A');
  }
}