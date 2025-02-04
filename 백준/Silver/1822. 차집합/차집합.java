import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int A, B;
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    Set<Integer> aset = new TreeSet<>();


    st = new StringTokenizer(br.readLine());
    for(int i=0; i<A; ++i) {
      aset.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<B; ++i) {
      aset.remove(Integer.parseInt(st.nextToken()));
    }

    if(aset.isEmpty()) {
      bw.write("0\n");
    } else {
      bw.write(aset.size() + "\n");
      for(int element : aset) {
        bw.write(element + " ");
      }
    }

    bw.flush();
  }

}