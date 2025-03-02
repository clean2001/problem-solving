import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    while((input = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(input);

      if(!st.hasMoreTokens()) {
        break;
      }

      String sub = st.nextToken();
      String total = st.nextToken();

      int idx1 = 0, idx2 = 0;
      boolean isOk = false;
      while(idx2 < total.length()) {
        if(sub.charAt(idx1) == total.charAt(idx2)) {
          idx1++; idx2++;
        } else {
          idx2++;
        }

        if(idx1 == sub.length()) {
          isOk = true; break;
        }
      }

      if(isOk) {
        bw.write("Yes\n");
      } else {
        bw.write("No\n");
      }
    }

    bw.flush();
  }
}