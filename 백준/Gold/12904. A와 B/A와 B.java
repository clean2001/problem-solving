import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S, T;
    S = br.readLine();
    T = br.readLine();

    StringBuilder sb = new StringBuilder(T);
    while(sb.length() != S.length()) {
      char last = sb.charAt(sb.length() - 1);
      if(last == 'A') { // 그냥 떼기
        sb.delete(sb.length() - 1, sb.length());
      } else {
        sb.delete(sb.length()-1, sb.length());
        sb.reverse();
      }
    }

    if(sb.toString().equals(S)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}