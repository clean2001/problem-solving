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

    int M, N;
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    boolean[] chk = new boolean[N+1];
    chk[1] = true;
    for(int i=2; i<N; ++i) {
      if(chk[i]) continue; // 합성수로 이미 체크돼있다면 패스
      for(int j=2; i*j<=N; ++j) {
        chk[i*j] = true; // 합성수 체크
      }
    }

    for(int i=M; i<=N; ++i) {
      if(!chk[i]) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
  }

}