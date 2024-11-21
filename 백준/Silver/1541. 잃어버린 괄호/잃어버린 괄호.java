import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    int status = 0; // 0: 숫자가 나오는 중, 1: 마이너스
    int num = 0;
    int minus = 0;
    int total = 0;
    Deque<Integer> dq = new LinkedList<>();
    for(int i=0; i<s.length(); ++i) {
      char c = s.charAt(i);

      if(c >= '0' && c <= '9') {
        dq.addLast(c - '0');
      } else if(c == '-') {
        num = makeNum(dq);
        dq = new LinkedList<>();
//        System.out.println(num + " " + total);
        if(status == 1) { // 이미 마이너스 진행중
          total -= minus;
          total -= num;
          minus = 0;
        } else {
          total += num;
          status = 1;
        }

      } else { // +일때
        num = makeNum(dq);
        dq = new LinkedList<>();
//        System.out.println(num + " " + total);
        if(status == 1) {
          minus += num;
        } else {
          total += num;
        }

      }
    }

    num = makeNum(dq);
    if(status == 1) {
      total -= minus;
      total -= num;
    } else {
      total += num;
    }

    System.out.println(total);
  }

  private static int makeNum(Deque<Integer> dq) {
    int loc = 1;
    int ans = 0;
    while(!dq.isEmpty()) {
      ans += loc * dq.pollLast();
      loc *= 10;
    }

    return ans;
  }
}