
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = "";
    while(true) {
      s = br.readLine();

      if(s.equals("0")) break;
      
      boolean isPal = true;
      for(int i=0; i<s.length(); ++i) {
        if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
          isPal = false;
          break;
        }
      }

      if(isPal) {
        bw.write("yes\n");
      } else {
        bw.write("no\n");
      }
    }

    bw.flush();
  }
}
