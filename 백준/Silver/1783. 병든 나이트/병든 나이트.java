import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 만약 위에 2칸 여유가 있으면? => 1과 4를 반복
    // 만약 위에 1칸 밖에 여유가 없으면? => 2, 3을 해야함
    // 만약 옆에 여유가 없으면? => 끝

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 세로
    int M = Integer.parseInt(st.nextToken()); // 가로

    if(N == 1 || M == 1) {
      System.out.println(1);
    } else if(N == 2) {
      System.out.println(Math.min(4, (M - 1) / 2 + 1)); // 여기 4 때문에..??
    } else if(N >= 3 && M < 7) {
      System.out.println(Math.min(4, M));
    } else { // 4번 이상 되는 경우
      System.out.println(4 + (M - 6));
    }

  }
}