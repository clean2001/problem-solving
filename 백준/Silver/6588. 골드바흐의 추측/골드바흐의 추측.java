import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 소수체크
    boolean[] compo = new boolean[1000001];
    compo[1] = true;
    for(int i=2; i<=1000000; i++) {
      if(compo[i]) continue;
      for(int j=i+i; j<=1000000; j += i) {
        compo[j] = true;
      }
    }

    while(true) {
      int N = Integer.parseInt(br.readLine());
      if(N == 0) break;

      boolean isOk = false;
      for(int i=3; i<=N/2; ++i) {
        int a = i;
        int b = N - i;
        if(compo[a] || compo[b]) continue;

        bw.write(N + " = " + a + " + " + b + "\n");
        isOk = true;
        break;
      }

      if(!isOk) {
        bw.write("Goldbach's conjecture is wrong.\n");
      }
    }

    bw.flush();
  }
}