import java.io.*;
import java.util.*;

class Main {
  static class Snowman implements Comparable<Snowman> {
    long a, b;

    Snowman(long a, long b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Snowman s) {
      return (int)((this.a + this.b) - (s.a + s.b));
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[] snows = new long[N+1];
    Map<Long, Integer> cnt = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      snows[i] = Long.parseLong(st.nextToken());
      Integer c = cnt.get(snows[i]);
      if(c == null) {
        cnt.put(snows[i], 1);
      } else {
        cnt.put(snows[i], c+1);
      }
    }

    ArrayList<Snowman> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      for(int j=i+1; j<N; ++j) {
        if(i == j) continue;

        list.add(new Snowman(snows[i], snows[j]));
      }
    }

    Collections.sort(list);
    int ans = Integer.MAX_VALUE;
    for(int i=0; i<list.size()-1; ++i) {
      Snowman s1 = list.get(i);
      Snowman s2 = list.get(i+1);

      Map<Long, Integer> tempCnt = new HashMap<>();
      tempCnt.put(s1.a, 1);
      Integer c = tempCnt.get(s1.b);
      if(c != null) {
        tempCnt.put(s1.b, c+1);
      } else {
        tempCnt.put(s1.b, 1);
      }

      c = tempCnt.get(s2.a);
      if(c != null) {
        tempCnt.put(s2.a, c+1);
      } else {
        tempCnt.put(s2.a, 1);
      }

      c = tempCnt.get(s2.b);
      if(c != null) {
        tempCnt.put(s2.b, c+1);
      } else {
        tempCnt.put(s2.b, 1);
      }

      boolean flag = true;
      for(Map.Entry<Long, Integer> e : tempCnt.entrySet()) {
        Long key = e.getKey();
        Integer curCnt = e.getValue();
        int actualCnt = cnt.get(key);

        if(curCnt > actualCnt) {
          flag = false; break;
        }
      }

      if(!flag) continue;


      int diff = Math.abs((int)(s1.a + s1.b - s2.a - s2.b));
      if(ans > diff) {
        ans = diff;
//        System.out.println(s1.a + " " + s1.b + " " + s2.a + " " + s2.b);
      }
    }
    System.out.println(ans);

  }
}