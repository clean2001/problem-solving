import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] map;
  static int ans = -1;

  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    String[] arr = br.readLine().split("");
    Map<String, Integer> priority = new HashMap<>();
    Deque<String> stack = new LinkedList<>();

    StringBuilder sb = new StringBuilder();
    for(String s : arr) {
//      System.out.println(stack);
      if(s.equals("-") || s.equals("+")) {
        if(!stack.isEmpty() && (stack.peekLast().equals("*") || stack.peekLast().equals("/") || stack.peekLast().equals("-") || stack.peekLast().equals("+"))) {
          while(true) {
            if(stack.isEmpty() || !(stack.peekLast().equals("*") || stack.peekLast().equals("/") || stack.peekLast().equals("-") || stack.peekLast().equals("+"))) {
              break;
            }

            sb.append(stack.pollLast());
          }
          stack.addLast(s);
        } else {
          stack.addLast(s);
        }
      } else if(s.equals("(")) {
        stack.addLast(s);
      } else if(s.equals(")")) {
        while(!stack.peekLast().equals("(")) {
          sb.append(stack.pollLast());
        }
        stack.pollLast();
      } else if(s.equals("*") || s.equals("/")) {
        if(!stack.isEmpty() && (stack.peekLast().equals("*") || stack.peekLast().equals("/"))) {
          while(true) {
            if(stack.isEmpty() || !(stack.peekLast().equals("*") || stack.peekLast().equals("/"))) {
              break;
            }

            sb.append(stack.pollLast());
          }
          stack.addLast(s);
        } else {
          stack.addLast(s);
        }
      } else {
        sb.append(s);
      }
    }

    while(!stack.isEmpty()) {
      sb.append(stack.pollLast());
    }

    bw.write(sb.toString() + "\n");
    bw.flush();
  }

}