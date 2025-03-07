import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<n; ++i) {
      int k = Integer.parseInt(br.readLine());
      list.add(k);
    }

    // 정렬하기
    Collections.sort(list);

    // 커트 구하기
    int exclude = (int)Math.round((double)n * 0.15);

    int sum = 0;
    for(int i=exclude; i<n-exclude; ++i) {
      sum += list.get(i);
    }


    System.out.println(Math.round((double)sum / (n-2*exclude)));

  }
}