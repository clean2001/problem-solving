import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    String[] sArr = s.split("");
    Arrays.sort(sArr, Comparator.reverseOrder());

    Arrays.asList(sArr).stream().forEach(System.out::print);

  }
}