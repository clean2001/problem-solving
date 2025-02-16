import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  private static boolean[] vis;
  private static int ans = 0;
  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] A = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; ++i) {
        A[i] = Integer.parseInt(st.nextToken());
      }

      int M = Integer.parseInt(br.readLine());
      int[] B = new int[M];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<M; ++i) {
        B[i] = Integer.parseInt(st.nextToken());
      }

      int K = Integer.parseInt(br.readLine());
      int[] C = new int[K];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<K; ++i) {
        C[i] = Integer.parseInt(st.nextToken());
      }


      Set<Integer> set = new HashSet<>();
      for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
          for(int l = 0; l < K; ++l) {
            int cur = A[i] + B[j] + C[l];
            if(chk(cur)) {
              set.add(cur);
            }
          }
        }
      }

      System.out.println(set.size());
    }
  }


  private static boolean chk(int cur) {
    while(cur > 0) {
      int a = cur % 10;
      cur /= 10;

      if(!(a == 5 || a == 8)) return false;
    }

    return true;
  }

}