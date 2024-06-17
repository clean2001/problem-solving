import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    List<String> list = new ArrayList<>();

    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      list.add(s);
    }

    Collections.sort(list, (a, b) -> {
      if(a.length() == b.length()) return a.compareTo(b);
      return a.length() - b.length();
    });

    list.stream().distinct().forEach(System.out::println);
  }
}