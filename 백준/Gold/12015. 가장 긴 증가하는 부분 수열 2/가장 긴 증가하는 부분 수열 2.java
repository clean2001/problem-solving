import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
  public static int[] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      int cur = arr[i];
      int ret = binarySearch(cur, list);

      if(ret >= list.size()) {
        list.add(arr[i]);
      } else {
        list.set(ret, cur);
      }
    }

    System.out.println(list.size());
  }
  private static int binarySearch(int target, List<Integer> list) {
    int start = 0;
    int end = list.size()-1;
    while(start <= end) {
      int mid = (start + end) / 2;

      if(list.get(mid) == target) {
        return mid;
      } else if(list.get(mid) < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return start; // 하나 다음의 인덱스를 반환
  }
}