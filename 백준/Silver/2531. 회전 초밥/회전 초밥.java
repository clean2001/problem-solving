import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, d, k, c;
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    int[] cnt = new int[d+1];
    Set<Integer> s = new HashSet<>();


    // 입력 받기
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=0; i<k; ++i) {
      cnt[arr[i]]++; // 개수 세기
      s.add(arr[i]);
    }

    int ans = 0;
    for(int i=0; i<N; ++i) {

      // ans 갱신
      if(s.contains(c)) {
        ans = Math.max(ans, s.size());
      } else {
        ans = Math.max(ans, s.size() + 1);
      }

      int right = (i + k) % N;
      s.add(arr[right]);
      cnt[arr[right]]++;
      cnt[arr[i]]--;

      if(cnt[arr[i]] == 0) {
        s.remove(arr[i]);
      }
    }

    System.out.println(ans);


  }

}