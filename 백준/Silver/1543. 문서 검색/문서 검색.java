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
    String sub = br.readLine();

    int ans = 0;
    for(int i=0; i<=s.length()-sub.length(); ++i) {
      boolean same = true;
      for(int j=0; j<sub.length(); ++j) {
        if(sub.charAt(j) != s.charAt(j + i)) {
          same = false; break;
        }
      }

      if(same) {
        ans++;
        i = i + sub.length()-1;
      }
    }

    System.out.println(ans);
  }

}