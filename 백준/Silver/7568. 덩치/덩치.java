import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      list.add(new int[]{w, h});
    }

    for(int i=0; i<N; ++i) {
      int w = list.get(i)[0];
      int h = list.get(i)[1];

      int grade = 0;
      for(int j=0; j<N; ++j) {
        if(i == j) continue;

        if(list.get(j)[0] > w && list.get(j)[1] > h) grade++;
      }

      bw.write(grade + 1 + " ");
    }

    bw.flush();
  }

}