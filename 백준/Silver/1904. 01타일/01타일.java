import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    // 1과 00은 한쪽 방향에만 붙일 수 있다.
    int num1 = 1;
    int num2 = 2;


    for(int i=3; i<=n; i++){
      int newNum = (num1 + num2) % 15746;
      num1 = num2;
      num2 = newNum;
    }

    if(n == 1) System.out.println(num1);
    else System.out.println(num2);
  }
}