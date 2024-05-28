import java.io.*;
import java.util.*;

class Main {
  static class Person implements Comparable<Person> {
    int idx;
    double height;
    String name;

    Person(int idx, double height, String name) {
      this.idx = idx;
      this.height = height;
      this.name = name;
    }

    public int compareTo(Person p) {
      if(p.height == this.height) {
        return this.idx - p.idx;
      }

      if(this.height > p.height) {
        return -1;
      } else {
        return 1;
      }
    }

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      int N = Integer.parseInt(br.readLine());
      if(N == 0) break;

      ArrayList<Person> list = new ArrayList<>();
      for(int i=0; i<N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = st.nextToken();
        double height = Double.parseDouble(st.nextToken());
        list.add(new Person(i, height, name));
      }

      Collections.sort(list);

      double maxHeight = list.get(0).height;
      for(Person p : list) {
        if(p.height == maxHeight) {
          bw.write(p.name + " ");
        } else {
          break;
        }
      }

      bw.write("\n");
    }

    bw.flush();
  }
}