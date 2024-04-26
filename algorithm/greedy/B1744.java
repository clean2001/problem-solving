import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 1744. 수묶기
class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> positive = new ArrayList<>();
    ArrayList<Integer> negative = new ArrayList<>();
    int zeroCnt = 0, oneCnt = 0;
    int pIdx = 0, nIdx = 0, pCnt = 0, nCnt = 0;

    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; ++i) {
      int num = Integer.parseInt(br.readLine());

      if(num > 1) {
        positive.add(num);
      } else if(num < 0) {
        negative.add(num);
      } else if(num == 0){
        zeroCnt++;
      } else {
        oneCnt++;
      }
    }

    positive.sort(Collections.reverseOrder());
    Collections.sort(negative);

    int ans = oneCnt;
    // 양수 처리;
    while(pIdx < positive.size()-1) {
      int a = positive.get(pIdx++);
      int b = positive.get(pIdx++);

      ans += a * b;
    }

    while(pIdx < positive.size()) {
      ans += positive.get(pIdx++);
    }

    // 음수 처리
    while(nIdx < negative.size()-1) {
      int a = negative.get(nIdx++);
      int b = negative.get(nIdx++);

      ans += a * b;

    }

    // 0을 음수와 곱해서 처리하기
    while(nIdx < negative.size() && zeroCnt > 0) {
      nIdx++; zeroCnt--;
    }

    while(nIdx < negative.size()) {
      ans += negative.get(nIdx++);
    }

    System.out.println(ans);
  }
}