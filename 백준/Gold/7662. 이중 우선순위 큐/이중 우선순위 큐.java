import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int R, C, T;
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      Queue<long[]> maxPq = new PriorityQueue<>((a, b) -> {if(a[0] < b[0]) return 1; return -1;});
      Queue<long[]> minPq = new PriorityQueue<>((a, b) -> {if(a[0] < b[0]) return -1; return 1;});

      int K = Integer.parseInt(br.readLine());
      for(int i=0; i<K; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String cmd = st.nextToken();
        long num = Integer.parseInt(st.nextToken());

        if(cmd.equals("I")) {
          long[] arr = new long[]{num, 1};
          maxPq.add(arr);
          minPq.add(arr);
        } else if(num == -1) {
          while(!minPq.isEmpty()) {
            long[] top = minPq.peek();
            if(top[1] == 0) minPq.poll();
            else break;
          }

          if(!minPq.isEmpty()) {
            long[] top = minPq.poll();
            top[1] = 0;
          }
        } else {
          while(!maxPq.isEmpty()) {
            long[] top = maxPq.peek();
            if(top[1] == 0) maxPq.poll();
            else break;
          }

          if(!maxPq.isEmpty()) {
            long[] top = maxPq.poll();
            top[1] = 0;
          }
        }
      }

//      System.out.println(maxPq.size() + " " + minPq.size());

      long[] maxRet = null, minRet = null;
      while(!maxPq.isEmpty()) {
        if (maxPq.peek()[1] == 0) maxPq.poll();
        else {
          maxRet = maxPq.poll();
          break;
        }
      }

      while(!minPq.isEmpty()) {
        if (minPq.peek()[1] == 0) minPq.poll();
        else {
          minRet = minPq.poll();
          break;
        }
      }
      if(minRet == null && maxRet == null) {
        bw.write("EMPTY\n");
      } else{
        bw.write(maxRet[0] + " " + minRet[0]+"\n");
      }
    }

    bw.flush();
  }
}