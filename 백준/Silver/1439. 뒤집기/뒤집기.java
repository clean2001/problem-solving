import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int zero = 0;
    int one = 0;
    char cur = ' ';
    for(int i=0; i<s.length(); ++i) {
      if(s.charAt(i) != cur && s.charAt(i) == '0') {
        zero++;
        cur = s.charAt(i);
      } else if(s.charAt(i) != cur && s.charAt(i) == '1') {
        one++;
        cur = s.charAt(i);
      }
    }

    System.out.println(Math.min(zero, one));
  }
}