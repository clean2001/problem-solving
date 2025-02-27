import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    if(N > 0) {
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = N > 0 ? 1 : 0;
    int sum = 0;

    // 박스에 순서대로 책을 넣어야하는게 조건이다
    for(int x : arr) {
      sum += x;
      if(sum > M) {
        cnt++;
        sum = x;
      }
    }
    System.out.println(cnt);
  }
}