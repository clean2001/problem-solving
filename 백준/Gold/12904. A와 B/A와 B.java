import java.io.*;
import java.util.*;

class Main {
  static int N, k;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb1 = new StringBuilder(br.readLine());
    StringBuilder sb2 = new StringBuilder(br.readLine());

    // sb2 -> sb1으로 가기!
    while(sb1.length() != sb2.length()) {
//      System.out.println(sb1.length() + " " + sb2.length());
      if(sb2.charAt(sb2.length()-1) == 'A') { // 맨뒤가 A이면, A떼기
        sb2.delete(sb2.length()-1, sb2.length());
      } else { // 맨뒤가 B이 B떼고 뒤집기
        sb2.delete(sb2.length()-1, sb2.length());
        sb2.reverse();
      }
    }

    if(sb1.toString().equals(sb2.toString())) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }
}