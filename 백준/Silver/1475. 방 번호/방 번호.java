import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[10];
    String s = br.readLine();

    for(int i=0; i<s.length(); ++i) {
      char c = s.charAt(i);

      arr[c - '0']++;
    }

    int maxVal = (arr[6] + arr[9] + 1) / 2;
    for(int i=0; i<=8; ++i) {
      if(i == 6) continue;

      maxVal = Math.max(maxVal, arr[i]);
    }

    System.out.println(maxVal);
  }

}