import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int W = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int N = Integer.parseInt(br.readLine());
    List<Integer> w = new ArrayList<>();
    List<Integer> h = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(a == 1) {
        w.add(b);
      } else {
        h.add(b);
      }
    }

    Collections.sort(w);
    Collections.sort(h);

    int diff1 = 0;
    if(w.size() == 0) {
      diff1 = W;
    } else if(w.size() == 1) {
      diff1 = Math.max(w.get(0), W - w.get(0));
    } else {
      diff1 = w.get(0);
      for(int i=1; i<w.size(); ++i) {
        diff1 = Math.max(diff1, w.get(i) - w.get(i-1));
      }
      diff1 = Math.max(diff1, W - w.get(w.size()-1));
    }


    int diff2 = 0;
    if(h.size() == 0) {
      diff2 = H;
    } else if(h.size() == 1) {
      diff2 = Math.max(h.get(0), H - h.get(0));
    } else {
      diff2 = h.get(0);
      for(int i=1; i<h.size(); ++i) {
        diff2 = Math.max(diff2, h.get(i) - h.get(i-1));
      }
      diff2 = Math.max(diff2, H - h.get(h.size()-1));
    }

//    System.out.println(diff1 + " " + diff2);
    System.out.println(diff1 * diff2);
  }

}