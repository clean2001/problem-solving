import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      Integer cnt = map.getOrDefault(s, 0);
      map.put(s, cnt+1);
    }

    int maxVal = -1;
    String ans = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if(maxVal < entry.getValue() || (maxVal == entry.getValue() && entry.getKey().compareTo(ans) < 0)) {
        maxVal = entry.getValue();
        ans = entry.getKey();
      }
    }

    System.out.println(ans);
  }

}