import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 첫번째 수로 양의 정수
    // 두번째 수는 양의 정수 중 하나
    // 세번째부터는 이후에 나오는 모든 수는 앞의 앞의 수에서 앞의 수를 빼서 만듦

    int N = Integer.parseInt(br.readLine());
    List<Integer> ans = new ArrayList<>();
    int cnt = -1;
    for(int i=1; i<=N; ++i) {
      List<Integer> list = new ArrayList<>();
      int cur = i;
      int prev = N;
      list.add(N);
      list.add(cur);
      while(true) {
        int a = prev - cur;
        prev = cur;
        cur = a;

        if(cur < 0) {
          break;
        }

        list.add(cur);
      }

      if(list.size() > cnt) {
        ans = list;
        cnt = list.size();
      }
    }

    bw.write(ans.size() + "\n");
    for(int i=0; i<ans.size(); ++i) {
      bw.write(ans.get(i) + " ");
    }

    bw.flush();
  }

}