import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r1 = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
    int r2 = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

    System.out.println(r1 + r2);
  }

}