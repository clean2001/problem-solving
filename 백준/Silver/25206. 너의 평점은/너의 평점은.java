import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Map<String, Double> map = new HashMap<String ,Double>() {
      {
        put("A+", 4.5);
        put("A0", 4.0);
        put("B+", 3.5);
        put("B0", 3.0);
        put("C+", 2.5);
        put("C0", 2.0);
        put("D+", 1.5);
        put("D0", 1.0);
        put("F", 0.0);
      }

    };
    
    
    double sum = 0;
    double cnt = 0;
    for(int i=0; i<20; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String subject = st.nextToken();
      double time = Double.parseDouble(st.nextToken());
      String grade = st.nextToken();

      if(grade.equals("P")) continue;

      Double score = map.get(grade);


      sum += (time * score);
      cnt += time;
    }

    bw.write((sum / cnt) + "\n");
    bw.flush();
  }
}