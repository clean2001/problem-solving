import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int turn = 0;
    while(true) {
      turn++;
      int N = Integer.parseInt(br.readLine());

      if(N == 0) break;

      int[][] arr = new int[N][N-1];
      List<String> names = new ArrayList<>();
      boolean isPresent = false;

      for(int i=0; i<N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = st.nextToken();
        names.add(name);

        for(int j=0; j<N-1; ++j) {
          String status = st.nextToken();

          if(status.equals("P")) {
            arr[i][j] = 1;
          } else {
            arr[i][j] = 0;
            isPresent = true;
          }
        }
      }

      bw.write("Group " + turn + "\n");
      if(isPresent) {
        for(int i=0; i<N; ++i) {
          for(int j=0; j<N-1; ++j) {
            if(arr[i][j] == 0) {
              String from = names.get((N - (j + 1) + i) % N);
              String to = names.get(i);

              bw.write(from + " was nasty about " + to + "\n");
            }
          }
        }
      } else {
        bw.write("Nobody was nasty\n");
      }

      bw.write("\n");
    }

    bw.flush();
  }

}