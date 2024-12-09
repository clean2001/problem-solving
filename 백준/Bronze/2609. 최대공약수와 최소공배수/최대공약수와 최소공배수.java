import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 최대 공약수 구하기 -> gcb(a, b) = gcb(b, a % b)
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.println(gcb(Math.min(a, b), Math.max(a, b)));

    // 최소 공배수 구하기
    int k = Math.max(a, b);
    for(int i=k; i<=a * b; ++i) {
      if(i % a == 0 && i % b == 0) {
        System.out.println(i);
        break;
      }
    }
  }

  private static int gcb(int a, int b) {
    if(b == 0) return a;

    return gcb(b, a % b);
  }
}