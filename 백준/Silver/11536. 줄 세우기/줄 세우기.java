import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  private static int[] vis = new int[1000000];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    List<String> origin = new ArrayList<>();
    List<String> sortedList = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      origin.add(br.readLine());
      sortedList.add(origin.get(i));
    }

    sortedList = sortedList.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());

    String ans = "NEITHER";
    boolean isOk = true;
    for(int i=0; i<N; ++i) {
      if(!sortedList.get(i).equals(origin.get(i))) {
        isOk = false; break;
      }
    }

    if(isOk) {
      ans = "INCREASING";
    } else {
      isOk = true;
      for(int i=0; i<N; ++i) {
        if(!sortedList.get(N - i - 1).equals(origin.get(i))) {
          isOk = false;
          break;
        }
      }
      if(isOk) {
        ans = "DECREASING";
      }
    }

    System.out.println(ans);

    bw.flush();
  }

}