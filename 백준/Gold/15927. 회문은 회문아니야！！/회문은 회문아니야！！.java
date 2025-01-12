import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();

    boolean isPal = true;
    boolean isMono = true;
    char center = s.charAt(s.length() / 2);
    for(int i=0; i<s.length() / 2; ++i) {
      if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
        isPal = false;
        isMono = false;
        break;
      }

      if(s.charAt(i) != center) isMono = false;
    }

    if(isMono) {
      bw.write("-1\n");
    } else if(isPal) {
      bw.write(s.length() - 1 + "\n");
    } else {
      bw.write(s.length() + "\n");
    }

    bw.flush();
  }

}