import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] s = br.readLine().split("");
    List<String> collect = Arrays.stream(s).sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
    int sum = 0;
    for(String a : collect) {
      sum += Integer.parseInt(a);
    }
    if(!collect.get(collect.size() - 1).equals("0") || sum % 3 != 0) {
      System.out.println(-1);
    } else {
      for(String a : collect) {
        bw.write(a);
      }

      bw.flush();
    }
  }
}