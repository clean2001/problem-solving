import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static Map<String, Integer> strToInt = new HashMap<>();
  static Map<Integer, String> intToStr = new HashMap<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for(int i=1; i<=N; ++i) {
      String pokemon = br.readLine();
      strToInt.put(pokemon, i);
      intToStr.put(i, pokemon);
    }

    for(int i=1; i<=M; ++i) {
      String cmd = br.readLine();
      String retStr = "";
      int retInt = 0;
      try{
        int number = Integer.parseInt(cmd);
        retStr = intToStr.get(number);
        bw.write(retStr + "\n");
      } catch(Exception e) {
        retInt = strToInt.get(cmd);
        bw.write(retInt + "\n");
      }
    }

    bw.flush();
  }
}