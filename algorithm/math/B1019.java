import java.io.*;
import java.util.*;

// 1019. 책 페이지
class Main {
  static int N;
  static int[] ret = new int[10];
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    int s = 1;
    int e = N;

    int size = 1;
    while(true) {
      // s의 1의 자리 0으로 하기
      while(s%10 != 0 && s < e) {
        calc(s, size);
        s++;
      }

      // e의 1의 자리 9로 하기
      while(e%10 != 9 && e > s) {
        calc(e, size);
        e--;
      }

      if(s == e) {
        calc(s, size);
        break;
      }

      s /= 10; e /= 10;
      int tmp = (e - s + 1) * size;
      for(int i=0; i<=9; ++i) ret[i] += tmp;

      size *= 10;

    }

    for(int i=0; i<=9; ++i) System.out.print(ret[i] + " ");

  }

  static void calc(int k, int size) {
//    if(k%10 == 0) ret[0]++;
    while(k > 0) {
      ret[k%10] += size;
      k /= 10;
    }
  }
}